import java.io.* ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class Login {
	JFrame jfr ;
	JTextField jtf ;
	JLabel jlb, warnLB ;
	
	Login() {
		jfr = new JFrame("Login") ;
		jtf = new JTextField(20) ;
		jlb = new JLabel("UserName") ;
		warnLB = new JLabel("") ;
		
		jfr.setVisible(true) ;
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE) ;
		jfr.setSize(300, 300) ;
		jfr.setLocationRelativeTo(null) ;
		jfr.setLayout(new FlowLayout()) ;
		
		jfr.add(jlb) ;
		jfr.add(jtf) ;
		
		jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String u_name, str ;
				u_name = jtf.getText() ;
				
				try(BufferedReader br = new BufferedReader(new FileReader(new File("LoginData.txt")))) {
					while((str = br.readLine()) != null) {
						if(u_name.equals(str)) {
							warnLB.setText("Already Existing User.") ;
							jfr.add(warnLB) ;
						}else{
							try {
								BufferedWriter wr = new BufferedWriter(new FileWriter("LoginData.txt", true)) ;
								wr.write(u_name) ;
								warnLB.setText("You are successfully registered.") ;
								jfr.add(warnLB) ;
							}catch(IOException e) {
								System.out.println("\n\t\t\tI/O Exception...") ;
							}	
						}
					}
				}catch(FileNotFoundException e) {
					System.out.println ("Filename not found!");
				}catch(IOException e) {
					System.out.println("\n\t\t\tI/O Exception...") ;
				}
			}
		}) ;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login() ;
			}
		}) ;
	}
}