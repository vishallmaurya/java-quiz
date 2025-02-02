import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

public class Result implements ActionListener{

	private JFrame frame;
	private JLabel Total ;
	private JLabel Attempted ;
	private JLabel Correct ;
	private JLabel Wrong ;
	private JButton Quit ;
	private JButton Play_Again ;
	int attempt , correct ;	

	public Result(int att , int corr) {
		attempt = att ;
		correct = corr ;		
		initialize();			
		Quit.addActionListener(this) ;
		Play_Again.addActionListener(this) ;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Total = new JLabel("TOTAL QUESTION = 10 ", JLabel.CENTER);
		Total.setFont(new Font("Stencil", Font.BOLD, 26));
		Total.setForeground(Color.WHITE);
		Total.setBounds(126, 161, 529, 33);
		panel.add(Total);
		
		Attempted = new JLabel("YOU ATTEMPTED = " + attempt, JLabel.CENTER);
		Attempted.setFont(new Font("Stencil", Font.BOLD, 26));
		Attempted.setForeground(Color.WHITE);
		Attempted.setBounds(123, 213, 532, 33);
		panel.add(Attempted);
		
		Correct = new JLabel("CORRECT ANSWERS = " + correct, JLabel.CENTER);
		Correct.setFont(new Font("Stencil", Font.BOLD, 26));
		Correct.setForeground(Color.WHITE);
		Correct.setBounds(126, 276, 529, 33);
		panel.add(Correct);
		
		Wrong = new JLabel("WRONG ANSWERS = " + (attempt - correct), JLabel.CENTER);
		Wrong.setForeground(Color.WHITE);
		Wrong.setFont(new Font("Stencil", Font.BOLD, 26));
		Wrong.setBounds(126, 344, 529, 33);
		panel.add(Wrong);
		
		Play_Again = new JButton("PLAY AGAIN");
		Play_Again.setFont(new Font("Stencil", Font.BOLD, 22));
		Play_Again.setBackground(new Color(253, 245, 230));
		Play_Again.setBounds(50, 406, 172, 44);
		panel.add(Play_Again);
		
		Quit = new JButton("QUIT");
		Quit.setBackground(new Color(253, 245, 230));
		Quit.setFont(new Font("Stencil", Font.BOLD, 22));
		Quit.setBounds(579, 406, 150, 44);
		panel.add(Quit);
		
		JLabel Scorecard = new JLabel("SCORECARD", JLabel.CENTER);
		Scorecard.setHorizontalAlignment(SwingConstants.CENTER);
		Scorecard.setForeground(Color.WHITE);
		Scorecard.setFont(new Font("Stencil", Font.BOLD, 58));
		Scorecard.setBounds(110, 28, 512, 100);
		panel.add(Scorecard);
		
		JLabel img = new JLabel("New label");
		img.setBounds(0, 0, 784, 461);
		img.setIcon(new ImageIcon("faded5.jpg"));
		panel.add(img);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == Play_Again) {
			new Buttons() ;
			frame.setVisible(false) ;
		}
		
		if(ae.getSource() == Quit) {
			System.exit(0) ;
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Result(0,0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}