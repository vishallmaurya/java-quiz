package quiz;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import db.CreateConnection;


public class SignUp implements ActionListener {	
	private JFrame frame;
	private JTextField user_field;
	private JPasswordField pass_field;
	private JPasswordField con_field;
	private JTextField name_field;
	private JLabel email ;
	private JLabel password ;
	private JLabel con_pass ;
	private JLabel pass_warn ;
	private JLabel usename_warn ;
	private JLabel name ;
	private JButton btnNewButton ;

	public SignUp() {
		initialize();
		
		btnNewButton.addActionListener(this) ;
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
		quote.setIcon(new ImageIcon("./public/images/SIGN UP 2.jpg"));
		
		email = new JLabel("EMAIL");
		email.setForeground(new Color(102, 0, 0));
		email.setBackground(new Color(102, 51, 0));
		email.setFont(new Font("MV Boli", Font.BOLD, 15));
		
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
		book_gif.setIcon(new ImageIcon("./public/gifs/learning_small.gif"));
		
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
												.addComponent(email, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
						.addComponent(email)
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
		if (ae.getSource() == btnNewButton) {
			System.out.println("button clicked");
			String name = name_field.getText();
			String email = user_field.getText();
			String password = String.valueOf(pass_field.getPassword());
			String confirmPassword = String.valueOf(con_field.getPassword());

			if (!password.equals(confirmPassword)) {
				pass_warn.setText("Passwords do not match!");
				return;
			}

			if (name.trim().equals("") || email.trim().equals("") || password.trim().equals("")
					|| confirmPassword.trim().equals("")) {
				pass_warn.setText("All fields are mandatory");
				return;
			}

			MongoDatabase database = CreateConnection.getDatabase();
			MongoCollection<Document> userCollection = database.getCollection("users");

			Document existingUser = userCollection.find(new Document("email", email)).first();
			
			if (existingUser != null) {
				usename_warn.setText("Email already exists");
			} else {
				Document newUser = new Document("name", name).append("email", email).append("password", password);
				userCollection.insertOne(newUser);
				pass_warn.setText("Successfully registered");
				// new Instruction();
			}
		}
	}
		
	public JFrame getFrame() {
		return frame;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new SignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}