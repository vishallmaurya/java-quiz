package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import db.CreateConnection;

public class AddQuestion implements ActionListener {
    private JFrame frame;
    private JTextField category;
    private JLabel error;
    private JTextArea question;
    private JTextField answer;
    private JButton submit;

    public AddQuestion() {
        initialize();
        submit.addActionListener(this);
    }

    private void initialize() {
        frame = new JFrame("Add Question");
        frame.setVisible(true);
        frame.setBounds(100, 100, 800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel addCategory = new JLabel("Category:");
        addCategory.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
        addCategory.setBounds(50, 50, 100, 30);
        frame.getContentPane().add(addCategory);

        category = new JTextField();
        category.setFont(new Font("Arial", Font.PLAIN, 14));
        category.setBounds(160, 50, 200, 30);
        frame.getContentPane().add(category);

        JLabel addQuestion = new JLabel("Question:");
        addQuestion.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
        addQuestion.setBounds(50, 100, 100, 30);
        frame.getContentPane().add(addQuestion);

        question = new JTextArea();
        question.setFont(new Font("Arial", Font.PLAIN, 14));
        question.setBounds(160, 100, 500, 100);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        frame.getContentPane().add(question);

        JLabel addAnswer = new JLabel("Answer:");
        addAnswer.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
        addAnswer.setBounds(50, 220, 100, 30);
        frame.getContentPane().add(addAnswer);

        answer = new JTextField();
        answer.setFont(new Font("Arial", Font.PLAIN, 14));
        answer.setBounds(160, 220, 200, 30);
        frame.getContentPane().add(answer);

        submit = new JButton("Submit");
        submit.setFont(new Font("Stencil", Font.BOLD, 18));
        submit.setBounds(320, 300, 150, 40);
        submit.setBackground(new Color(253, 245, 230));
        frame.getContentPane().add(submit);

        error = new JLabel("", SwingConstants.CENTER);
        error.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
        error.setForeground(Color.RED);
        error.setBounds(50, 350, 700, 30);
        frame.getContentPane().add(error);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(0, 0, 784, 461);
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/public/images/pen4.jpg")));
        frame.getContentPane().add(lblNewLabel);


        question.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            }
    
            public void removeUpdate(DocumentEvent e) {
                if(question.getText().isEmpty()){
                    error.setText("") ;
                }
            }
    
            public void changedUpdate(DocumentEvent e) {
            }
        });

        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String cat = category.getText().trim().toLowerCase();
            String ques = question.getText().trim();
            String ans = answer.getText().trim().toLowerCase();

            if (cat.isEmpty() || ques.isEmpty() || ans.isEmpty()) {
                error.setText("Please fill all the required fields");
                return;
            }
            
            try {
                MongoDatabase database = CreateConnection.getDatabase();
                MongoCollection<Document> questionCollection = database.getCollection("questions");
                Document newQuestion = new Document("category", cat).append("question", ques).append("answer", ans);
                questionCollection.insertOne(newQuestion);
                error.setText("Data added successfully");
            } catch (Exception e) {
                System.err.println("Error occured during inserting of data: " + e.getMessage());
            } finally {
                CreateConnection.closeConnection();
            }
        }

        frame.revalidate();
        frame.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddQuestion();
            }
        });
    }
}
