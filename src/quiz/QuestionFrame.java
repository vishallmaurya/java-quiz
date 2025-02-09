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
        Final.setSize(200, 31);

        corr = new JLabel("");
        corr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
        corr.setBounds(65, 522, 596, 31);
        add(corr);

        ImageIcon thinkIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel think1 = new JLabel(thinkIcon);
        think1.setBounds(1150, 20, 200, 200);
        add(think1);

        JLabel think2 = new JLabel(thinkIcon);
        think2.setBounds(5, 20, 200, 200);
        add(think2);

        ImageIcon dogIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/small_dog.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel dog = new JLabel(dogIcon);
        dog.setBounds(getWidth()/2-100, getHeight()-230, 200, 200);
        add(dog);

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

        if (ae.getSource() == Submit && !attempt[temp]) {
            attempt[temp] = true;
            total++;
            progressBarCounter += 10;
            progressBar.setValue(Math.min(progressBarCounter, 100));
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

        if (ae.getSource() == Back) {
            if (!backCounterIndex.isEmpty()) {
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

        if (total >= 10) { 
            Submit.setEnabled(false);
            Final.setEnabled(true);
        }
    }
}