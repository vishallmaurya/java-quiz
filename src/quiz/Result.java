// package quiz;

// import java.awt.* ;
// import java.awt.event.* ;
// import javax.swing.* ;

// import org.bson.Document;

// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;

// import auth.Authenticate;
// import db.CreateConnection;

// public class Result implements ActionListener{

// 	private JFrame frame;
// 	private JButton profileBtn;
// 	private JLabel Total ;
// 	private JLabel Attempted ;
// 	private JLabel Correct ;
// 	private JLabel Wrong ;
// 	private JButton Quit ;
// 	private JButton Play_Again ;
// 	private int attempt, correct;
// 	private String subject;

// 	public Result() {
// 		store_result();
// 		initialize();

// 		profileBtn.addActionListener(this);
// 		Quit.addActionListener(this);
// 		Play_Again.addActionListener(this);
// 	}

// 	public void setData(String subject, int att, int corr) {
// 		attempt = att;
// 		correct = corr;
// 		this.subject = subject;
// 	}
	
// 	private void store_result() {
// 		try {
// 			MongoDatabase database = CreateConnection.getDatabase();
// 			MongoCollection<Document> categoryCollection = database.getCollection("category");
// 			MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");
	
// 			Document categoryInfo = categoryCollection.find(new Document("category", subject)).first();
// 			Document newGamePlay = new Document("subject_chosen", categoryInfo.getObjectId("_id"))
// 									.append("total_attempts", attempt)
// 									.append("total_correct", correct).append("user_id", Authenticate.getUser());
	
// 			gamePlayCollection.insertOne(newGamePlay);
// 			CreateConnection.closeConnection();
// 		} catch (Exception e) {
// 			System.err.println("Error occured during fetching data:  "+ e.getMessage());
// 		} finally {
// 			CreateConnection.closeConnection();
// 		}
// 	}

// 	private void initialize() {
// 		frame = new JFrame();
// 		frame.setVisible(true);
// 		frame.setBounds(100, 100, 800, 500);
// 		frame.setLocationRelativeTo(null);
// 		frame.setResizable(false);
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		frame.getContentPane().setLayout(null);
		
// 		profileBtn = new JButton("Profile");
// 		profileBtn.setBackground(new Color(253, 245, 230));
// 		profileBtn.setFont(new Font("Stencil", Font.PLAIN, 16));
// 		profileBtn.setBounds(650, 5, 100, 40);
// 		frame.getContentPane().add(profileBtn);

// 		JPanel panel = new JPanel();
// 		panel.setBounds(0, 0, 784, 461);
// 		frame.getContentPane().add(panel);
// 		panel.setLayout(null);
		
// 		Total = new JLabel("TOTAL QUESTION = 10 ", JLabel.CENTER);
// 		Total.setFont(new Font("Stencil", Font.BOLD, 26));
// 		Total.setForeground(Color.WHITE);
// 		Total.setBounds(126, 161, 529, 33);
// 		panel.add(Total);
		
// 		Attempted = new JLabel("YOU ATTEMPTED = " + attempt, JLabel.CENTER);
// 		Attempted.setFont(new Font("Stencil", Font.BOLD, 26));
// 		Attempted.setForeground(Color.WHITE);
// 		Attempted.setBounds(123, 213, 532, 33);
// 		panel.add(Attempted);
		
// 		Correct = new JLabel("CORRECT ANSWERS = " + correct, JLabel.CENTER);
// 		Correct.setFont(new Font("Stencil", Font.BOLD, 26));
// 		Correct.setForeground(Color.WHITE);
// 		Correct.setBounds(126, 276, 529, 33);
// 		panel.add(Correct);
		
// 		Wrong = new JLabel("WRONG ANSWERS = " + (attempt - correct), JLabel.CENTER);
// 		Wrong.setForeground(Color.WHITE);
// 		Wrong.setFont(new Font("Stencil", Font.BOLD, 26));
// 		Wrong.setBounds(126, 344, 529, 33);
// 		panel.add(Wrong);
		
// 		Play_Again = new JButton("PLAY AGAIN");
// 		Play_Again.setFont(new Font("Stencil", Font.BOLD, 22));
// 		Play_Again.setBackground(new Color(253, 245, 230));
// 		Play_Again.setBounds(50, 406, 172, 44);
// 		panel.add(Play_Again);
		
// 		Quit = new JButton("QUIT");
// 		Quit.setBackground(new Color(253, 245, 230));
// 		Quit.setFont(new Font("Stencil", Font.BOLD, 22));
// 		Quit.setBounds(579, 406, 150, 44);
// 		panel.add(Quit);
		
// 		JLabel Scorecard = new JLabel("SCORECARD", JLabel.CENTER);
// 		Scorecard.setHorizontalAlignment(SwingConstants.CENTER);
// 		Scorecard.setForeground(Color.WHITE);
// 		Scorecard.setFont(new Font("Stencil", Font.BOLD, 58));
// 		Scorecard.setBounds(110, 28, 512, 100);
// 		panel.add(Scorecard);
		
// 		JLabel img = new JLabel("New label");
// 		img.setBounds(0, 0, 784, 461);
// 		img.setIcon(new ImageIcon(getClass().getResource("/public/images/faded5.jpg")));
// 		panel.add(img);
// 	}
	
// 	public void actionPerformed(ActionEvent ae) {
// 		if (ae.getSource() == profileBtn) {
// 			frame.setVisible(false);
// 			frame.dispose();
// 			Profile profile = new Profile();
// 			profile.setUser(Authenticate.getUser());
// 			profile.getFrame().setVisible(true);
// 		}

