package quiz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utils.BackgroundPanel;

public class StartFrame implements ActionListener {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JButton start;
    private JButton quit;
    private JFrame frame;

    public StartFrame() {
        initialize();
        start.addActionListener(this);
        quit.addActionListener(this);
    }

    private void initialize() {
        frame = new JFrame("Quizathon");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        BackgroundPanel startPanel = new BackgroundPanel("/public/images/front.jpg");
        startPanel.setLayout(null);

        start = new JButton("START");
        start.setBounds(300, 580, 200, 50);
        start.setBackground(new Color(51, 51, 0));
        start.setForeground(new Color(230, 230, 250));
        start.setFont(new Font("Swis721 Hv BT", Font.BOLD | Font.ITALIC, 20));
        startPanel.add(start);

        quit = new JButton("QUIT");
        quit.setBounds(800, 580, 200, 50);
        quit.setBackground(new Color(102, 51, 0));
        quit.setForeground(Color.WHITE);
        quit.setFont(new Font("Swis721 BlkCn BT", Font.BOLD | Font.ITALIC, 20));
        startPanel.add(quit);

        ImageIcon thinkIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel think1 = new JLabel(thinkIcon);
        think1.setBounds(1150, 20, 200, 200);
        startPanel.add(think1);

        JLabel think2 = new JLabel(thinkIcon);
        think2.setBounds(0, 20, 200, 200);
        startPanel.add(think2);

        Login loginPanel = new Login(cardLayout, mainPanel);
        SignUp signUpPanel = new SignUp(cardLayout, mainPanel);
        Profile profilePanel = new Profile(cardLayout, mainPanel);
        Instruction instructionPanel = new Instruction(cardLayout, mainPanel, profilePanel);
        Result resultPanel = new Result(cardLayout, mainPanel, profilePanel);
        QuestionFrame quesFramePanel = new QuestionFrame(cardLayout, mainPanel, resultPanel);
        Buttons buttonPanel = new Buttons(cardLayout, mainPanel, quesFramePanel, profilePanel);

        mainPanel.add(startPanel, "start");
        mainPanel.add(loginPanel, "login");
        mainPanel.add(instructionPanel, "instruction");
        mainPanel.add(signUpPanel, "signup");
        mainPanel.add(buttonPanel, "buttons");
        mainPanel.add(quesFramePanel, "questionFrame");
        mainPanel.add(profilePanel, "profile");
        mainPanel.add(resultPanel, "result");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            cardLayout.show(mainPanel, "login"); 
        }
        if (ae.getSource() == quit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StartFrame());
    }
}
