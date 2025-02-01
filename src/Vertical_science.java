import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.* ;

public class Vertical_science implements ActionListener {

	private JFrame frame;
	private JTextField Answer;
	private JButton Next ;
	private JLabel Question ;
	private JButton Submit ;
	private JButton Quit ;
	private JLabel corr ;
	private JButton Back ;
	
	int count = 0 , correctAns = 0, attempt = 0, back_counter = 0 ;
	
	String question[] = new String[10] ;
	String answer[] = new String[10] ;

	public Vertical_science() {
		initialize() ;
		
		Answer.addActionListener(this) ;
		Submit.addActionListener(this) ;
		Quit.addActionListener(this) ;
		Next.addActionListener(this) ;
		Back.addActionListener(this) ;
		Back.setEnabled(false) ;
		makeQues() ;
		createQues() ;
	}
	
	public void makeQues() {
		question[0] = "How many bones are in the human body?" ;
		question[1] = "What is the hardest natural substance on Earth?" ;
		question[2] = "What does DNA stand for?" ;
		question[3] = "Which is the main gas that makes up the Earth’s atmosphere?" ;
		question[4] = "At what temperature are Celsius and Fahrenheit equal?" ;
		question[5] = "What is the biggest planet in our solar system?" ;
		question[6] = "What is a material that will not carry an electrical charge called?" ;
		question[7] = "If you get scurvy, what vitamin are you deficient in?" ;
		question[8] = "What is equal to mass times acceleration?" ;
		question[9] = " What is the lightest metal?" ;
		answer[0] = "206" ;
		answer[1] = "Diamond" ;
		answer[2] = "Deoxyribonucleic acid" ;
		answer[3] = "Nitrogen" ;
		answer[4] = "-40" ;
		answer[5] = "Jupiter" ;
		answer[6] = "Insulaor" ;
		answer[7] = "C" ;
		answer[8]="Force";
		answer[9] = "Lithium" ;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true) ;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE) );
		
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE));
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("quiz_it_out.jpg"));
		
		Question = new JLabel("Question");
		Question.setHorizontalAlignment(SwingConstants.LEFT);
		Question.setFont(new Font("Segoe Script", Font.BOLD, 19));
		Question.setForeground(new Color(250, 235, 215));
		
		Answer = new JTextField();
		Answer.setForeground(new Color(0, 0, 0));
		Answer.setColumns(20);
		
		Next = new JButton("Next");
		Next.setFont(new Font("Sylfaen", Font.BOLD, 15));
		Next.setForeground(new Color(255, 255, 224));
		Next.setBackground(new Color(102, 0, 0));
		
		JLabel quiz = new JLabel("");
		quiz.setHorizontalAlignment(SwingConstants.CENTER);
		quiz.setIcon(new ImageIcon("quesmark.gif"));
		
		Submit = new JButton("Submit");
		Submit.setForeground(new Color(255, 204, 255));
		Submit.setFont(new Font("Sylfaen", Font.BOLD, 13));
		Submit.setBackground(new Color(102, 0, 0));
		
		Quit = new JButton("Quit");
		Quit.setFont(new Font("Sylfaen", Font.BOLD, 15));
		Quit.setBackground(new Color(102, 0, 0));
		Quit.setForeground(new Color(255, 204, 255));
		
		JLabel lblNewLabel = new JLabel("");
		
		corr = new JLabel("");
		corr.setFont(new Font("Segoe Script", Font.BOLD, 15));
		
		Back = new JButton("Back");
		Back.setBackground(new Color(102, 0, 0));
		Back.setForeground(new Color(255, 204, 255));
		Back.setFont(new Font("Sylfaen", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(logo, GroupLayout.PREFERRED_SIZE, 1352, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(91))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(Next, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(Back, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
								.addComponent(Quit, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(quiz, GroupLayout.PREFERRED_SIZE, 985, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Answer, GroupLayout.PREFERRED_SIZE, 817, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addComponent(corr)
							.addGap(189))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Question, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
							.addGap(354)))
					.addGap(139))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(logo, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Question, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Answer, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(corr))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(quiz, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(Next)
								.addComponent(Back))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Submit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(Quit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void createQues() {
		Question.setText(question[count]) ;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == Submit) {
			attempt++ ;
			back_counter-- ;
			corr.setVisible(true) ;
			Submit.setEnabled(false) ;
			if((Answer.getText()).equalsIgnoreCase(answer[count])) {
				corr.setText("Correct answer") ;
				correctAns++ ;
			}else {
				corr.setText("Correct answer is :  " + answer[count]) ;
			}
		}
		
		if(count == 10 || ae.getSource() == Quit){  
			JOptionPane.showMessageDialog(null ,"Total Question= 10\nYou attempted= "+attempt+"\nCorrect Answer= "+ correctAns +"\nWrong Answer= "+(attempt-correctAns));  
			System.exit(0);  
        } 
			
		if(ae.getSource() == Next) {
			count++ ;
			back_counter++ ;
			
			Submit.setEnabled(true) ;
			corr.setVisible(false) ;
			Answer.setText(null) ;
			createQues() ;
		}
		
		if(ae.getSource() == Back) {
			count-- ;
			--back_counter ;
			
			Submit.setEnabled(true) ;
			corr.setVisible(false) ;
			Answer.setText(null) ;
			createQues() ;
		}
		
		if(back_counter > 0) {
			Back.setEnabled(true) ;
		}else {
			Back.setEnabled(false) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Vertical_science() ;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}