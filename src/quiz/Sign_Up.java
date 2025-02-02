import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.* ;

public class Sign_Up implements ActionListener {
	String name_s, user_name , pswd_s, conPswd_s ;
	char[] pswd, conPswd ;
	
	private JFrame frame;
	private JTextField user_field;
	private JPasswordField pass_field;
	private JPasswordField con_field;
	private JTextField name_field;
	private JLabel username ;
	private JLabel password ;
	private JLabel con_pass ;
	private JLabel pass_warn ;
	private JLabel usename_warn ;
	private JLabel name ;
	private JButton btnNewButton ;

	public Sign_Up() {
		initialize();
		
		user_field.addActionListener(this) ;
		name_field.addActionListener(this) ;
		btnNewButton.addActionListener(this) ;
		pass_field.addActionListener(this) ;
		con_field.addActionListener(this) ;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true) ;
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 102));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
		);
		
		JLabel quote = new JLabel("");
		quote.setVerticalAlignment(SwingConstants.TOP);
		quote.setIcon(new ImageIcon("SIGN UP 2.jpg"));
		
		username = new JLabel("USERNAME");
		username.setForeground(new Color(102, 0, 0));
		username.setBackground(new Color(102, 51, 0));
		username.setFont(new Font("MV Boli", Font.BOLD, 15));
		
		password = new JLabel("PASSWORD");
		password.setBackground(new Color(102, 51, 0));
		password.setFont(new Font("MV Boli", Font.BOLD, 15));
		password.setForeground(new Color(102, 0, 0));
		
		con_pass = new JLabel("Confirm Password");
		con_pass.setBackground(new Color(102, 51, 0));
		con_pass.setForeground(new Color(102, 0, 0));
		con_pass.setFont(new Font("MV Boli", Font.BOLD, 15));
		
		user_field = new JTextField();
		user_field.setColumns(10);
		
		pass_field = new JPasswordField();
		
		con_field = new JPasswordField();
		con_field.setEchoChar('*');
		
		pass_warn = new JLabel("");
		pass_warn.setFont(new Font("MV Boli", Font.BOLD, 13));
		pass_warn.setForeground(new Color(255, 0, 0));
		
		usename_warn = new JLabel("");
		usename_warn.setFont(new Font("MV Boli", Font.BOLD, 12));
		usename_warn.setForeground(new Color(255, 0, 0));
		
		JLabel book_gif = new JLabel("");
		book_gif.setHorizontalAlignment(SwingConstants.CENTER);
		book_gif.setIcon(new ImageIcon("learning_small.gif"));
		
		btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 204, 255));
		
		name = new JLabel("NAME");
		name.setForeground(new Color(102, 51, 0));
		name.setFont(new Font("MV Boli", Font.BOLD, 15));
		
		name_field = new JTextField();
		name_field.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(quote, GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(usename_warn, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(con_pass, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
												.addComponent(username, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(name, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(pass_warn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(23)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
									.addGap(11))
								.addComponent(con_field, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(pass_field, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(user_field, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(name_field)
									.addGap(3))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(66)
							.addComponent(book_gif, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(quote, GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(name)
						.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(username)
						.addComponent(user_field, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(usename_warn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(password)
						.addComponent(pass_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(con_pass)
						.addComponent(con_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(pass_warn)
							.addGap(32))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(book_gif, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(243))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == name_field)
			name_s = name_field.getText()  ;
		if(ae.getSource() == user_field)
			user_name = user_field.getText() ;
		if(ae.getSource() == pass_field) {	
			pswd = pass_field.getPassword() ;
			pswd_s = String.valueOf(pswd) ;
		}
		if(ae.getSource() == con_field) {
			conPswd = con_field.getPassword() ;
			conPswd_s = String.valueOf(conPswd) ;
			
			if(!(pswd_s.equals(conPswd_s)))
				pass_warn.setText("Invalid Password") ;
			else
				pass_warn.setText(" ") ;
		}
			
		if(ae.getSource() == btnNewButton) {
			int check = 1 ;
			
			
			if(check == 1) {
				int existing_user =  check() ;
				
				if(existing_user == 0) {
					String data = user_name + ";" + pswd_s + ";" + name_s + ";\n" ;
					usename_warn.setText("Successfully Registered") ;
					append(data) ;
					new Instruction() ;
					frame.setVisible(false) ; 
				}else {
					usename_warn.setText("Usename already exists") ;
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
		String user = user_field.getText();
		char[] pswd = pass_field.getPassword();
			
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
				try {
					new Sign_Up();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}