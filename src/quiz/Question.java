import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;
import java.io.* ;
import java.util.Random ;

public class Question {
	String ques , ans ;
	private Random rand ;
	private JFrame frame;
	private JTextField Answer;
	private JLabel question ;
	private JLabel check_ans ;
	private JButton Submit ;
	
	Question() {
		rand = new Random() ;
		
		frame = new JFrame();
		frame.setVisible(true) ;
		frame.setLocationRelativeTo(null) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		question = new JLabel("Question");
		question.setFont(new Font("Segoe Script", Font.BOLD, 22));
		question.setForeground(new Color(250, 235, 215));
		frame.add(question) ;
		
		check_ans = new JLabel() ;
		
		Answer = new JTextField();
		Answer.setForeground(new Color(0, 0, 0));
		Answer.setColumns(10);
		
		Submit = new JButton("Submit");
		Submit.setFont(new Font("Sylfaen", Font.BOLD, 15));
		Submit.setForeground(new Color(255, 255, 224));
		Submit.setBackground(new Color(139, 0, 0));
		frame.add(Submit) ;
		
	//	Answer.addActionListener(this) ;
	}
	
	private int countQues() {
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
	
	private void ques() {
		try(BufferedReader br = new BufferedReader(new FileReader (new File("LoginData.txt")))){
			String str = br.readLine() ;
			int starting_index = 0 , end_index = 0 , num = 0 , check = 0 , rand_int, r_generator = 0 ;
			String s_rand = " " ;
			
			int t_array[] = new int[countQues()] ;
			
			for(int i=0 ; i<t_array.length ; i++)
				t_array[i] = 0 ;
			
			while(num < 10) {
				while(r_generator == 0) {
					rand_int = rand.nextInt(countQues()) + 1 ;
					s_rand = Integer.toString(rand_int) ;
					
					if(t_array[rand_int - 1] == 0) {
						check = 0 ;
						r_generator = 1 ;
					}	
					else {
						check = 1 ;
						r_generator = 0 ;
					}	
				}
				
				r_generator = 0 ;
				
				if(check == 0 ) {
					while(str != null) {
						for(int i=0;i<str.length();i++){
							if(str.charAt(i)=='.'){
								starting_index=i;
								for(int j=i+1;j<str.length();j++){
									if(str.charAt(j)=='.' || str.charAt(j) == '!' || str.charAt(j) == '?'){
										end_index=j;
										break;
									}
								}
								break;
							}
						}
					
						String ind = str.substring(0, starting_index) ;
						ques = str.substring(starting_index + 1, end_index) ;
						ans = str.substring(end_index + 1, str.length()) ;
					
						if(ind.equals(s_rand)) {
							question.setText(ques) ;
							System.out.println("iii") ;
							submit() ;
						}else
							str = br.readLine() ;
					}
				}
				next: num++ ;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	private void answer() {
		Answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
	
			}	
		}) ;
	}
	
	private void submit() {
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ans.equals(Answer.getText())) {
					frame.add(check_ans) ;
					check_ans.setText("Correct Answer") ;
				}else {
					frame.add(check_ans) ;
					check_ans.setText("Wrong Answer ---> Correct Answer is : " + ans) ;
				}
			}
		}) ;
	}	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Question() ;
			}
		}) ;
	}
}