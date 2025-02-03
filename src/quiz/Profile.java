package quiz;

import java.awt.* ;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.* ;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

import db.CreateConnection;

public class Profile implements ActionListener{
	private JFrame frame;
    private AggregateIterable<Document> result;
	private JButton Quit ;
	private JButton Play_Again ;

    public Profile() {
        result = null;
        initialize();
        Quit.addActionListener(this);
        Play_Again.addActionListener(this);
    }

    public Profile(String user) {
        result = null;
        getData(user);
        initialize();
        Quit.addActionListener(this);
        Play_Again.addActionListener(this);
    }
    
    private void getData(String user) {
        MongoDatabase database = CreateConnection.getDatabase();
        MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");

        result = gamePlayCollection.aggregate(Arrays.asList(
            Aggregates.lookup("users", "user_email", "email", "user_data"),
            Aggregates.match(Filters.eq("user_data.email", user)),
            Aggregates.lookup("category", "subject_chosen", "category", "category_data"),
            Aggregates.unwind("$category_data"),
            Aggregates.group("$category_data.category",
                Accumulators.sum("total_attempts", "$total_attempts"),
                Accumulators.sum("total_correct", "$total_correct")
            )
        ));
    }

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
        for (Document doc : result) {
            JLabel category = new JLabel("Category: " + doc.getString("category"), JLabel.CENTER) ;
            category.setFont(new Font("Stencil", Font.BOLD, 26));
            category.setForeground(Color.WHITE);
            category.setBounds(126, 161, 529, 33);
            panel.add(category);    
        
            JLabel total_attmepted = new JLabel("You Total Attempted = " + doc.getInteger("total_attempts", 0), JLabel.CENTER);
            total_attmepted.setFont(new Font("Stencil", Font.BOLD, 26));
            total_attmepted.setForeground(Color.WHITE);
            total_attmepted.setBounds(123, 213, 532, 33);
            panel.add(total_attmepted);
        
            JLabel total_correct = new JLabel("Correct Answer = " + doc.getInteger("total_correct", 0), JLabel.CENTER);
            total_correct.setFont(new Font("Stencil", Font.BOLD, 26));
            total_correct.setForeground(Color.WHITE);
            total_correct.setBounds(126, 276, 529, 33);
            panel.add(total_correct);

            JLabel total_wrong = new JLabel("Wrong answer = " + (doc.getInteger("total_attempts", 0) - doc.getInteger("total_correct", 0)), JLabel.CENTER);
            total_wrong.setForeground(Color.WHITE);
            total_wrong.setFont(new Font("Stencil", Font.BOLD, 26));
            total_wrong.setBounds(126, 344, 529, 33);
            panel.add(total_wrong);


        }
		
		
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Profile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}