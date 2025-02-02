package quiz;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import db.CreateConnection;

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
		lblNewLabel.setIcon(new ImageIcon("./public/images/login_page.jpg"));
		
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
		lblNewLabel_4.setIcon(new ImageIcon("./public/gifs/small_bulb.gif"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("./public/gifs/small_open_book.gif"));
		
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
	
	
	public void actionPerformed(ActionEvent ae) {
		MongoDatabase database = CreateConnection.getDatabase();
		MongoCollection<Document> usersCollection = database.getCollection("users");

		if (ae.getSource() == btnNewButton_1) {
			String user = textField.getText();
			String password = String.valueOf(textField_1.getPassword());

			Document query = new Document("email", user).append("password", password);
			Document foundUser = usersCollection.find(query).first();

			if (foundUser != null) {
				lblNewLabel_6.setBounds(320, 340, 140, 40);
				lblNewLabel_6.setText("Success");

				// new Instruction() ;
				// frame.setVisible(false);
			} else {
				lblNewLabel_6.setBounds(250, 340, 400, 40);
				lblNewLabel_6.setText("Invalid input");
				lblNewLabel_6.revalidate();
				lblNewLabel_6.repaint();
			}
		}

		if (ae.getSource() == btnNewButton) {
			frame.setVisible(false);
			frame.dispose(); 
			SignUp signupFrame = new SignUp();
			signupFrame.getFrame().setVisible(true);
		}
	}
	
	public JFrame getFrame() {
		return frame ;
	}
}