package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import auth.Authenticate;
import utils.BackgroundPanel;

public class Instruction extends JPanel implements ActionListener {
    private JButton profileBtn;
    private JButton Okay;
    private Profile profile ;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Instruction(CardLayout cardLayout, JPanel mainPanel, Profile profile) {
        this.cardLayout = cardLayout;
        this.profile = profile ;
        this.mainPanel = mainPanel;
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());

        BackgroundPanel bgPanel = new BackgroundPanel("/public/images/pen4.jpg");
        bgPanel.setLayout(new GridBagLayout()); 
        add(bgPanel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        
        JLabel title = new JLabel("INSTRUCTIONS", SwingConstants.CENTER);
        title.setFont(new Font("Stencil", Font.BOLD, 48));
        title.setForeground(Color.RED);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(title);

        JLabel subTitle = new JLabel("Choose any one field out of the 8", SwingConstants.CENTER);
        subTitle.setFont(new Font("Stencil", Font.BOLD, 29));
        subTitle.setForeground(Color.darkGray);
        subTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(subTitle);

        String[] instructions = {
            "Write the correct Answers for these General Knowledge, Culture, Riddles, History,",
            "Maths, Science and Computer Science questions",
            "Guess the correct movie for the given dialogues in the category 'Bollywood'!",
            "Controls",
            "Press next to skip and go to next question",
            "Press submit to submit your answer",
            "Press back to go to previous question"
        };

        for (String text : instructions) {
            JLabel instructionLabel = new JLabel(text, SwingConstants.CENTER);
            if (text.equals("Controls"))
                instructionLabel.setForeground(Color.RED);
            instructionLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
            instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPanel.add(instructionLabel);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());

        profileBtn = new JButton("Profile");
        profileBtn.setBackground(new Color(253, 245, 230));
        profileBtn.setFont(new Font("Stencil", Font.PLAIN, 22));
        profileBtn.addActionListener(this);
        buttonPanel.add(profileBtn);

        Okay = new JButton("Play");
        Okay.setBackground(new Color(253, 245, 230));
        Okay.setFont(new Font("Stencil", Font.BOLD, 22));
        Okay.addActionListener(this);
        buttonPanel.add(Okay);

        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        contentPanel.add(buttonPanel);

        bgPanel.add(contentPanel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Okay) {
            cardLayout.show(mainPanel, "buttons");
        } else if (ae.getSource() == profileBtn) {
            profile.setUser(Authenticate.getUser());
            cardLayout.show(mainPanel, "profile");
        }
    }
}