// package quiz;

// import java.awt.* ;
// import java.awt.event.* ;
// import javax.swing.* ;

// import java.util.List;
// import java.util.ArrayList;
// import java.util.Collections;

// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;
// import org.bson.Document;
// import db.CreateConnection;


// /* Initialize the class QuestionFrame in which we are trying to display questions on JFrame and take answers
//  * from the user.
//  */
// public class QuestionFrame implements ActionListener{
// 	private JFrame frame;				// Instance of JFrame which contains all the components that we are added in it.
// 	private JTextField Answer;			// Instance of JTextField which is used to take input(answer) from the user.
// 	private JButton Next ;				// Instance of JButton which helps user to skip the question and take user to next question 
// 	private JLabel Question ;			// Instance of JLabel which show questions to user for quiz.
// 	private JButton Submit ;			// Instance of JButton which is used to check whether the user entered correct answer or not.
// 	private JButton Quit ;				// Instance of JButton which provide functionality to user to quit. If he/she wants to quit in bet
// 	private JLabel corr ;	
// 	private JButton Back ;
// 	private JButton Final ;
// 	private JProgressBar progressBar;
// 	private List<Document> questionsList;
// 	private int currentIndex = 0;
// 	private int correctAns = 0, progressBarCounter = 0;
// 	private boolean[] attempt;
// 	private List<Integer> backCounterIndex;
// 	Integer temp = 0;
// 	String subject;
// 	int count = 0, total = 0, starting_index = 0, end_index = 0, nextCount = 0;
	
// 	public QuestionFrame() {
// 		attempt = new boolean[10];
// 		backCounterIndex = new ArrayList<>();

// 		for (int i = 0; i < 10; i++) {
// 			attempt[i] = false;
// 		}

// 		initialize();
// 		fetchQuestions(subject);
// 		showQues(temp);

// 		Answer.addActionListener(this);
// 		Submit.addActionListener(this);
// 		Quit.addActionListener(this);
// 		Next.addActionListener(this);
// 		Back.addActionListener(this);
// 		Final.addActionListener(this);
// 		Back.setEnabled(false);
// 		Submit.setEnabled(false);
// 		Final.setEnabled(false);
// 	}
	
// 	public void setSubject(String subject) {
// 		this.subject = subject;
// 	}

// 	private void fetchQuestions(String subject) {
// 		try {
// 			MongoDatabase database = CreateConnection.getDatabase();
// 			MongoCollection<Document> questionsCollection = database.getCollection("questions");
// 			questionsList = questionsCollection.find(new Document("category", subject)).into(new ArrayList<>());
// 			Collections.shuffle(questionsList);
			
// 			if (questionsList.size() > 10) {
// 				questionsList = questionsList.subList(0, 10);
// 			}
	
// 			CreateConnection.closeConnection();
// 		} catch (Exception e) {
// 			System.err.println("Error occurred during fetching data:  " + e.getMessage());
// 		} finally {
// 			CreateConnection.closeConnection();
// 		}
// 	}

// 	private void showQues(int ind) {
// 		if (ind < questionsList.size()) {
//             Document questionDoc = questionsList.get(ind);
//             Question.setText((ind + 1) + ". " + questionDoc.getString("question"));
//         }
// 	}
	
// 	private void initialize() {
// 		frame = new JFrame();
// 		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
// 		frame.setSize(screenSize.width, screenSize.height);
// 		frame.setResizable(false);
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		frame.getContentPane().setLayout(null);
// 		frame.setVisible(true);
		
// 		JPanel panel = new JPanel();
// 		panel.setBackground(new Color(128, 128, 128));
// 		panel.setBounds(0, 0, 1350, 729);
// 		frame.getContentPane().add(panel);
// 		panel.setLayout(null);
		
// 		JLabel logo = new JLabel("");
// 		logo.setBounds(275, 5, 800, 300);
// 		logo.setIcon(new ImageIcon(getClass().getResource("/public/images/quiz_it_out.jpg")));
// 		panel.add(logo);
		
// 		Question = new JLabel("");
// 		Question.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
// 		Question.setBounds(65, 349, 1285, 31);
// 		panel.add(Question);
		
// 		Answer = new JTextField();
// 		Answer.setBounds(65, 393, 639, 36);
// 		panel.add(Answer);
// 		Answer.setColumns(10);
		
// 		Next = new JButton("NEXT");
// 		Next.setBackground(new Color(128, 0, 0));
// 		Next.setForeground(new Color(255, 255, 255));
// 		Next.setFont(new Font("Stencil", Font.BOLD, 13));
// 		Next.setBounds(65, 466, 97, 31);
// 		panel.add(Next);
		
// 		Submit = new JButton("SUBMIT");
// 		Submit.setBackground(new Color(128, 0, 0));
// 		Submit.setFont(new Font("Stencil", Font.BOLD, 14));
// 		Submit.setForeground(new Color(255, 228, 196));
// 		Submit.setBounds(204, 465, 97, 32);
// 		panel.add(Submit);
		
