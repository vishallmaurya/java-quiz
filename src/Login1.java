/* import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.io.* ;

public class Login1 implements ActionListener {
	JFrame jf ;
	JLabel u ;
	JLabel p ;
	JLabel msg ;
 	JTextField un ;//creating textfield
	JPasswordField pa ;//creating passwordfield
	JButton bt ;
	Font f ;
	
	Login1() {
		jf = new JFrame("Login") ;
		jf.setSize(700, 600);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);											//opens frame from the center of the window
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.getHSBColor(200, 780, 800));	//generating background colour through HSB
		
		f = new Font("Arial",Font.BOLD,15);									//font dec 
		
		bt = new JButton("Done") ;
		u = new JLabel("UserName : ");
		p = new JLabel("Password : ");
		msg = new JLabel();
		un = new JTextField();													//creating textfield
		pa = new JPasswordField();												//creating passwordfield
		
		u.setBounds(150,50,200,40);//set loc & size
		un.setBounds(250,50,200,40);
		p.setBounds(150,120,200,40);
		pa.setBounds(250,120,200,40);
		bt.setBounds(280,250,140,50);
		
		u.setFont(f);
		p.setFont(f);
		bt.setFont(f) ;
		
		jf.add(u);//adding to container
		jf.add(p);
		jf.add(un);
		jf.add(bt);
		jf.add(msg);
		jf.add(pa);		
		
		bt.addActionListener(this) ;
	}
	
	static int binarySearch(String[] arr, String x,int length) {
		int l = 0, r = length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int res = x.compareTo(arr[m]);
			// Check if x is present at mid
			if (res == 0)
				return m;
			// If x greater, ignore left half
			if (res > 0)
				l = m + 1;
			// If x is smaller, ignore right half
			else
				r = m - 1;
		}
		
		return -1;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== bt) {
			String user = un.getText();
			char[] pswd = pa.getPassword();
			
			String name_data[]=new String[10];
			String pswd_data[]=new String[10];
			int index=0;
			
			try(BufferedReader user_file = new BufferedReader(new FileReader (new File("LoginData.txt")))){
				String s = user_file.readLine();
				int starting_index = 0, end_index = 0;
			
				while(s!= null){
					for(int i=0;i<s.length();i++){
						if(s.charAt(i)==';'){
							starting_index=i;
							for(int j=i+1;j<s.length();j++){
								if(s.charAt(j)==';'){
									end_index=j;
									break;
								}
							}
							break;
						}
					}	
					
					if(index>=name_data.length){
						String temp1[]=new String[name_data.length*2];
						String temp2[]=new String[name_data.length*2];
						for(int i=0;i<name_data.length;i++){
							temp1[i]=name_data[i];
							temp2[i]=pswd_data[i];
						}
						name_data=temp1;
						pswd_data=temp2;
					}
			
					name_data[index]=s.substring(0, starting_index);
					pswd_data[index]=s.substring(starting_index+1, end_index);
					index++;
					s=user_file.readLine();
				}
			}catch(FileNotFoundException e) {
				System.out.println ("Filename not found!");
			}catch(IOException ex){
				ex.printStackTrace();
			}
		
			String temp,temp_pswd ;
			
			for (int i = 0; i < index-1; i++) {
				for (int j = i + 1; j < index; j++) {
				// to compare one string with other strings
					if (name_data[i].compareTo(name_data[j]) > 0) {
					// swapping
						temp = name_data[i];
						temp_pswd=pswd_data[i];
						name_data[i] = name_data[j];
						pswd_data[i] = pswd_data[j];
						name_data[j] = temp;
						pswd_data[j] = temp_pswd;
					}
				}
			}
			int user_index=binarySearch(name_data, user,index);
	
			if(user_index!=-1 && ((String.valueOf(pswd)).equalsIgnoreCase(pswd_data[user_index]))) {
				msg.setBounds(320,340,140,40);
				msg.setText("Success") ;
				msg.setFont(f);
			}else{
				msg.setBounds(250,340,400,40);
				msg.setFont(f);
				msg.setText("Invalid Username or Password") ;
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login1() ;
			}
		}) ;
	}
} */

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.io.* ;

public class Login1 implements ActionListener {
	JFrame jf ;
	JLabel u ;
	JLabel p ;
	JLabel l ;
	JLabel msg ;
 	JTextField un ;//creating textfield
	JPasswordField pa ;//creating passwordfield
	JButton  bt ,bt2 ;
	Font f ;
	
