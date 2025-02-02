import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel mainPanel = new JPanel(new CardLayout()); // Using CardLayout

        // Creating two panels
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is Panel 1"));
        JButton btn1 = new JButton("Go to Panel 2");
        panel1.add(btn1);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));
        JButton btn2 = new JButton("Go to Panel 1");
        panel2.add(btn2);

        // Adding panels to mainPanel
        mainPanel.add(panel1, "Panel1");
        mainPanel.add(panel2, "Panel2");

        // Getting CardLayout reference
        CardLayout cl = (CardLayout) mainPanel.getLayout();

        // Button actions to switch panels
        btn1.addActionListener(e -> cl.show(mainPanel, "Panel2"));
        btn2.addActionListener(e -> cl.show(mainPanel, "Panel1"));

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
