package quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

import db.CreateConnection;
import utils.BackgroundPanel;

public class Profile extends JPanel implements ActionListener {
    private ObjectId user;
    private String name;
    private AggregateIterable<Document> result;
    private JButton quitButton, playAgainButton;
    private CardLayout cardLayout;
    private JPanel parentPanel;

    public Profile(CardLayout cardLayout, JPanel parentPanel) {
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        setLayout(new GridBagLayout());
        setBackground(Color.DARK_GRAY);
    }

    public void setUser(ObjectId user) {
        this.user = user;
        getData();
    }

    private void getData() {
        try {
            MongoDatabase database = CreateConnection.getDatabase();
            MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");
            MongoCollection<Document> usersCollection = database.getCollection("users");
            Document userDoc = usersCollection.find(new Document("_id", user)).first();
            name = userDoc.getString("name");
    
            result = gamePlayCollection.aggregate(Arrays.asList(
                Aggregates.lookup("users", "user_id", "_id", "user_data"),
                Aggregates.match(Filters.eq("user_data._id", user)),
                Aggregates.lookup("category", "subject_chosen", "_id", "category_data"),
                Aggregates.unwind("$category_data"),
                Aggregates.group("$category_data.category", 
                    Accumulators.sum("total_attempts", "$total_attempts"),
                    Accumulators.sum("total_correct", "$total_correct")
                )
            ));
    
            initialize();
        } catch (Exception e) {
            System.err.println("Error occurred during fetching data: " + e.getMessage());
        } finally {
            CreateConnection.closeConnection();
        }
    }

    private void initialize() {
        removeAll();
        setLayout(new BorderLayout());
    
        BackgroundPanel bgPanel = new BackgroundPanel("/public/images/pen4.jpg");
        bgPanel.setLayout(new GridBagLayout());
        add(bgPanel, BorderLayout.CENTER);
    
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; 

        JLabel titleLabel = new JLabel("Hello " + name + ", your playing summary is here", JLabel.CENTER);
        titleLabel.setFont(new Font("Stencil", Font.BOLD, 40));
        titleLabel.setForeground(Color.darkGray);
        contentPanel.add(titleLabel, gbc);
    
        gbc.gridy++;

        boolean isEmpty = true;
        
        for (Document doc : result) {
            String categoryName = doc.getString("_id");
            int totalAttempts = doc.getInteger("total_attempts", 0);
            int totalCorrect = doc.getInteger("total_correct", 0);
            int totalWrong = totalAttempts - totalCorrect;

            addLabel("Category: " + categoryName, contentPanel, gbc, true);
            gbc.gridy++;
            addLabel("Total Attempted: " + totalAttempts, contentPanel, gbc, false);
            gbc.gridy++;
            addLabel("Correct Answers: " + totalCorrect, contentPanel, gbc, false);
            gbc.gridy++;
            addLabel("Wrong Answers: " + totalWrong, contentPanel, gbc, false);
            gbc.gridy++;
            isEmpty = false;
        }
        
        if (isEmpty) {
            addLabel("No data available", contentPanel, gbc, true);
            gbc.gridy++;
        }
    

        playAgainButton = new JButton("PLAY AGAIN");
        styleButton(playAgainButton);
        contentPanel.add(playAgainButton, gbc);
        playAgainButton.addActionListener(this);
        gbc.gridy++;
    
        quitButton = new JButton("QUIT");
        styleButton(quitButton);
        contentPanel.add(quitButton, gbc);
        quitButton.addActionListener(this);
        gbc.gridy++;
    
        bgPanel.add(contentPanel);
    
        revalidate();
        repaint();
    }
    
    private void addLabel(String text, JPanel panel, GridBagConstraints gbc, boolean color) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        if (color) {
            label.setForeground(Color.red);
        }
        panel.add(label, gbc);
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Stencil", Font.BOLD, 22));
        button.setBackground(new Color(253, 245, 230));
        button.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == playAgainButton) {
            cardLayout.show(parentPanel, "buttons");
        } else if (ae.getSource() == quitButton) {
            System.exit(0);
        }
    }
}