	Login1() {
		jf = new JFrame("Login") ;
		jf.setSize(800, 430);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);											//opens frame from the center of the window
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		//jf.getContentPane().setBackground(Color.getHSBColor(200, 780, 800));	//generating background colour through HSB
		jf.getContentPane().setBackground(Color.orange);
		f = new Font("Arial",Font.BOLD,15);									//font dec 
		
		bt = new JButton("Login") ;
		u = new JLabel("UserName : ");
		p = new JLabel("Password : ");
		l = new JLabel("New User ? ");
		bt2 = new JButton("Sign Up");
		msg = new JLabel();
		un = new JTextField();													//creating textfield
		pa = new JPasswordField();												//creating passwordfield
		
		u.setBounds(150,50,200,40);//set loc & size
		un.setBounds(250,50,200,40);
		p.setBounds(150,120,200,40);
		pa.setBounds(250,120,200,40);
		bt.setBounds(290,200,100,40);
		bt2.setBounds(580,270,150,40);
		l.setBounds(490,270,200,40);
		
		bt.setBackground(Color.cyan);
		bt2.setBackground(Color.green);
		
		u.setFont(f);
		p.setFont(f);
		bt.setFont(f);
		bt2.setFont(f);
		l.setFont(f);
		
		jf.add(u);//adding to container
		jf.add(p);
		jf.add(un);
		jf.add(bt);
		jf.add(l);
		jf.add(msg);
		jf.add(pa);	
		jf.add(bt2);
		
		bt.addActionListener(this) ;
		bt2.addActionListener(this) ;
	}
	
	static int binarySearch(String[] arr, String x,int length) {
		int l = 0, r = length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int res = x.compareTo(arr[m]);
			// Check if x is present at mid
			if (res == 0)
				return m;
			// If x greater, ignore left half
			if (res > 0)
				l = m + 1;
			// If x is smaller, ignore right half
			else
				r = m - 1;
		}
		
		return -1;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== bt) {
			String user = un.getText();
			char[] pswd = pa.getPassword();
			
			String name_data[]=new String[10];
			String pswd_data[]=new String[10];
			int index=0;
			
			try(BufferedReader user_file = new BufferedReader(new FileReader (new File("LoginData.txt")))){
				String s = user_file.readLine();
				int starting_index = 0, end_index = 0;
			
				while(s!= null){
					for(int i=0;i<s.length();i++){
						if(s.charAt(i)==';'){
							starting_index=i;
							for(int j=i+1;j<s.length();j++){
								if(s.charAt(j)==';'){
									end_index=j;
									break;
								}
							}
							break;
						}
					}	
					
					if(index>=name_data.length){
						String temp1[]=new String[name_data.length*2];
						String temp2[]=new String[name_data.length*2];
						for(int i=0;i<name_data.length;i++){
							temp1[i]=name_data[i];
							temp2[i]=pswd_data[i];
						}
						name_data=temp1;
						pswd_data=temp2;
					}
			
					name_data[index]=s.substring(0, starting_index);
					pswd_data[index]=s.substring(starting_index+1, end_index);
					index++;
					s=user_file.readLine();
				}
			}catch(FileNotFoundException e) {
				System.out.println ("Filename not found!");
			}catch(IOException ex){
				ex.printStackTrace();
			}
		
			String temp,temp_pswd ;
			
			for (int i = 0; i < index-1; i++) {
				for (int j = i + 1; j < index; j++) {
				// to compare one string with other strings
					if (name_data[i].compareTo(name_data[j]) > 0) {
					// swapping
						temp = name_data[i];
						temp_pswd=pswd_data[i];
						name_data[i] = name_data[j];
						pswd_data[i] = pswd_data[j];
						name_data[j] = temp;
						pswd_data[j] = temp_pswd;
					}
				}
			}
			int user_index=binarySearch(name_data, user,index);
	
			if(user_index!=-1 && ((String.valueOf(pswd)).equalsIgnoreCase(pswd_data[user_index]))) {
				msg.setBounds(320,340,140,40);
				msg.setText("Success") ;
				msg.setFont(f);
				
				new Window2() ;
				jf.setVisible(false) ;
			}else{
				msg.setBounds(250,340,400,40);
				msg.setFont(f);
				msg.setText("Invalid Username or Password") ;
			}
		}
		
		if(ae.getSource() == bt2) {
			new SignUp() ;
			jf.setVisible(false) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login1() ;
			}
		}) ;
	}
}