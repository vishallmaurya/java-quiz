/*
 * Importing the packages
 */
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import java.io.* ;						
import java.util.LinkedHashSet;			
import java.util.Random;				
import java.util.Set;						
import java.util.Arrays ;

/* Initialize the class QuestionFrame in which we are trying to display questions on JFrame and take answers
 * from the user.
 */
public class QuestionFrame implements ActionListener{

	private JFrame frame;				// Instance of JFrame which contains all the components that we are added in it.
	private JTextField Answer;			// Instance of JTextField which is used to take input(answer) from the user.
	private JButton Next ;				// Instance of JButton which helps user to skip the question and take user to next question 
	private JLabel Question ;			// Instance of JLabel which show questions to user for quiz.
	private JButton Submit ;			// Instance of JButton which is used to check whether the user entered correct answer or not.
	private JButton Quit ;				// Instance of JButton which provide functionality to user to quit. If he/she wants to quit in bet
	private JLabel corr ;	
	private JButton Back ;
	private JButton Final ;
	private JProgressBar progressBar;
	boolean visited_array[] ;
	private int i = 0;
	String completeStr ;
	
	int count = 0, total = 0, starting_index = 0, end_index = 0, n = 0, showNext = 0, correctAns = 0, attempt = 0, back_counter = 0 , nextCount = 0 ;
	
	Random rand = new Random() ;
	Integer rand_int[] = new Integer[10] ;
	
	void countQues(String s) {
		String str ;

		try(BufferedReader br = new BufferedReader(new FileReader (new File(s)))){
			while((str = br.readLine()) != null)
				count++ ;
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		visited_array = new boolean[count] ;
		for(int i=0 ; i<visited_array.length ; i++)
			visited_array[i] = false ;		
	}
	
	String question[] ;
	String answer[] ;
	
	void createRandom() {
		Set<Integer>set = new LinkedHashSet<Integer>();
		while (set.size() < 10) {
			set.add(rand.nextInt(count)+1);
		}
		
		set.toArray(rand_int);
		
		for(int i=0 ; i<10 ; i++) {
			System.out.println(rand_int[i]) ;
		}
	}
	
	void createQuesAns(String s) {
		question = new String[count] ;
		answer = new String[count] ;
		
		try(BufferedReader br = new BufferedReader(new FileReader (new File(s)))) {
			completeStr = br.readLine() ;
			
			while(completeStr != null) {
				for(int i=0;i<completeStr.length();i++){
					if(completeStr.charAt(i)=='.'){
						starting_index = i;
						for(int j=completeStr.length() - 1 ; j>i ; j--){
							if(completeStr.charAt(j)=='.' || completeStr.charAt(j) == '!' || completeStr.charAt(j) == '?'){
								end_index=j;
								break;
							}
						}
						break;
					}
					
				}
				
				String str = completeStr.substring(0, starting_index-1) ;
				str = str.replaceAll("\\s", "") ;

				question[n] = completeStr.substring(starting_index + 1, end_index + 1) ;
				answer[n++] = completeStr.substring(end_index + 1, completeStr.length()) ;				
				
				completeStr = br.readLine() ;
			}
		}catch(IOException e) {
			System.out.println("Error in I/O of file") ;
		}
	}
	
	public QuestionFrame(String filename) {
		initialize();
		
		Answer.addActionListener(this) ;
		Submit.addActionListener(this) ;
		Quit.addActionListener(this) ;
		Next.addActionListener(this) ;
		Back.addActionListener(this) ;
		Final.addActionListener(this) ;
		Back.setEnabled(false) ;
		Submit.setEnabled(false) ;
		Final.setEnabled(false) ;
		countQues(filename) ;
		createRandom() ;
		createQuesAns(filename) ;
		showQues() ;
	}

	void showQues() {
		Question.setText((showNext + 1) + ".  " + question[rand_int[showNext]]) ;
		return ;
	}
	
	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 1350, 729);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(275, 5, 800, 300);
		logo.setIcon(new ImageIcon("quiz_it_out.jpg"));
		panel.add(logo);
		
		Question = new JLabel("");
		Question.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
		Question.setBounds(65, 349, 1285, 31);
		panel.add(Question);
		
		Answer = new JTextField();
		Answer.setBounds(65, 393, 639, 36);
		panel.add(Answer);
		Answer.setColumns(10);
		