// 		if (ae.getSource() == Play_Again) {
// 			frame.setVisible(false);
// 			frame.dispose();
// 			// Buttons buttons = new Buttons();
// 			// buttons.getFrame().setVisible(true);
// 		}

// 		if (ae.getSource() == Quit) {
// 			System.exit(0);
// 		}
// 	}
	
// 	public JFrame getFrame() {
// 		return frame;
// 	}
// }

package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import auth.Authenticate;
import db.CreateConnection;

public class Result extends JPanel implements ActionListener {
    private JButton profileBtn, quitBtn, playAgainBtn;
    private JLabel totalLabel, attemptedLabel, correctLabel, wrongLabel;
    private int attempt, correct;
    private String subject;
	private JPanel mainPanel;
	private Profile profile;
    private CardLayout cardLayout;

    public Result(CardLayout cardLayout,JPanel mainPanel, Profile profile) {
		this.mainPanel = mainPanel;
		this.profile = profile;
        this.cardLayout = cardLayout;
        
    }

    public void setData(String subject, int att, int corr) {
        this.subject = subject;
        this.attempt = att;
        this.correct = corr;
        setLayout(null);
        initializeUI();
        updateLabels();
        storeResult();
    }

    private void storeResult() {
        try {
            MongoDatabase database = CreateConnection.getDatabase();
            MongoCollection<Document> categoryCollection = database.getCollection("category");
            MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");
            
            Document categoryInfo = categoryCollection.find(new Document("category", subject)).first();
            if (categoryInfo != null) {
                Document newGamePlay = new Document("subject_chosen", categoryInfo.getObjectId("_id"))
                        .append("total_attempts", attempt)
                        .append("total_correct", correct)
                        .append("user_id", Authenticate.getUser());
                gamePlayCollection.insertOne(newGamePlay);
            }
        } catch (Exception e) {
            System.err.println("Error storing result: " + e.getMessage());
        } finally {
            CreateConnection.closeConnection();
        }
    }

    private void initializeUI() {
        profileBtn = new JButton("Profile");
        profileBtn.setBounds(650, 5, 100, 40);
        profileBtn.setFont(new Font("Stencil", Font.PLAIN, 16));
        profileBtn.setBackground(new Color(253, 245, 230));
        profileBtn.addActionListener(this);
        add(profileBtn);

        totalLabel = new JLabel("TOTAL QUESTION = 10", JLabel.CENTER);
        totalLabel.setFont(new Font("Stencil", Font.BOLD, 26));
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setBounds(126, 161, 529, 33);
        add(totalLabel);

        attemptedLabel = new JLabel("YOU ATTEMPTED = 0", JLabel.CENTER);
        attemptedLabel.setFont(new Font("Stencil", Font.BOLD, 26));
        attemptedLabel.setForeground(Color.WHITE);
        attemptedLabel.setBounds(123, 213, 532, 33);
        add(attemptedLabel);

        correctLabel = new JLabel("CORRECT ANSWERS = 0", JLabel.CENTER);
        correctLabel.setFont(new Font("Stencil", Font.BOLD, 26));
        correctLabel.setForeground(Color.WHITE);
        correctLabel.setBounds(126, 276, 529, 33);
        add(correctLabel);

        wrongLabel = new JLabel("WRONG ANSWERS = 0", JLabel.CENTER);
        wrongLabel.setFont(new Font("Stencil", Font.BOLD, 26));
        wrongLabel.setForeground(Color.WHITE);
        wrongLabel.setBounds(126, 344, 529, 33);
        add(wrongLabel);

        playAgainBtn = new JButton("PLAY AGAIN");
        playAgainBtn.setFont(new Font("Stencil", Font.BOLD, 22));
        playAgainBtn.setBackground(new Color(253, 245, 230));
        playAgainBtn.setBounds(50, 406, 172, 44);
        playAgainBtn.addActionListener(this);
        add(playAgainBtn);

        quitBtn = new JButton("QUIT");
        quitBtn.setFont(new Font("Stencil", Font.BOLD, 22));
        quitBtn.setBackground(new Color(253, 245, 230));
        quitBtn.setBounds(579, 406, 150, 44);
        quitBtn.addActionListener(this);
        add(quitBtn);

        JLabel scorecardLabel = new JLabel("SCORECARD", JLabel.CENTER);
        scorecardLabel.setFont(new Font("Stencil", Font.BOLD, 58));
        scorecardLabel.setForeground(Color.WHITE);
        scorecardLabel.setBounds(110, 28, 512, 100);
        add(scorecardLabel);

        JLabel img = new JLabel(new ImageIcon(getClass().getResource("/public/images/faded5.jpg")));
        img.setBounds(0, 0, 784, 461);
        add(img);
    }

    private void updateLabels() {
        attemptedLabel.setText("YOU ATTEMPTED = " + attempt);
        correctLabel.setText("CORRECT ANSWERS = " + correct);
        wrongLabel.setText("WRONG ANSWERS = " + (attempt - correct));
    }

    public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == profileBtn) {
			profile.setUser(Authenticate.getUser());
            cardLayout.show(mainPanel, "profile");
        } else if (ae.getSource() == playAgainBtn) {
            cardLayout.show(mainPanel, "buttons");
        } else if (ae.getSource() == quitBtn) {
            System.exit(0);
        }
    }
}