package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import auth.Authenticate;
import db.CreateConnection;

public class SignUp extends JPanel implements ActionListener {
	private JTextField user_field, name_field;
	private JPasswordField pass_field, con_field;
	private JLabel pass_warn, usename_warn;
	private JButton btnNewButton;

	private CardLayout cardLayout;
	private JPanel mainPanel;

	public SignUp(CardLayout cardLayout, JPanel mainPanel) {
		this.cardLayout = cardLayout;
		this.mainPanel = mainPanel;
		initialize();
	}

	private void initialize() {
		setBackground(new Color(255, 204, 102));

		JLabel quote = new JLabel("");
		quote.setVerticalAlignment(SwingConstants.TOP);
		quote.setIcon(new ImageIcon(getClass().getResource("/public/images/SIGN UP 2.jpg")));

		JLabel email = new JLabel("EMAIL");
		email.setForeground(new Color(102, 0, 0));
		email.setFont(new Font("MV Boli", Font.BOLD, 15));

		JLabel password = new JLabel("PASSWORD");
		password.setForeground(new Color(102, 0, 0));
		password.setFont(new Font("MV Boli", Font.BOLD, 15));

		JLabel con_pass = new JLabel("Confirm Password");
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
		book_gif.setIcon(new ImageIcon(getClass().getResource("/public/gifs/learning_small.gif")));

		btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 204, 255));
		btnNewButton.addActionListener(this);

		JLabel name = new JLabel("NAME");
		name.setForeground(new Color(102, 51, 0));
		name.setFont(new Font("MV Boli", Font.BOLD, 15));

		name_field = new JTextField();
		name_field.setColumns(10);

		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(quote, GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(usename_warn, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(email, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(password, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(con_pass, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(name, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(user_field, GroupLayout.DEFAULT_SIZE, 120,
																Short.MAX_VALUE)
														.addComponent(name_field, GroupLayout.DEFAULT_SIZE, 120,
																Short.MAX_VALUE)
														.addComponent(pass_field, GroupLayout.DEFAULT_SIZE, 120,
																Short.MAX_VALUE)
														.addComponent(con_field, GroupLayout.DEFAULT_SIZE, 120,
																Short.MAX_VALUE)
														.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 120,
																Short.MAX_VALUE)))
										.addGroup(layout.createSequentialGroup()
												.addGap(266)
												.addComponent(book_gif, GroupLayout.PREFERRED_SIZE, 200,
														GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addComponent(quote, GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addGap(80)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(name)
										.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(email)
										.addComponent(user_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(usename_warn)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(password)
										.addComponent(pass_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(con_pass)
										.addComponent(con_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addComponent(btnNewButton)
								.addGap(48)
								.addComponent(book_gif, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(243)));
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnNewButton) {
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

			try {
				MongoDatabase database = CreateConnection.getDatabase();
				MongoCollection<Document> userCollection = database.getCollection("users");
				
				if (userCollection.find(new Document("email", email)).first() != null) {
					usename_warn.setText("Email already exists");
				} else {
					Document newUser = new Document("name", name).append("email", email).append("password", password);
					userCollection.insertOne(newUser);
					Authenticate.setUser(newUser.getObjectId("_id"));
					pass_warn.setText("Successfully registered");
					cardLayout.show(mainPanel, "instruction");
				}
			} catch (Exception exception) {
				System.err.println("Error during storing data:  " + exception.getMessage());
			} finally {
				CreateConnection.closeConnection();
			}
		}
	}
}