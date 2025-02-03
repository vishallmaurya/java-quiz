package quiz;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import db.CreateConnection;


/* Initialize the class QuestionFrame in which we are trying to display questions on JFrame and take answers
 * from the user.
 */
public class QuestionFrame implements ActionListener{
	private JFrame frame;				// Instance of JFrame which contains all the components that we are added in it.
	private JTextField Answer;			// Instance of JTextField which is used to take input(answer) from the user.
	private JButton Next ;				// Instance of JButton which helps user to skip the question and take user to next question 
	private JLabel Question ;			// Instance of JLabel which show questions to user for quiz.
	private JButton Submit ;			// Instance of JButton which is used to check whether the user entered correct answer or not.
	private JButton Quit ;				// Instance of JButton which provide functionality to user to quit. If he/she wants to quit in bet
	private JLabel corr ;	
	private JButton Back ;
	private JButton Final ;
	private JProgressBar progressBar;
	private List<Document> questionsList;
	private int currentIndex = 0;
	private int attempt = 0, correctAns = 0 , progressBarCounter = 0;
	int count = 0, total = 0, starting_index = 0, end_index = 0, n = 0, showNext = 0,back_counter = 0 , nextCount = 0 ;
	
	
	public QuestionFrame(String subject) {
		System.out.println(subject);
		initialize();
		fetchQuestions(subject);
		showQues();

		Answer.addActionListener(this);
		Submit.addActionListener(this);
		Quit.addActionListener(this);
		Next.addActionListener(this);
		Back.addActionListener(this);
		Final.addActionListener(this);
		Back.setEnabled(false);
		Submit.setEnabled(false);
		Final.setEnabled(false);
	}

	private void fetchQuestions(String subject) {
		MongoDatabase database = CreateConnection.getDatabase();
		MongoCollection<Document> questionsCollection = database.getCollection("questions");
		questionsList = questionsCollection.find(new Document("category", subject)).into(new ArrayList<>());
		Collections.shuffle(questionsList);
		CreateConnection.closeConnection();
	}

	private void showQues() {
		if (currentIndex < questionsList.size()) {
            Document questionDoc = questionsList.get(currentIndex);
            Question.setText((currentIndex + 1) + ". " + questionDoc.getString("question"));
        }
	}
	
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 1350, 729);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(275, 5, 800, 300);
		logo.setIcon(new ImageIcon("./public/images/quiz_it_out.jpg"));
		panel.add(logo);
		
		Question = new JLabel("");
		Question.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		Question.setBounds(65, 349, 1285, 31);
		panel.add(Question);
		
		Answer = new JTextField();
		Answer.setBounds(65, 393, 639, 36);
		panel.add(Answer);
		Answer.setColumns(10);
		
		Next = new JButton("NEXT");
		Next.setBackground(new Color(128, 0, 0));
		Next.setForeground(new Color(255, 255, 255));
		Next.setFont(new Font("Stencil", Font.BOLD, 13));
		Next.setBounds(65, 466, 97, 31);
		panel.add(Next);
		
		Submit = new JButton("SUBMIT");
		Submit.setBackground(new Color(128, 0, 0));
		Submit.setFont(new Font("Stencil", Font.BOLD, 14));
		Submit.setForeground(new Color(255, 228, 196));
		Submit.setBounds(204, 465, 97, 32);
		panel.add(Submit);
		
		corr = new JLabel("");
		corr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		corr.setBounds(65, 522, 596, 31);
		panel.add(corr);
		
		Back = new JButton("BACK");
		Back.setBackground(new Color(128, 0, 0));
		Back.setFont(new Font("Stencil", Font.BOLD, 14));
		Back.setForeground(new Color(255, 228, 181));
		Back.setBounds(346, 466, 97, 31);
		panel.add(Back);
		
		Quit = new JButton("QUIT");
		Quit.setFont(new Font("Stencil", Font.BOLD, 14));
		Quit.setForeground(new Color(255, 240, 245));
		Quit.setBackground(new Color(128, 0, 0));
		Quit.setBounds(1205, 469, 114, 28);
		panel.add(Quit);
		
		JLabel dog = new JLabel("");
		dog.setIcon(new ImageIcon("./public/gifs/small_dog.gif"));
		dog.setBounds(617, 506, 255, 212);
		panel.add(dog);
			
		JLabel think1 = new JLabel("");
		think1.setIcon(new ImageIcon("./public/gifs/think.gif"));
		think1.setBounds(35, 21, 208, 206);
		panel.add(think1);
		
		JLabel think2 = new JLabel("");
		think2.setIcon(new ImageIcon("./public/gifs/think.gif"));
		think2.setBounds(1125, 21, 194, 215);
		panel.add(think2);
		
		JLabel book = new JLabel(" ");
		book.setIcon(new ImageIcon("./public/gifs/learning_small.gif"));
		book.setBounds(1125, 578, 200, 120);
		panel.add(book);
		
		Final = new JButton("Final  Submission");
		Final.setBackground(new Color(128, 0, 0));
		Final.setFont(new Font("Stencil", Font.BOLD, 14));
		Final.setForeground(new Color(255, 228, 181));
		Final.setBounds(65, 600, 200, 31);
		panel.add(Final);		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(1086, 240, 255, 28);
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setValue(0);
		
		panel.add(progressBar);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Answer) {
			Submit.setEnabled(true);
		}

		if (ae.getSource() == Submit) {
			attempt++;
			progressBarCounter += 10;
			progressBar.setValue(progressBarCounter);
			back_counter--;
			corr.setVisible(true);
			Submit.setEnabled(false);

			String userAnswer = Answer.getText().trim();
			String correctAnswer = questionsList.get(currentIndex).getString("answer");
			if (userAnswer.equalsIgnoreCase(correctAnswer)) {
				corr.setText("Correct answer");
				correctAns++;
			} else {
				corr.setText("Correct answer is :  " + correctAnswer);
			}
		}

		if (ae.getSource() == Quit) {
			// frame.setVisible(false) ;
			// new Result(attempt, correctAns) ;
		}

		if (ae.getSource() == Next) {
			showNext++;
			back_counter++;
			nextCount++;
			currentIndex++;

			if (currentIndex < questionsList.size()) {
				Answer.setText("");
				corr.setText("");
				showQues();
			} else {
				Next.setEnabled(false);
			}
		}

		if (ae.getSource() == Back) {
			showNext--;
			--back_counter;
			nextCount--;

			if (currentIndex > 0) {
				corr.setText("");
				Answer.setText("");
				showQues();
			}
		}

		if (back_counter > 0) {
			Back.setEnabled(true);
		} else {
			Back.setEnabled(false);
		}

		if (nextCount == 9) {
			Next.setEnabled(false);
		}

		if (nextCount != 9) {
			Next.setEnabled(true);
		}

		if (attempt == 10) {
			Submit.setEnabled(false);
			Final.setEnabled(true);
		}

		if (ae.getSource() == Final) {
			frame.setVisible(false);
			// new Result(attempt, correctAns) ;
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new QuestionFrame("Riddles.txt");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}