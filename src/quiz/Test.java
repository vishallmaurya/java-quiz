import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;  
import java.io.*;
import java.util.Random ;

public class Test extends JFrame implements ActionListener {
	JLabel ques, check_ans ;
	JTextField ans ;
	JButton submit, next, quit ;
	boolean visited_array[] ;
	
	String FileName, completeStr ;
		
	int count = 0, total = 0, starting_index = 0, end_index = 0, n = 0, showNext = 0, correctAns = 0 ;
	
	Random rand = new Random() ;
	
	int rand_int[] = new int[10] ;
	String s_rand[] = new String[10] ;
		
/*	boolean visited_array[] ;
	boolean Computer_science[] ;
    boolean History[] ;
    boolean Mental_math[] ;
    boolean Culture[] ;
    boolean GK[] ;
    boolean Bollywood[] ;
    boolean Riddles[] ;
    boolean Science[] ;
*/	
	void countQues(String s) {
		String str ;

		try(BufferedReader br = new BufferedReader(new FileReader (new File(s)))){
			while((str = br.readLine()) != null)
				count++ ;
		}catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("Number of question :  " + count) ;
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
	int index[] ;
	
	void createRandom() {
		while(total < 10) {
			rand_int[total] = rand.nextInt(count) ;
			s_rand[total] = Integer.toString(rand_int[total]) ;
			
			while(isrepeated(total)) {
				rand_int[total] = rand.nextInt(count) + 1 ;
				s_rand[total] = Integer.toString(rand_int[total]) ;	
			}
		
			total++ ;
		}
		
		for(int i=0 ; i<total ; i++) {
			System.out.println(rand_int[i]) ;
		}
	}	
	
	void createQuesAns(String s) {
		question = new String[count] ;
		answer = new String[count] ;
		index = new int[count] ;
		
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
		
		for(int i=0 ; i<count ; i++) {
			System.out.println("question :    " + question[i]) ;
			System.out.println("Answer is :  " + answer[i]) ;
		}
	}
	
	Test() {
		ques = new JLabel() ;
		ques.setBounds(320,340,140,40) ;
		check_ans = new JLabel() ;
		ans = new JTextField(20) ;
		submit = new JButton("Submit") ;
		submit.setBounds(340,360, 160, 60) ;
		next = new JButton("Next") ;
		quit = new JButton("Quit") ;
		
		setSize(300,300) ;
		setLayout(new FlowLayout()) ;
		setVisible(true) ;
		setLocationRelativeTo(null);											//opens frame from the center of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		add(ques) ;
		add(submit) ;
		add(ans) ;
		
		ans.addActionListener(this) ;
		submit.addActionListener(this) ;
		next.addActionListener(this) ;
		quit.addActionListener(this) ;
		countQues("Riddles.txt") ;
		createRandom() ;
		createQuesAns("Riddles.txt") ;
		showQues() ;
	}
	
	void showQues() {
		ques.setText(question[rand_int[showNext]]) ;
		return ;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			add(check_ans) ;
			add(next) ;
			add(quit) ;
			submit.setEnabled(false) ;
			check_ans.setVisible(true) ;
			if((ans.getText()).equalsIgnoreCase(answer[rand_int[showNext]])) {
				check_ans.setText("Correct answer") ;
				correctAns++ ;
			}else {
				check_ans.setText("Correct answer is : " + answer[rand_int[showNext]]) ;
			}
		}
		if(ae.getSource() == next) {
			showNext++ ;
			
			submit.setEnabled(true) ;
			check_ans.setVisible(false) ;
			ans.setText(null) ;
			showQues() ;
		//	remove(next) ;
		//	remove(quit) ;
		}
		if(showNext == 10 || ae.getSource() == quit) {
			System.exit(0) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Test() ;
			}
		}) ;
	}
}