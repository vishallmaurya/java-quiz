package quiz;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import auth.Authenticate;
import db.CreateConnection;

public class Result implements ActionListener{

	private JFrame frame;
	private JButton profileBtn;
	private JLabel Total ;
	private JLabel Attempted ;
	private JLabel Correct ;
	private JLabel Wrong ;
	private JButton Quit ;
	private JButton Play_Again ;
	private int attempt, correct;
	private String subject;

	public Result(String subject, int att, int corr) {
		attempt = att;
		correct = corr;
		this.subject = subject;
		store_result();
		initialize();

		profileBtn.addActionListener(this);
		Quit.addActionListener(this);
		Play_Again.addActionListener(this);
	}
	
	private void store_result() {
		MongoDatabase database = CreateConnection.getDatabase();
		MongoCollection<Document> categoryCollection = database.getCollection("category");
		MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");

		Document categoryInfo = categoryCollection.find(new Document("category", subject)).first();
		Document newGamePlay = new Document("subject_chosen", categoryInfo.getObjectId("_id"))
								.append("total_attempts", attempt)
								.append("total_correct", correct).append("user_id", Authenticate.getUser());

		gamePlayCollection.insertOne(newGamePlay);
		CreateConnection.closeConnection();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		profileBtn = new JButton("Profile");
		profileBtn.setBackground(new Color(253, 245, 230));
		profileBtn.setFont(new Font("Stencil", Font.PLAIN, 16));
		profileBtn.setBounds(650, 5, 100, 40);
		frame.getContentPane().add(profileBtn);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Total = new JLabel("TOTAL QUESTION = 10 ", JLabel.CENTER);
		Total.setFont(new Font("Stencil", Font.BOLD, 26));
		Total.setForeground(Color.WHITE);
		Total.setBounds(126, 161, 529, 33);
		panel.add(Total);
		
		Attempted = new JLabel("YOU ATTEMPTED = " + attempt, JLabel.CENTER);
		Attempted.setFont(new Font("Stencil", Font.BOLD, 26));
		Attempted.setForeground(Color.WHITE);
		Attempted.setBounds(123, 213, 532, 33);
		panel.add(Attempted);
		
		Correct = new JLabel("CORRECT ANSWERS = " + correct, JLabel.CENTER);
		Correct.setFont(new Font("Stencil", Font.BOLD, 26));
		Correct.setForeground(Color.WHITE);
		Correct.setBounds(126, 276, 529, 33);
		panel.add(Correct);
		
		Wrong = new JLabel("WRONG ANSWERS = " + (attempt - correct), JLabel.CENTER);
		Wrong.setForeground(Color.WHITE);
		Wrong.setFont(new Font("Stencil", Font.BOLD, 26));
		Wrong.setBounds(126, 344, 529, 33);
		panel.add(Wrong);
		
		Play_Again = new JButton("PLAY AGAIN");
		Play_Again.setFont(new Font("Stencil", Font.BOLD, 22));
		Play_Again.setBackground(new Color(253, 245, 230));
		Play_Again.setBounds(50, 406, 172, 44);
		panel.add(Play_Again);
		
		Quit = new JButton("QUIT");
		Quit.setBackground(new Color(253, 245, 230));
		Quit.setFont(new Font("Stencil", Font.BOLD, 22));
		Quit.setBounds(579, 406, 150, 44);
		panel.add(Quit);
		
		JLabel Scorecard = new JLabel("SCORECARD", JLabel.CENTER);
		Scorecard.setHorizontalAlignment(SwingConstants.CENTER);
		Scorecard.setForeground(Color.WHITE);
		Scorecard.setFont(new Font("Stencil", Font.BOLD, 58));
		Scorecard.setBounds(110, 28, 512, 100);
		panel.add(Scorecard);
		
		JLabel img = new JLabel("New label");
		img.setBounds(0, 0, 784, 461);
		img.setIcon(new ImageIcon("./public/images/faded5.jpg"));
		panel.add(img);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == profileBtn) {
			frame.setVisible(false);
			frame.dispose();
			Profile profile = new Profile(Authenticate.getUser());
			profile.getFrame().setVisible(true);
		}

		if (ae.getSource() == Play_Again) {
			frame.setVisible(false);
			frame.dispose();
			Buttons buttons = new Buttons();
			buttons.getFrame().setVisible(true);
		}

		if (ae.getSource() == Quit) {
			System.exit(0);
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
}