		Next = new JButton("NEXT");
		Next.setBackground(new Color(128, 0, 0));
		Next.setForeground(new Color(255, 255, 255));
		Next.setFont(new Font("Stencil", Font.BOLD, 13));
		Next.setBounds(65, 466, 97, 31);
		panel.add(Next);
		
		Submit = new JButton("SUBMIT");
		Submit.setBackground(new Color(128, 0, 0));
		Submit.setFont(new Font("Stencil", Font.BOLD, 14));
		Submit.setForeground(new Color(255, 228, 196));
		Submit.setBounds(204, 465, 97, 32);
		panel.add(Submit);
		
		corr = new JLabel("");
		corr.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		corr.setBounds(65, 522, 596, 31);
		panel.add(corr);
		
		Back = new JButton("BACK");
		Back.setBackground(new Color(128, 0, 0));
		Back.setFont(new Font("Stencil", Font.BOLD, 14));
		Back.setForeground(new Color(255, 228, 181));
		Back.setBounds(346, 466, 97, 31);
		panel.add(Back);
		
		Quit = new JButton("QUIT");
		Quit.setFont(new Font("Stencil", Font.BOLD, 14));
		Quit.setForeground(new Color(255, 240, 245));
		Quit.setBackground(new Color(128, 0, 0));
		Quit.setBounds(1205, 469, 114, 28);
		panel.add(Quit);
		
		JLabel dog = new JLabel("");
		dog.setIcon(new ImageIcon("small_dog.gif"));
		dog.setBounds(617, 506, 255, 212);
		panel.add(dog);
			
		JLabel think1 = new JLabel("");
		think1.setIcon(new ImageIcon("think.gif"));
		think1.setBounds(35, 21, 208, 206);
		panel.add(think1);
		
		JLabel think2 = new JLabel("");
		think2.setIcon(new ImageIcon("think.gif"));
		think2.setBounds(1125, 21, 194, 215);
		panel.add(think2);
		
		JLabel book = new JLabel(" ");
		book.setIcon(new ImageIcon("learning_small.gif"));
		book.setBounds(1125, 578, 200, 120);
		panel.add(book);
		
		Final = new JButton("Final  Submission");
		Final.setBackground(new Color(128, 0, 0));
		Final.setFont(new Font("Stencil", Font.BOLD, 14));
		Final.setForeground(new Color(255, 228, 181));
		Final.setBounds(65, 600, 200, 31);
		panel.add(Final);		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(1086, 240, 255, 28);
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setValue(0);
		
		panel.add(progressBar);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == Answer) {
			Submit.setEnabled(true) ;
		}
		
		if(ae.getSource() == Submit) {
			attempt++ ;
			i += 10;
			progressBar.setValue(i);
			back_counter-- ;
			corr.setVisible(true) ;
			Submit.setEnabled(false) ;
			if((Answer.getText()).equalsIgnoreCase(answer[rand_int[showNext]])) {
				corr.setText("Correct answer") ;
				correctAns++ ;
			}else {
				corr.setText("Correct answer is :  " + answer[rand_int[showNext]]) ;
			}
		}
		
		if(ae.getSource() == Quit){  
			frame.setVisible(false) ;
			new Result(attempt, correctAns) ;
        } 
			
		if(ae.getSource() == Next) {
			showNext++ ;
			back_counter++ ;
			nextCount++ ;
			
			corr.setVisible(false) ;
			Answer.setText(null) ;
			showQues() ;
		}
		
		if(ae.getSource() == Back) {
			showNext-- ;
			--back_counter ;
			nextCount-- ;
			
			corr.setVisible(false) ;
			Answer.setText(null) ;
			showQues() ;
		}
		
		if(back_counter > 0) {
			Back.setEnabled(true) ;
		}else {
			Back.setEnabled(false) ;
		}
		
		if(nextCount == 9) {
			Next.setEnabled(false) ;
		}
		
		if(nextCount != 9) {
			Next.setEnabled(true) ;
		}
		
		if(attempt == 10) {
			Submit.setEnabled(false) ;
			Final.setEnabled(true) ;
		}
		
		if(ae.getSource() == Final) {
			frame.setVisible(false) ;
			new Result(attempt, correctAns) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new QuestionFrame("Riddles.txt");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}