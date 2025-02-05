package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
// import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StartFrame implements ActionListener {
	private JButton start;
	private JButton quit;
	private JFrame frame;

	public StartFrame() {
		initialize();
		start.addActionListener(this);
		quit.addActionListener(this);
	}

    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 153));
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE).addGap(1)));

        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE).addGap(0)));

        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon("front.jpg"));

        start = new JButton("START");
        start.setBackground(new Color(51, 51, 0));
        start.setForeground(new Color(230, 230, 250));
        start.setFont(new Font("Swis721 Hv BT", Font.BOLD | Font.ITALIC, 15));
        frame.add(start);

        quit = new JButton("QUIT");
        quit.setBackground(new Color(102, 51, 0));
        quit.setForeground(Color.WHITE);
        quit.setFont(new Font("Swis721 BlkCn BT", Font.BOLD | Font.ITALIC, 15));
        frame.add(quit);

        JLabel think = new JLabel("");
        think.setHorizontalAlignment(SwingConstants.CENTER);
        think.setIcon(new ImageIcon("think.gif"));

        JLabel book = new JLabel("");
        book.setIcon(new ImageIcon("books.gif"));
        GroupLayout gl_panel = new GroupLayout(panel);

        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
                        .addComponent(logo, GroupLayout.PREFERRED_SIZE, 485, Short.MAX_VALUE)
                        .addGroup(gl_panel
                                .createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
                                        .addGap(6)
                                        .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_panel.createSequentialGroup()
                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                        .addComponent(think, GroupLayout.DEFAULT_SIZE, 276,
                                                                Short.MAX_VALUE)
                                                        .addContainerGap())
                                                .addGroup(gl_panel.createSequentialGroup().addGap(63)
                                                        .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(quit, Alignment.LEADING,
                                                                        GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                                .addComponent(start, Alignment.LEADING,
                                                                        GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                                        .addGap(72))))
                                .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(book, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addGap(100)))));

        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
                        .createSequentialGroup()
                        .addComponent(think, GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(start, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE).addGap(18)
                        .addComponent(quit, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE).addGap(34)
                        .addComponent(book, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addGap(194))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE).addGap(147)));

        panel.setLayout(gl_panel);
        frame.getContentPane().setLayout(groupLayout);
    }
	
    public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == start) {
			frame.setVisible(false);
			frame.dispose();
			Login loginFrame = new Login();
			loginFrame.getFrame().setVisible(true);
		}
		if (ae.getSource() == quit) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new StartFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