// 		corr = new JLabel("");
// 		corr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
// 		corr.setBounds(65, 522, 596, 31);
// 		panel.add(corr);
		
// 		Back = new JButton("BACK");
// 		Back.setBackground(new Color(128, 0, 0));
// 		Back.setFont(new Font("Stencil", Font.BOLD, 14));
// 		Back.setForeground(new Color(255, 228, 181));
// 		Back.setBounds(346, 466, 97, 31);
// 		panel.add(Back);
		
// 		Quit = new JButton("QUIT");
// 		Quit.setFont(new Font("Stencil", Font.BOLD, 14));
// 		Quit.setForeground(new Color(255, 240, 245));
// 		Quit.setBackground(new Color(128, 0, 0));
// 		Quit.setBounds(1205, 469, 114, 28);
// 		panel.add(Quit);
		
// 		JLabel dog = new JLabel("");
// 		dog.setIcon(new ImageIcon(getClass().getResource("/public/gifs/small_dog.gif")));
// 		dog.setBounds(617, 506, 255, 212);
// 		panel.add(dog);
			
// 		JLabel think1 = new JLabel("");
// 		think1.setIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif")));
// 		think1.setBounds(35, 21, 208, 206);
// 		panel.add(think1);
		
// 		JLabel think2 = new JLabel("");
// 		think2.setIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif")));
// 		think2.setBounds(1125, 21, 194, 215);
// 		panel.add(think2);
		
// 		JLabel book = new JLabel(" ");
// 		book.setIcon(new ImageIcon(getClass().getResource("/public/gifs/learning_small.gif")));
// 		book.setBounds(1125, 578, 200, 120);
// 		panel.add(book);
		
// 		Final = new JButton("Final  Submission");
// 		Final.setBackground(new Color(128, 0, 0));
// 		Final.setFont(new Font("Stencil", Font.BOLD, 14));
// 		Final.setForeground(new Color(255, 228, 181));
// 		Final.setBounds(65, 600, 200, 31);
// 		panel.add(Final);		
		
// 		progressBar = new JProgressBar();
// 		progressBar.setBounds(1086, 240, 255, 28);
// 		progressBar.setBackground(Color.DARK_GRAY);
// 		progressBar.setForeground(Color.ORANGE);
// 		progressBar.setValue(0);
		
// 		panel.add(progressBar);
// 	}
	
// 	public void actionPerformed(ActionEvent ae) {
// 		if (ae.getSource() == Answer) {
// 			Submit.setEnabled(true);
// 		}

// 		if (ae.getSource() == Submit && attempt[temp] == false) {
// 			attempt[temp] = true;
// 			total++;
// 			progressBarCounter += 10;
// 			progressBar.setValue(progressBarCounter);
// 			corr.setVisible(true);
// 			Submit.setEnabled(false);

// 			String userAnswer = Answer.getText().trim();
// 			String correctAnswer = questionsList.get(currentIndex).getString("answer");
// 			if (userAnswer.equalsIgnoreCase(correctAnswer)) {
// 				corr.setText("Correct answer");
// 				correctAns++;
// 			} else {
// 				corr.setText("Correct answer is :  " + correctAnswer);
// 			}
// 		}

// 		if (ae.getSource() == Quit || ae.getSource() == Final) {
// 			frame.setVisible(false);
// 			frame.dispose();
// 			Result result = new Result(subject, total, correctAns);
// 			result.getFrame().setVisible(true);
// 		}

// 		if (ae.getSource() == Next) {
// 			nextCount++;
// 			if (attempt[temp] == false) {
// 				backCounterIndex.add(currentIndex);
// 			}
// 			if (backCounterIndex.size() > 0) {
// 				Back.setEnabled(true);
// 			}

// 			if(temp == currentIndex)
// 				currentIndex++;

// 			if (currentIndex < questionsList.size()) {
// 				Answer.setText("");
// 				corr.setText("");
// 				temp = currentIndex;
// 				showQues(currentIndex);
// 			} else {
// 				Next.setEnabled(false);
// 			}
// 		}

// 		if (ae.getSource() == Back) {
// 			nextCount--;
			
// 			temp = (Integer) backCounterIndex.get(0);
// 			backCounterIndex.remove(0);

// 			if (currentIndex > 0) {
// 				corr.setText("");
// 				Answer.setText("");
// 				showQues(temp);
// 			}
// 		}

// 		if (nextCount == 9) {
// 			Next.setEnabled(false);
// 		}

// 		if (nextCount != 9) {
// 			Next.setEnabled(true);
// 		}

// 		if (total == 10) {
// 			Submit.setEnabled(false);
// 			Final.setEnabled(true);
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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import db.CreateConnection;

