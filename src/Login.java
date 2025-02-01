import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.* ;

public class Login implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnNewButton ;
	private JButton btnNewButton_1 ;
	private JLabel lblNewLabel_6 ;

	public Login() {
		initialize();
		btnNewButton.addActionListener(this) ;
		btnNewButton_1.addActionListener(this) ;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true) ;
		frame.setBounds(100, 100, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE).addGap(0))
		);
		
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("login_page.jpg"));
		
		textField = new JTextField();
		textField.setColumns(10);
		frame.add(textField) ;
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBackground(new Color(139, 0, 0));
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_1.setFont(new Font("Ravie", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setForeground(new Color(139, 0, 0));
		lblNewLabel_2.setFont(new Font("Ravie", Font.BOLD, 12));
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		frame.add(textField_1) ;
		
		JLabel lblNewLabel_3 = new JLabel("NEW USER ?");
		lblNewLabel_3.setForeground(new Color(139, 0, 0));
		lblNewLabel_3.setFont(new Font("Ravie", Font.BOLD, 14));
		
		btnNewButton = new JButton("Sign Up");
		btnNewButton.setBackground(new Color(139, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Ravie", Font.BOLD, 13));
		frame.add(btnNewButton) ;
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("small_bulb.gif"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("small_open_book.gif"));
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(new Color(139, 0, 0));
		btnNewButton_1.setForeground(new Color(250, 250, 210));
		btnNewButton_1.setFont(new Font("Ravie", Font.BOLD, 12));
		frame.add(btnNewButton_1) ;
		
		lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 552, Short.MAX_VALUE).addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
							.addGap(19).addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18).addComponent(textField, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(4)).addGroup(gl_panel.createSequentialGroup()
							.addGap(19).addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(18).addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(4)).addGroup(gl_panel.createSequentialGroup()
							.addGap(19).addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup().addGap(19)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup().addGap(85)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(26)).addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(28).addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))).addGap(10))
		);
		
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(78)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
				.addGap(9).addComponent(lblNewLabel_1))
				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)).addGap(73)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addComponent(lblNewLabel_2))
				.addGap(6).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_1)
				.addGroup(gl_panel.createSequentialGroup().addGap(12)
				.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_3)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
				.addGap(36).addComponent(btnNewButton).addGap(25)
				.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(69)
				.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))).addGap(34))
		);
		
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
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
		if(ae.getSource()== btnNewButton_1) {
			String user = textField.getText();
			char[] pswd = textField_1.getPassword();
			
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
			int user_index = binarySearch(name_data, user,index);
	
			if(user_index!=-1 && ((String.valueOf(pswd)).equalsIgnoreCase(pswd_data[user_index]))) {
				lblNewLabel_6.setBounds(320,340,140,40);
				lblNewLabel_6.setText("Success") ;
				
				new Instruction() ;
				frame.setVisible(false) ;
			}else{
				lblNewLabel_6.setBounds(250,340,400,40);
				lblNewLabel_6.setText("Invalid input") ;
			}
		}
		
		if(ae.getSource() == btnNewButton) {
			new Sign_Up() ;
			frame.setVisible(false) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}