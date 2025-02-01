import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;
import java.io.* ;
import java.util.Random ;

public class Last implements ActionListener {
	int nextQues = 0 ;
	String ind, question, answer ;
	JFrame frame ;
	JLabel ques ;
	JLabel corr ;
	JButton sub ;
	JTextField ans ;
	Random rand ;
	
	Last() {
		frame = new JFrame() ;
		frame.setVisible(true) ;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE) ;
		frame.setLocationRelativeTo(null);											//opens frame from the center of the window
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout()) ;
		frame.setSize(300, 300) ;
		
		ques = new JLabel("Question") ;
		frame.add(ques) ;
		
		corr = new JLabel() ;
		frame.add(corr) ;
		
		sub = new JButton("Submit") ;
		frame.add(sub) ;
		
		ans = new JTextField(50) ;
		frame.add(ans) ;
		
		rand = new Random() ;
		
		sub.addActionListener(this) ;
		generateQues() ;
	}
	
	int countQues() {
		String str ;
		int count = 0 ;
		try(BufferedReader br = new BufferedReader(new FileReader (new File("LoginData.txt")))){
			while((str = br.readLine()) != null)
				count++ ;
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return count ;
	}
	
	void generateQues() {
		try(BufferedReader br = new BufferedReader(new FileReader (new File("Question.txt")))) {
			String s = br.readLine() ;
			int num = 0 , check = 0, starting_index = 0 , end_index = 0, rand_int = 0 ;
			String s_rand = " " ;
			
			int t_array[] = new int[countQues()] ;
			
			for(int i=0 ; i<t_array.length ; i++)
				t_array[i] = 0 ;
			
			while(num < 10) {
				while(check == 0) {
					rand_int = rand.nextInt(countQues()) + 1 ;
					s_rand = Integer.toString(rand_int) ;
					
					if(t_array[rand_int - 1] == 0) {
						check = 1 ;
					}	
					else {
						check = 0 ;
					}	
				}
				
				while(s != null) {
					for(int i=0 ; i<s.length() ; i++) {
						if(s.charAt(i) == '.') {
							starting_index = i ;
							for(int j=s.length() ; j>i ; j--) {
								if(s.charAt(i) == '!' || s.charAt(i) == '?' || s.charAt(i) == '.') {
									end_index = j ;
									break ;
								}
							}
							break ;
						}
					}
					
					ind = s.substring(0, starting_index) ;
					question = s.substring(starting_index + 1, end_index) ;
					answer = s.substring(end_index + 1, s.length()-1) ;
					
					if(ind.equals(s_rand)) {
						System.out.println("if") ;
						ques.setText(question) ;
					}else {
						System.out.println("else") ;
						s = br.readLine() ;
					}
				}			
				
				if(nextQues == 1) {
					s = br.readLine() ;
					num++ ;
				}			
				check = 0 ;
			}
		}catch(IOException e) {
			System.out.println("\nError in I/O of file.") ;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == sub) {
			nextQues = 1 ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Last() ;
			}
		}) ;
	}
}