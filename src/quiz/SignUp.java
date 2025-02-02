import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.io.* ;

public class SignUp implements ActionListener {
	String name_s, user_name , pswd_s, conPswd_s ;
	char[] pswd, conPswd ;
	
	JFrame jf ;
	JLabel u, p, msg, name, c_p;
 	JTextField un, name_f ;														//creating textfield
	JPasswordField pa, c_pa ;															//creating passwordfield
	JButton bt ;
	
	SignUp() {
		jf = new JFrame("Sign Up") ;
		jf.setSize(700, 600);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);											//opens frame from the center of the window
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.getHSBColor(200, 780, 800));	//generating background colour through HSB
		
		Font f=new Font("Arial",Font.BOLD,15);									//font dec 
		
		name = new JLabel("Name     : ") ;
		bt = new JButton("Register") ;
		u = new JLabel("UserName : ");
		p = new JLabel("Password : ");
		c_p = new JLabel("Confirm Password : ") ;
		msg = new JLabel();
		name_f = new JTextField() ;
		un = new JTextField();													//creating textfield
		c_pa = new JPasswordField() ;
		pa = new JPasswordField();												//creating passwordfield
		
		name.setBounds(150, 120, 200, 40) ;
		name_f.setBounds(300, 120, 200, 40) ;
		u.setBounds(150,170,200,40);//set loc & size
		un.setBounds(300,170,200,40);
		p.setBounds(150,220,200,40);
		pa.setBounds(300,220,200,40);
		c_p.setBounds(150, 270, 200, 40) ;
		c_pa.setBounds(300, 270, 200, 40) ;
		bt.setBounds(280,370,140,50);
		msg.setBounds(270, 440, 200, 50) ;
		
		name.setFont(f) ;
		name_f.setFont(f) ;
		u.setFont(f);
		p.setFont(f);
		bt.setFont(f) ;
		c_p.setFont(f) ;
		msg.setFont(f) ;
		
		jf.add(u);//adding to container
		jf.add(name) ;
		jf.add(name_f) ;
		jf.add(p);
		jf.add(un);
		jf.add(bt);
		jf.add(msg);
		jf.add(pa);	
		jf.add(c_p) ;
		jf.add(c_pa) ;
		
		name_f.addActionListener(this) ;
		un.addActionListener(this) ;
		bt.addActionListener(this) ;
		pa.addActionListener(this) ;
		c_pa.addActionListener(this) ;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == name_f)
			name_s = name_f.getText()  ;
		if(ae.getSource() == un)
			user_name = un.getText() ;
		if(ae.getSource() == pa) {	
			pswd = pa.getPassword() ;
			pswd_s = String.valueOf(pswd) ;
		}
		if(ae.getSource() == c_pa) {
			conPswd = c_pa.getPassword() ;
			conPswd_s = String.valueOf(conPswd) ;
			
			if(!(pswd_s.equals(conPswd_s)))
				msg.setText("Invalid Password") ;
			else
				msg.setText(" ") ;
		}
			
		if(ae.getSource() == bt) {
			int check = 1 ;
			
			if(name_s == null || user_name == null || pswd_s == null || conPswd_s == null) {
				msg.setText("Please fill the details") ;
				check = 0 ;
			}else {
				msg.setText(" ") ;
				check = 1 ;
			}
			
			if(check == 1) {
				int existing_user =  check() ;
				
				if(existing_user == 0) {
					String data = user_name + ";" + pswd_s + ";" + name_s + ";\n" ;
					msg.setText("Successfully Registered") ;
					append(data) ;
					new Window2() ;
					jf.setVisible(false) ; 
				}else {
					msg.setText("Username already registered") ;
				}	
			}	
		}
	}
	
	void append(String data) {
		try {
			File f1 = new File("LoginData.txt");
			if(!f1.exists()) {
				f1.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(f1.getName(),true);
			BufferedWriter bw = new BufferedWriter(fileWritter);
			bw.write(data);
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return ;
	}
	
	int check() {
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
		
		if(user_index!=-1 && ((String.valueOf(user)).equalsIgnoreCase(name_data[user_index]))) {
			return 1 ;
		}else{
			return 0 ;
		}
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
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SignUp() ;
			}
		}) ;
	}
}