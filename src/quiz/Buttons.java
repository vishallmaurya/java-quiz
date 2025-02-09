package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import auth.Authenticate;
import utils.SetImage;

public class Buttons extends JPanel implements ActionListener {
    private JButton profileBtn;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private QuestionFrame questionFrame;
    private Profile profile;

    public Buttons(CardLayout cardLayout, JPanel mainPanel, QuestionFrame questionFrame,
                    Profile profile) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.questionFrame = questionFrame;
        this.profile = profile;
        initialize();
    }

    private void initialize() {
        setBackground(new Color(255, 218, 185));
        setLayout(null);

        JPanel lblBackground = new SetImage("/public/images/fields.jpg", 0, 0, 400, getHeight());
        add(lblBackground);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                lblBackground.setBounds(0, 0, 700, getHeight());
                lblBackground.repaint();
            }
        });

        profileBtn = new JButton("Profile");
        profileBtn.setFont(new Font("Stencil", Font.PLAIN, 16));
        profileBtn.setBackground(new Color(253, 245, 230));
        profileBtn.setBounds(1200, 10, 120, 40);
        add(profileBtn);

        JLabel lblHeading = new JLabel("CHOOSE THE APPROPRIATE FIELD");
        lblHeading.setFont(new Font("MV Boli", Font.BOLD, 20));
        lblHeading.setForeground(new Color(165, 42, 42)); // Darker Red
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeading.setBounds(800, 100, 400, 30);
        add(lblHeading);

        JPanel buttonPanel1 = new JPanel(new GridLayout(4, 1, 20, 25));
        JPanel buttonPanel2 = new JPanel(new GridLayout(4, 1, 20, 25));
        buttonPanel1.setOpaque(false);
        buttonPanel2.setOpaque(false);
        buttonPanel1.setBounds(850, 200, 150, 200);
        buttonPanel2.setBounds(1030, 230, 150, 200);
        add(buttonPanel1);
        add(buttonPanel2);

        btnNewButton = createButton("G.K.");
        btnNewButton_1 = createButton("CULTURE");
        btnNewButton_2 = createButton("RIDDLES");
        btnNewButton_3 = createButton("HISTORY");
        btnNewButton_4 = createButton("MATHS");
        btnNewButton_5 = createButton("SCIENCE");
        btnNewButton_6 = createButton("Bollywood");
        btnNewButton_7 = createButton("COMPUTER");

        buttonPanel1.add(btnNewButton);
        buttonPanel1.add(btnNewButton_1);
        buttonPanel1.add(btnNewButton_2);
        buttonPanel1.add(btnNewButton_3);
        buttonPanel2.add(btnNewButton_4);
        buttonPanel2.add(btnNewButton_5);
        buttonPanel2.add(btnNewButton_6);
        buttonPanel2.add(btnNewButton_7);

        ImageIcon bookIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/small_open_book.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel book = new JLabel(bookIcon);
        book.setBounds(1160, 30, 200, 200);
        add(book);

        ImageIcon thinkIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel think = new JLabel(thinkIcon);
        think.setBounds(920, 500, 200, 200);
        add(think);

        profileBtn.addActionListener(this);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Stencil", Font.PLAIN, 16));
        button.setBackground(new Color(102, 0, 0));
        button.setForeground(new Color(255, 204, 255));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == profileBtn) {
            profile.setUser(Authenticate.getUser());
            cardLayout.show(mainPanel, "profile");
        }
        else if (ae.getSource() == btnNewButton) {
            questionFrame.setSubject("gk");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_1) {
            questionFrame.setSubject("culture");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_2) {
            questionFrame.setSubject("riddles");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_3) {
            questionFrame.setSubject("history");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_4) {
            questionFrame.setSubject("maths");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_5) {
            questionFrame.setSubject("science");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_6) {
            questionFrame.setSubject("bollywood");
            cardLayout.show(mainPanel, "questionFrame");
        }
        else if (ae.getSource() == btnNewButton_7) {
            questionFrame.setSubject("cs");
            cardLayout.show(mainPanel, "questionFrame");
        }
    }
}
