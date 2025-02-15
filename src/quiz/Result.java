package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import auth.Authenticate;
import db.CreateConnection;
import utils.BackgroundPanel;

public class Result extends JPanel implements ActionListener {
    private JButton profileBtn, quitBtn, playAgainBtn;
    private JLabel totalLabel, attemptedLabel, correctLabel, wrongLabel, scorecardLabel;
    private int attempt, correct;
    private String subject;
    private JPanel mainPanel;
    private Profile profile;
    private CardLayout cardLayout;

    public Result(CardLayout cardLayout, JPanel mainPanel, Profile profile) {
        this.mainPanel = mainPanel;
        this.profile = profile;
        this.cardLayout = cardLayout;
    }

    public void setData(String subject, int att, int corr) {
        this.subject = subject;
        this.attempt = att;
        this.correct = corr;
        setLayout(new BorderLayout());
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
        } 
    }

    private void initializeUI() {
        BackgroundPanel bgPanel = new BackgroundPanel("/public/images/faded5.jpg");
        bgPanel.setLayout(new GridBagLayout());
        add(bgPanel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);

        scorecardLabel = createLabel("SCORECARD", 58);
        scorecardLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        contentPanel.add(scorecardLabel);

        totalLabel = createLabel("TOTAL QUESTION = 10", 26);
        totalLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        contentPanel.add(totalLabel);

        attemptedLabel = createLabel("YOU ATTEMPTED = 0", 26);
        attemptedLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        contentPanel.add(attemptedLabel);

        correctLabel = createLabel("CORRECT ANSWERS = 0", 26);
        correctLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        contentPanel.add(correctLabel);

        wrongLabel = createLabel("WRONG ANSWERS = 0", 26);
        wrongLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        contentPanel.add(wrongLabel);

        profileBtn = createButton("Profile", 16);
        profileBtn.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        contentPanel.add(Box.createVerticalStrut(10));
        profileBtn.setBounds(1200, 10, 120, 40);
        contentPanel.add(profileBtn);

        playAgainBtn = createButton("PLAY AGAIN", 22);
        playAgainBtn.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(playAgainBtn);

        quitBtn = createButton("QUIT", 22);
        quitBtn.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(quitBtn);

        bgPanel.add(contentPanel);
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Stencil", Font.BOLD, fontSize));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Stencil", Font.BOLD, fontSize));
        button.setBackground(new Color(253, 245, 230));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        return button;
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
