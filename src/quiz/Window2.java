import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.io.* ;
import java.util.Random ;

public class Window2 extends JFrame {
	int corrCount = 0 , qCount = 0 ;
	JTextField af ;
	JLabel ql, corr ;
	Random rand ;
	String ques, ans ;
	
	public Window2() {
		setTitle("Question") ;
		af = new JTextField() ;
		ql = new JLabel("Hello ") ;
		corr = new JLabel() ;
		rand = new Random() ;
		
		/* JLabel q1 = new JLabel() ;
		JLabel q2 = new JLabel() ;
		JLabel q3 = new JLabel() ;
		JLabel q4 = new JLabel() ;
		JLabel q5 = new JLabel() ;
		JLabel q6 = new JLabel() ;
		JLabel q7 = new JLabel() ;
		JLabel q8 = new JLabel() ;
		JLabel q9 = new JLabel() ;
		JLabel q10 = new JLabel() ;
		
		JLabel c1 = new JLabel() ;
		JLabel c2 = new JLabel() ;
		JLabel c3 = new JLabel() ;
		JLabel c4 = new JLabel() ;
		JLabel c5 = new JLabel() ;
		JLabel c6 = new JLabel() ;
		JLabel c7 = new JLabel() ;
		JLabel c8 = new JLabel() ;
		JLabel c9 = new JLabel() ;
		JLabel c10 = new JLabel() ;
		
		JTextField a1 = new JTextField() ;
		JTextField a2 = new JTextField() ;
		JTextField a3 = new JTextField() ;
		JTextField a4 = new JTextField() ;
		JTextField a5 = new JTextField() ;
		JTextField a6 = new JTextField() ;
		JTextField a7 = new JTextField() ;
		JTextField a8 = new JTextField() ;
		JTextField a9 = new JTextField() ;
		JTextField a10 = new JTextField() ;
		
		labList[0] = (JLabel)add(q1) ;
		labList[1] = (JLabel)add(q2) ;
		labList[2] = (JLabel)add(q3) ;
		labList[3] = (JLabel)add(q4) ;
		labList[4] = (JLabel)add(q5) ;
		labList[5] = (JLabel)add(q6) ;
		labList[6] = (JLabel)add(q7) ;
		labList[7] = (JLabel)add(q8) ;
		labList[8] = (JLabel)add(q9) ;
		labList[9] = (JLabel)add(q10) ;
		
		corrList[0] = (JLabel)add(c1) ;
		corrList[1] = (JLabel)add(c2) ;
		corrList[2] = (JLabel)add(c3) ;
		corrList[3] = (JLabel)add(c4) ;
		corrList[4] = (JLabel)add(c5) ;
		corrList[5] = (JLabel)add(c6) ;
		corrList[6] = (JLabel)add(c7) ;
		corrList[7] = (JLabel)add(c8) ;
		corrList[8] = (JLabel)add(c9) ;
		corrList[9] = (JLabel)add(c10) ;
		
		textList[0] = (JTextField)add(a1) ;
		textList[1] = (JTextField)add(a2) ;
		textList[2] = (JTextField)add(a3) ;
		textList[3] = (JTextField)add(a4) ;
		textList[4] = (JTextField)add(a5) ;
		textList[5] = (JTextField)add(a6) ;
		textList[6] = (JTextField)add(a7) ;
		textList[7] = (JTextField)add(a8) ;
		textList[8] = (JTextField)add(a9) ;
		textList[9] = (JTextField)add(a10) ; */
		
		/*for(int i=0 ; i<10 ; i++)
			textList[i].addActionListener(this) ;*/

		setSize(300, 300) ;
		setVisible(true) ;
		setLocationRelativeTo(null) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		add(ql) ;
		add(af) ;
		
		question() ;
	}
	
	public void question() {
		try(BufferedReader br = new BufferedReader(new FileReader(new File("Question.txt")))) {
			int line = 0 , starting_index = 0 , end_index = 0 ;
			String str = br.readLine() ;
			
			while(br.readLine() != null)
				line++ ;
			
			int t_array[] = new int[line] ;
			
			for(int i=0 ; i<line ; i++)
				t_array[i] = 0 ;
			
			for(int k=0 ; k<10 ; k++) {
				int rand_int = rand.nextInt(line) + 1 ;
				String s_rand = Integer.toString(rand_int) ;
				
				if(t_array[rand_int - 1] == 0) {
					while(str != null) {
						System.out.println("str") ;
						for(int i=0; i<str.length(); i++){
							if(str.charAt(i)=='.'){
								starting_index=i;
								for(int j=i+1; j<str.length(); j++){
									if(str.charAt(j)=='.' || str.charAt(j) == '?' || str.charAt(j) == '!'){
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
						System.out.println(ind) ;
						System.out.println(s_rand) ;
						if(ind.equals(s_rand)) {
							ql.setText(ques) ;
							answer(ans) ;
							break ;
						}
					}	
				}
			}
			
		}catch(FileNotFoundException e) {
			System.out.println ("Filename not found!");
		}catch(IOException exc) {
			System.out.println("\n\t\t\tI/O Exception...") ;
		}
	}	
	
	public void answer(String ans) {
		af.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String user_ans = af.getText() ;
				if(user_ans.equalsIgnoreCase(ans)) {
					corr.setText("Your answer is Correct.") ;
				}else {
					corr.setText("Correct Answer is :  " + ans.toUpperCase()) ;
				}
			}
		}) ;		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window2() ;
			}
		}) ;
	}
}