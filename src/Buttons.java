import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.* ;

public class Buttons implements ActionListener {

	private JFrame frame;
	private JButton btnNewButton ;
	private JButton btnNewButton_1 ;
	private JButton btnNewButton_2 ;
	private JButton btnNewButton_3 ;
	private JButton btnNewButton_4 ;
	private JButton btnNewButton_5 ;
	private JButton btnNewButton_6 ;
	private JButton btnNewButton_7 ;
	
	public Buttons() {
		initialize();
		
		btnNewButton.addActionListener(this) ;
		btnNewButton_1.addActionListener(this) ;
		btnNewButton_2.addActionListener(this) ;
		btnNewButton_3.addActionListener(this) ;
		btnNewButton_4.addActionListener(this) ;
		btnNewButton_5.addActionListener(this) ;
		btnNewButton_6.addActionListener(this) ;
		btnNewButton_7.addActionListener(this) ;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true) ;
		frame.setBounds(60, 60, 800, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 102));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("fields.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("CHOOSE THE APPROPRIATE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("MV Boli", Font.BOLD, 20));
		
		btnNewButton = new JButton("G.K.");
		btnNewButton.setBackground(new Color(102, 0, 0));
		btnNewButton.setForeground(new Color(255, 204, 255));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		
		btnNewButton_1 = new JButton("CULTURE");
		btnNewButton_1.setBackground(new Color(102, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 204, 255));
		
		btnNewButton_2 = new JButton("RIDDLES");
		btnNewButton_2.setBackground(new Color(102, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 204, 255));
		
		btnNewButton_3 = new JButton("HISTORY");
		btnNewButton_3.setBackground(new Color(102, 0, 0));
		btnNewButton_3.setForeground(new Color(255, 204, 255));
		
		btnNewButton_4 = new JButton("MATHS");
		btnNewButton_4.setBackground(new Color(102, 0, 0));
		btnNewButton_4.setForeground(new Color(255, 204, 255));
		
		btnNewButton_5 = new JButton("SCIENCE");
		btnNewButton_5.setBackground(new Color(102, 0, 0));
		btnNewButton_5.setForeground(new Color(255, 204, 255));
		
		btnNewButton_6 = new JButton("Bollywood");
		btnNewButton_6.setBackground(new Color(102, 0, 0));
		btnNewButton_6.setForeground(new Color(255, 204, 255));
		
		btnNewButton_7 = new JButton("COMPUTER");
		btnNewButton_7.setBackground(new Color(102, 0, 0));
		btnNewButton_7.setForeground(new Color(255, 204, 255));
		
		JLabel lblNewLabel_2 = new JLabel("FIELD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Label");
		lblNewLabel_3.setIcon(new ImageIcon("small_open_book.gif"));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(20, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
												.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
												.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
											.addGap(180))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(162)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
												.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
												.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
												.addComponent(btnNewButton_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
											.addGap(28)))
									.addGap(378)))
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGap(367)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 541, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(38)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(btnNewButton_1)
					.addGap(11)
					.addComponent(btnNewButton_2)
					.addGap(11)
					.addComponent(btnNewButton_3)
					.addGap(11)
					.addComponent(btnNewButton_4)
					.addGap(11)
					.addComponent(btnNewButton_5)
					.addGap(11)
					.addComponent(btnNewButton_6)
					.addGap(11)
					.addComponent(btnNewButton_7)
					.addGap(25))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnNewButton) {
			new QuestionFrame("Question.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_1) {
			new QuestionFrame("CultureNew.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_2) {
			new QuestionFrame("Riddles.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_3) {
			new QuestionFrame("History.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_4) {
			new QuestionFrame("MentalAbility.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_5) {
			new QuestionFrame("Science_questions.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_6) {
			new QuestionFrame("bollywood.txt") ;
			frame.setVisible(false) ;
		}
		if(ae.getSource() == btnNewButton_7){
			new QuestionFrame("ComputerSci.txt") ;
			frame.setVisible(false) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Buttons();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
