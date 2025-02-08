// package quiz;

// import java.awt.* ;
// import java.awt.event.* ;
// import javax.swing.* ;

// import auth.Authenticate;

// public class Instruction implements ActionListener {
// 	private JFrame frame;
// 	private JButton profileBtn;
// 	private JButton Okay ;

// 	public Instruction() {
// 		initialize();
		
// 		profileBtn.addActionListener(this);
// 		Okay.addActionListener(this) ;
// 	}

// 	private void initialize() {
// 		frame = new JFrame();
// 		frame.setBounds(100, 100, 800, 500);
// 		frame.setVisible(true);
// 		frame.setLocationRelativeTo(null);
// 		frame.setResizable(false);
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		frame.getContentPane().setLayout(null);
		
// 		profileBtn = new JButton("Profile");
// 		profileBtn.setBackground(new Color(253, 245, 230));
// 		profileBtn.setFont(new Font("Stencil", Font.PLAIN, 16));
// 		profileBtn.setBounds(650, 5, 100, 40);
// 		frame.getContentPane().add(profileBtn);
		
// 		JLabel lblNewLabel_10 = new JLabel("Press back to go to previous question");
// 		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_10.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
// 		lblNewLabel_10.setBounds(0, 384, 784, 28);
// 		frame.getContentPane().add(lblNewLabel_10);
		
// 		JLabel lblNewLabel_9 = new JLabel("Press submit to submit your answer");
// 		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_9.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
// 		lblNewLabel_9.setBounds(0, 357, 784, 28);
// 		frame.getContentPane().add(lblNewLabel_9);
		
// 		JLabel lblNewLabel_8 = new JLabel("Press next to skip and go to next question");
// 		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_8.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
// 		lblNewLabel_8.setBounds(0, 327, 784, 28);
// 		frame.getContentPane().add(lblNewLabel_8);
		
// 		JLabel lblNewLabel_7 = new JLabel("Controls");
// 		lblNewLabel_7.setForeground(Color.RED);
// 		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_7.setFont(new Font("Stencil", Font.BOLD, 29));
// 		lblNewLabel_7.setBounds(0, 287, 784, 40);
// 		frame.getContentPane().add(lblNewLabel_7);
		
// 		JLabel lblNewLabel_6 = new JLabel("Guess the correct movie for the given dialouges in the category \"Bollywood\"!");
// 		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_6.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
// 		lblNewLabel_6.setBounds(0, 248, 784, 28);
// 		frame.getContentPane().add(lblNewLabel_6);
		
// 		JLabel lblNewLabel_5 = new JLabel("Maths, Science and Computer Science questions");
// 		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_5.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
// 		lblNewLabel_5.setBounds(0, 209, 784, 28);
// 		frame.getContentPane().add(lblNewLabel_5);
		
// 		JLabel lblNewLabel_3 = new JLabel("Write the correct Answers for these General Knowledge, Culture, Riddles, History, ");
// 		lblNewLabel_3.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
// 		lblNewLabel_3.setBounds(10, 170, 774, 28);
// 		frame.getContentPane().add(lblNewLabel_3);
		
// 		JLabel lblNewLabel_1 = new JLabel("INSTRUCTIONS");
// 		lblNewLabel_1.setBackground(Color.GREEN);
// 		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 48));
// 		lblNewLabel_1.setBounds(0, 35, 784, 84);
// 		frame.getContentPane().add(lblNewLabel_1);
		
// 		JLabel lblNewLabel_2 = new JLabel("Choose any one field out of the 8");
// 		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 29));
// 		lblNewLabel_2.setForeground(Color.RED);
// 		lblNewLabel_2.setBounds(0, 119, 784, 40);
// 		frame.getContentPane().add(lblNewLabel_2);
		
		
// 		JLabel lblNewLabel_4 = new JLabel("New label");
// 		lblNewLabel_4.setBounds(45, 223, 46, 14);
// 		frame.getContentPane().add(lblNewLabel_4);
		
// 		Okay = new JButton("Play");
// 		Okay.setBackground(new Color(253, 245, 230));
// 		Okay.setFont(new Font("Stencil", Font.BOLD, 22));
// 		Okay.setBounds(579, 406, 150, 44);
// 		frame.getContentPane().add(Okay);

// 		JLabel lblNewLabel = new JLabel("New label");
// 		lblNewLabel.setBounds(0, 0, 784, 461);
// 		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/public/images/pen4.jpg")));
// 		frame.getContentPane().add(lblNewLabel);

// 		frame.getContentPane().revalidate();
// 		frame.getContentPane().repaint();
// 	}
	
// 	public void actionPerformed(ActionEvent ae) {
// 		if (ae.getSource() == Okay) {
// 			frame.setVisible(false);
// 			frame.dispose();
// 			Buttons buttons = new Buttons();
// 			buttons.getFrame().setVisible(true);
// 		}

// 		if (ae.getSource() == profileBtn) {
// 			frame.setVisible(false);
// 			frame.dispose();
// 			Profile profile = new Profile(Authenticate.getUser());
// 			profile.getFrame().setVisible(true);
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

        // Background Panel
        BackgroundPanel bgPanel = new BackgroundPanel("/public/images/pen4.jpg");
        bgPanel.setLayout(new GridBagLayout()); // Center Content
        add(bgPanel, BorderLayout.CENTER);

        // Panel to hold all labels & buttons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false); // Transparent background

        // Title Label
        JLabel title = new JLabel("INSTRUCTIONS", SwingConstants.CENTER);
        title.setFont(new Font("Stencil", Font.BOLD, 48));
        title.setForeground(Color.RED);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(title);

        // Sub-title
        JLabel subTitle = new JLabel("Choose any one field out of the 8", SwingConstants.CENTER);
        subTitle.setFont(new Font("Stencil", Font.BOLD, 29));
        subTitle.setForeground(Color.RED);
        subTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(subTitle);

        // Instructions (Retained Everything)
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
            instructionLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
            instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPanel.add(instructionLabel);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 8))); // Space between lines
        }

        // Buttons Panel
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

        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Space before buttons
        contentPanel.add(buttonPanel);

        // Add contentPanel to center of bgPanel
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