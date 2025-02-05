package quiz;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import auth.Authenticate;

public class Instruction implements ActionListener {
	private JFrame frame;
	private JButton profileBtn;
	private JButton Okay ;

	public Instruction() {
		initialize();
		
		profileBtn.addActionListener(this);
		Okay.addActionListener(this) ;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		profileBtn = new JButton("Profile");
		profileBtn.setBackground(new Color(253, 245, 230));
		profileBtn.setFont(new Font("Stencil", Font.PLAIN, 16));
		profileBtn.setBounds(650, 5, 100, 40);
		frame.getContentPane().add(profileBtn);
		
		JLabel lblNewLabel_10 = new JLabel("Press back to go to previous question");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(0, 384, 784, 28);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("Press submit to submit your answer");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(0, 357, 784, 28);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Press next to skip and go to next question");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(0, 327, 784, 28);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Controls");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Stencil", Font.BOLD, 29));
		lblNewLabel_7.setBounds(0, 287, 784, 40);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Guess the correct movie for the given dialouges in the category \"Bollywood\"!");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(0, 248, 784, 28);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Maths, Science and Computer Science questions");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(0, 209, 784, 28);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Write the correct Answers for these General Knowledge, Culture, Riddles, History, ");
		lblNewLabel_3.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 170, 774, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("INSTRUCTIONS");
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 48));
		lblNewLabel_1.setBounds(0, 35, 784, 84);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Choose any one field out of the 8");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 29));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(0, 119, 784, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 784, 461);
		lblNewLabel.setIcon(new ImageIcon("./public/images/pen4.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(45, 223, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		Okay = new JButton("Play");
		Okay.setBackground(new Color(253, 245, 230));
		Okay.setFont(new Font("Stencil", Font.BOLD, 22));
		Okay.setBounds(579, 406, 150, 44);
		frame.getContentPane().add(Okay);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Okay) {
			frame.setVisible(false);
			frame.dispose();
			Buttons buttons = new Buttons();
			buttons.getFrame().setVisible(true);
		}

		if (ae.getSource() == profileBtn) {
			frame.setVisible(false);
			frame.dispose();
			Profile profile = new Profile(Authenticate.getUser());
			profile.getFrame().setVisible(true);
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
}