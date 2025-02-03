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

import auth.Authenticate;
import db.CreateConnection;

public class Profile implements ActionListener {
    private JFrame frame;
    private AggregateIterable<Document> result;
    private JButton quitButton, playAgainButton;

    public Profile(ObjectId user) {
        getData(user);
        initialize();
        quitButton.addActionListener(this);
        playAgainButton.addActionListener(this);
    }

    private void getData(ObjectId user) {
        MongoDatabase database = CreateConnection.getDatabase();
        MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");

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
    }

    private void initialize() {
        frame = new JFrame("Quiz Profile");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        JLabel titleLabel = new JLabel("SCORECARD", JLabel.CENTER);
        titleLabel.setFont(new Font("Stencil", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        if (result != null) {
            for (Document doc : result) {
                String categoryName = doc.getString("_id"); // Now fetching category name
                int totalAttempts = doc.getInteger("total_attempts", 0);
                int totalCorrect = doc.getInteger("total_correct", 0);
                int totalWrong = totalAttempts - totalCorrect;

                addLabel(panel, "Category: " + categoryName, gbc);
                gbc.gridy++;
                addLabel(panel, "Total Attempted: " + totalAttempts, gbc);
                gbc.gridy++;
                addLabel(panel, "Correct Answers: " + totalCorrect, gbc);
                gbc.gridy++;
                addLabel(panel, "Wrong Answers: " + totalWrong, gbc);
                gbc.gridy++;
            }
        } else {
            addLabel(panel, "No data available", gbc);
        }

        // Play Again Button
        playAgainButton = new JButton("PLAY AGAIN");
        styleButton(playAgainButton);
        gbc.gridy++;
        panel.add(playAgainButton, gbc);

        // Quit Button
        quitButton = new JButton("QUIT");
        styleButton(quitButton);
        gbc.gridy++;
        panel.add(quitButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addLabel(JPanel panel, String text, GridBagConstraints gbc) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label, gbc);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Stencil", Font.BOLD, 22));
        button.setBackground(new Color(253, 245, 230));
        button.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == playAgainButton) {
            frame.dispose();
            new Buttons().getFrame().setVisible(true);
        } else if (ae.getSource() == quitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new Profile(Authenticate.getUser());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