public class QuestionFrame extends JPanel implements ActionListener {
    private JTextField Answer;
    private JButton Next, Submit, Quit, Back, Final;
    private JLabel Question, corr;
    private JProgressBar progressBar;
    private List<Document> questionsList;
    private int currentIndex = 0;
    private int correctAns = 0, progressBarCounter = 0;
    private boolean[] attempt;
    private List<Integer> backCounterIndex;
    private Integer temp = 0;
    private String subject;
    private int total = 0, nextCount = 0;
    private CardLayout cardLayout;
	private JPanel mainPanel;
	private Result result;

    public QuestionFrame(CardLayout cardLayout, JPanel mainPanel, Result result) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.result = result;
    }
    
    private void initializeAll() {
		attempt = new boolean[10];
		backCounterIndex = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			attempt[i] = false;

		initialize();
		fetchQuestions(subject);
		showQues(temp);

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
	
	public void setSubject(String subject) {
        this.subject = subject;
        initializeAll();
	}

    private void fetchQuestions(String subject) {
        try {
            MongoDatabase database = CreateConnection.getDatabase();
            MongoCollection<Document> questionsCollection = database.getCollection("questions");
            questionsList = questionsCollection.find(new Document("category", subject)).into(new ArrayList<>());
            Collections.shuffle(questionsList);
            if (questionsList.size() > 10) questionsList = questionsList.subList(0, 10);
            CreateConnection.closeConnection();
        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        } finally {
            CreateConnection.closeConnection();
        }
    }

    private void showQues(int ind) {
        if (ind < questionsList.size()) {
            Document questionDoc = questionsList.get(ind);
            Question.setText((ind + 1) + ". " + questionDoc.getString("question"));
        }
    }

    private void initialize() {
        setLayout(null);
        setBackground(new Color(128, 128, 128));

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/public/images/quiz_it_out.jpg")));
        logo.setBounds(275, 5, 800, 300);
        add(logo);

        Question = new JLabel("");
        Question.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
        Question.setBounds(65, 349, 1285, 31);
        add(Question);

        Answer = new JTextField();
        Answer.setBounds(65, 393, 639, 36);
        add(Answer);

        Next = createButton("NEXT", 65, 466);
        Submit = createButton("SUBMIT", 204, 466);
        Back = createButton("BACK", 346, 466);
        Quit = createButton("QUIT", 1205, 469);
        Final = createButton("Final Submission", 65, 600);

        corr = new JLabel("");
        corr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
        corr.setBounds(65, 522, 596, 31);
        add(corr);

        progressBar = new JProgressBar();
        progressBar.setBounds(1086, 240, 255, 28);
        progressBar.setBackground(Color.DARK_GRAY);
        progressBar.setForeground(Color.ORANGE);
        add(progressBar);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBackground(new Color(128, 0, 0));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Stencil", Font.BOLD, 14));
        button.setBounds(x, y, 150, 30);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Answer) {
            Submit.setEnabled(true);
        }

        // Handle submission logic only if not already attempted
        if (ae.getSource() == Submit && !attempt[temp]) {
            attempt[temp] = true;
            total++;
            progressBarCounter += 10;
            progressBar.setValue(Math.min(progressBarCounter, 100)); // Prevent overflow
            corr.setVisible(true);
            Submit.setEnabled(false);

            String userAnswer = Answer.getText().trim();
            String correctAnswer = questionsList.get(temp).getString("answer");
            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                corr.setText("Correct answer");
                correctAns++;
            } else {
                corr.setText("Correct answer is: " + correctAnswer);
            }
        }

        // Quit or Final button handling
        if (ae.getSource() == Quit || ae.getSource() == Final) {
            result.setData(subject, total, correctAns);
            cardLayout.show(mainPanel, "result");
        }

        if (ae.getSource() == Next) {
            nextCount++;

            if (!attempt[temp]) {
                backCounterIndex.add(temp);
            }

            if (temp == currentIndex) {
                currentIndex++;
            }

            if (currentIndex < questionsList.size()) {
                Answer.setText("");
                corr.setText("");
                temp = currentIndex;
                showQues(currentIndex);
            } else {
                Next.setEnabled(false);
            }
        }

        // Handle "Back" button logic
        if (ae.getSource() == Back) {
            if (!backCounterIndex.isEmpty()) { // Prevent crash
                nextCount--;
                temp = backCounterIndex.get(0);
                backCounterIndex.remove(0);

        
                if (currentIndex > 0) {
                    corr.setText("");
                    Answer.setText("");
                    showQues(temp);
                }
            }
        }

        if(backCounterIndex.isEmpty()) {
            Back.setEnabled(false) ;
        }else {
            Back.setEnabled(true) ;
        }
        
        Next.setEnabled(nextCount < 9);

        if (total >= 10) { // Ensure Final button is enabled only after all attempts
            Submit.setEnabled(false);
            Final.setEnabled(true);
        }
    }
}