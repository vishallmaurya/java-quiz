import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.* ;
import java.util.Random ;

public class Vertical_General implements ActionListener {

	private JFrame frame;
	private JTextField Answer;
	private JButton Next ;
	private JLabel Question ;
	private JButton Submit ;
	private JButton Quit ;
	private JLabel corr ;
	private JButton Back ;
	
	boolean visited_array[] ;
	
	String completeStr ;
	
	int count = 0, total = 0, starting_index = 0, end_index = 0, n = 0, showNext = 0, correctAns = 0, attempt = 0, back_counter = 0 ;
	
	Random rand = new Random() ;
	int rand_int[] = new int[10] ;
	
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
	
	boolean isrepeated(int num) {
		if(visited_array[num]) 
			return true ;
		else
			return false ;
	}
	
	String question[] ;
	String answer[] ;
	
	void createRandom() {
		while(total < 10) {
			rand_int[total] = rand.nextInt(count) ;
			
			while(isrepeated(total)) {
				rand_int[total] = rand.nextInt(count) + 1 ;
			}
		
			total++ ;
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
						for(int j=i+1;j<completeStr.length();j++){
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
	
	public Vertical_General() {
		initialize() ;
		
		Answer.addActionListener(this) ;
		Submit.addActionListener(this) ;
		Quit.addActionListener(this) ;
		Next.addActionListener(this) ;
		Back.addActionListener(this) ;
		Back.setEnabled(false) ;
		countQues("History.txt") ;
		createRandom() ;
		createQuesAns("History.txt") ;
		showQues() ;
	}
	
	void showQues() {
		Question.setText(question[rand_int[showNext]]) ;
		return ;
	}
	
/*	public void makeQues() {
		question[0] = "Who is the first person of our country? " ;
		question[1] = "The Longest river of India? " ;
		question[2] = "Write the name of capital of Assam." ;
		question[3] = "The most abundant gas in the Earth's atmosphere?" ;
		question[4] = "Where is Char-Minar situated?" ;
		question[5] = "The Pulie Badze Wildlife Sanctuary, which is natural habitat of Grey-bellied Tragopan, is located in which state? " ;
		question[6] = "Who heads the Cabinet Committee on Economic Affairs in India?" ;
		question[7] = "The famous World Heritage Site 'Basilica of Bom Jesus' is located in which among the following places in India?" ;
		question[8] = "The Bori Wildlife Sanctuary (BWS) is located in which state?" ;
		question[9] = "How many Union Territories in India? " ;
		answer[0] = "President" ;
		answer[1] = "Ganga" ;
		answer[2] = "Dispur" ;
		answer[3] = "Nitrogen" ;
		answer[4] = "hyderabad" ;
		answer[5] = "Nagaland" ;
		answer[6] = "Prime Minister" ;
		answer[7] = "Goa" ;
		answer[8] = "Madhya Pradesh" ;
		answer[9] = "8" ;
	}
*/
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
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == Submit) {
			attempt++ ;
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
		
		if(showNext == 10 || ae.getSource() == Quit){  
			JOptionPane.showMessageDialog(null ,"Total Question= 10\nYou attempted= "+attempt+"\nCorrect Answer= "+ correctAns +"\nWrong Answer= "+(attempt-correctAns));  
			System.exit(0);  
        } 
			
		if(ae.getSource() == Next) {
			showNext++ ;
			back_counter++ ;
			
			Submit.setEnabled(true) ;
			corr.setVisible(false) ;
			Answer.setText(null) ;
			showQues() ;
		}
		
		if(ae.getSource() == Back) {
			showNext-- ;
			--back_counter ;
			
			Submit.setEnabled(true) ;
			corr.setVisible(false) ;
			Answer.setText(null) ;
			showQues() ;
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
					new Vertical_General();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}