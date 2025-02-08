// package quiz;

// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;
// import javax.swing.GroupLayout.Alignment;
// import javax.swing.LayoutStyle.ComponentPlacement;

// public class StartFrame implements ActionListener {
//         private JButton start;
//         private JButton quit;
//         private JFrame frame;

//         public StartFrame() {
//                 initialize();
//                 start.addActionListener(this);
//                 quit.addActionListener(this);
//         }

//         private void initialize() {
//                 frame = new JFrame();
//                 frame.setVisible(true);
//                 frame.setBounds(100, 100, 800, 500);
//                 frame.setLocationRelativeTo(null);
//                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//                 JPanel panel = new JPanel();
//                 panel.setBackground(new Color(255, 255, 153));
//                 GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
//                 groupLayout.setHorizontalGroup(
//                                 groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
//                                                 .createSequentialGroup()
//                                                 .addComponent(panel, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
//                                                 .addGap(1)));

//                 groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//                                 .addGroup(groupLayout.createSequentialGroup()
//                                                 .addComponent(panel, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
//                                                 .addGap(0)));

//                 JLabel logo = new JLabel("");
//                 logo.setIcon(new ImageIcon(getClass().getResource("/public/images/front.jpg")));

//                 start = new JButton("START");
//                 start.setBackground(new Color(51, 51, 0));
//                 start.setForeground(new Color(230, 230, 250));
//                 start.setFont(new Font("Swis721 Hv BT", Font.BOLD | Font.ITALIC, 15));
//                 frame.add(start);

//                 quit = new JButton("QUIT");
//                 quit.setBackground(new Color(102, 51, 0));
//                 quit.setForeground(Color.WHITE);
//                 quit.setFont(new Font("Swis721 BlkCn BT", Font.BOLD | Font.ITALIC, 15));
//                 frame.add(quit);

//                 JLabel think = new JLabel("");
//                 think.setHorizontalAlignment(SwingConstants.CENTER);
//                 think.setIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif")));

//                 JLabel book = new JLabel("");
//                 book.setIcon(new ImageIcon(getClass().getResource("/public/gifs/books.gif")));
//                 GroupLayout gl_panel = new GroupLayout(panel);

//                 gl_panel.setHorizontalGroup(
//                                 gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
//                                                 .createSequentialGroup()
//                                                 .addComponent(logo, GroupLayout.PREFERRED_SIZE, 485, Short.MAX_VALUE)
//                                                 .addGroup(gl_panel
//                                                                 .createParallelGroup(Alignment.LEADING)
//                                                                 .addGroup(gl_panel.createSequentialGroup()
//                                                                                 .addGap(6)
//                                                                                 .addGroup(gl_panel.createParallelGroup(
//                                                                                                 Alignment.LEADING)
//                                                                                                 .addGroup(gl_panel
//                                                                                                                 .createSequentialGroup()
//                                                                                                                 .addPreferredGap(
//                                                                                                                                 ComponentPlacement.RELATED)
//                                                                                                                 .addComponent(think,
//                                                                                                                                 GroupLayout.DEFAULT_SIZE,
//                                                                                                                                 276,
//                                                                                                                                 Short.MAX_VALUE)
//                                                                                                                 .addContainerGap())
//                                                                                                 .addGroup(gl_panel
//                                                                                                                 .createSequentialGroup()
//                                                                                                                 .addGap(63)
//                                                                                                                 .addGroup(gl_panel
//                                                                                                                                 .createParallelGroup(
//                                                                                                                                                 Alignment.TRAILING)
//                                                                                                                                 .addComponent(quit,
//                                                                                                                                                 Alignment.LEADING,
//                                                                                                                                                 GroupLayout.DEFAULT_SIZE,
//                                                                                                                                                 151,
//                                                                                                                                                 Short.MAX_VALUE)
//                                                                                                                                 .addComponent(start,
//                                                                                                                                                 Alignment.LEADING,
//                                                                                                                                                 GroupLayout.DEFAULT_SIZE,
//                                                                                                                                                 151,
//                                                                                                                                                 Short.MAX_VALUE))
//                                                                                                                 .addGap(72))))
//                                                                 .addGroup(Alignment.TRAILING, gl_panel
//                                                                                 .createSequentialGroup()
//                                                                                 .addPreferredGap(
//                                                                                                 ComponentPlacement.RELATED)
//                                                                                 .addComponent(book,
//                                                                                                 GroupLayout.PREFERRED_SIZE,
//                                                                                                 90,
//                                                                                                 GroupLayout.PREFERRED_SIZE)
//                                                                                 .addGap(100)))));

//                 gl_panel.setVerticalGroup(
//                                 gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
//                                                 .createSequentialGroup()
//                                                 .addComponent(think, GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)
//                                                 .addPreferredGap(ComponentPlacement.RELATED)
//                                                 .addComponent(start, GroupLayout.PREFERRED_SIZE, 47,
//                                                                 GroupLayout.PREFERRED_SIZE)
//                                                 .addGap(18)
//                                                 .addComponent(quit, GroupLayout.PREFERRED_SIZE, 47,
//                                                                 GroupLayout.PREFERRED_SIZE)
//                                                 .addGap(34)
//                                                 .addComponent(book, GroupLayout.PREFERRED_SIZE, 65,
//                                                                 GroupLayout.PREFERRED_SIZE)
//                                                 .addGap(194))
//                                                 .addGroup(gl_panel.createSequentialGroup()
//                                                                 .addComponent(logo, GroupLayout.PREFERRED_SIZE, 463,
//                                                                                 Short.MAX_VALUE)
//                                                                 .addGap(147)));

//                 panel.setLayout(gl_panel);
//                 frame.getContentPane().setLayout(groupLayout);
//         }

//         public void actionPerformed(ActionEvent ae) {
//                 try {
//                     if (ae.getSource() == start) {
//                             // frame.dispose();
//                             frame.setVisible(false);
//                     JOptionPane.showMessageDialog(frame, "An error occurred: ");
                        
//                         Login loginFrame = new Login();
//                         loginFrame.getFrame().setVisible(true);
//                     }
//                     if (ae.getSource() == quit) {
//                         System.exit(0);
//                     }
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                     JOptionPane.showMessageDialog(frame, "An error occurred: " + e.getMessage());
//                 }
//             }
            

//         public static void main(String[] args) {
//                 SwingUtilities.invokeLater(new Runnable() {
//                         public void run() {
//                                 try {
//                                         new StartFrame();
//                                 } catch (Exception e) {
//                                         e.printStackTrace();
//                                 }
//                         }
//                 });
//         }
// }

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

        // Start panel with background
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
        JLabel think = new JLabel(thinkIcon);
        think.setBounds(1150, 20, 200, 200); // Top-right corner
        startPanel.add(think);

        ImageIcon bookIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/books.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel book = new JLabel(bookIcon);
        book.setBounds(0, 20, 200, 200); // Top-left corner
        startPanel.add(book);

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
