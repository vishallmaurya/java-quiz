// package quiz;

// import java.awt.* ;
// import java.awt.event.* ;
// import javax.swing.* ;

// import javax.swing.GroupLayout.Alignment;
// import javax.swing.LayoutStyle.ComponentPlacement;

// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;

// import auth.Authenticate;

// import org.bson.Document;
// import db.CreateConnection;

// public class Login implements ActionListener{

// 	private JFrame frame;
// 	private JTextField textField;
// 	private JPasswordField textField_1;
// 	private JButton btnNewButton ;
// 	private JButton btnNewButton_1 ;
// 	private JLabel lblNewLabel_6 ;

// 	public Login() {
// 		initialize();
// 		btnNewButton.addActionListener(this) ;
// 		btnNewButton_1.addActionListener(this) ;
// 	}

// 	private void initialize() {
// 		frame = new JFrame();
// 		frame.setVisible(true) ;
// 		frame.setBounds(100, 100, 800, 500);
// 		frame.setLocationRelativeTo(null);
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
// 		JPanel panel = new JPanel();
// 		panel.setBackground(new Color(255, 218, 185));
// 		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
// 		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
// 					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE).addGap(0))
// 		);
		
// 		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
// 				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
// 		);
		
// 		JLabel lblNewLabel = new JLabel("");
// 		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/public/images/login_page.jpg")));
		
// 		textField = new JTextField();
// 		textField.setColumns(10);
// 		frame.add(textField) ;
		
// 		JLabel lblNewLabel_1 = new JLabel("Username");
// 		lblNewLabel_1.setBackground(new Color(139, 0, 0));
// 		lblNewLabel_1.setForeground(new Color(165, 42, 42));
// 		lblNewLabel_1.setFont(new Font("Ravie", Font.BOLD, 12));
		
// 		JLabel lblNewLabel_2 = new JLabel("Password");
// 		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
// 		lblNewLabel_2.setForeground(new Color(139, 0, 0));
// 		lblNewLabel_2.setFont(new Font("Ravie", Font.BOLD, 12));
		
// 		textField_1 = new JPasswordField();
// 		textField_1.setColumns(10);
// 		frame.add(textField_1) ;
		
// 		JLabel lblNewLabel_3 = new JLabel("NEW USER ?");
// 		lblNewLabel_3.setForeground(new Color(139, 0, 0));
// 		lblNewLabel_3.setFont(new Font("Ravie", Font.BOLD, 14));
		
// 		btnNewButton = new JButton("Sign Up");
// 		btnNewButton.setBackground(new Color(139, 0, 0));
// 		btnNewButton.setForeground(new Color(255, 255, 255));
// 		btnNewButton.setFont(new Font("Ravie", Font.BOLD, 13));
// 		frame.add(btnNewButton) ;
		
// 		JLabel lblNewLabel_4 = new JLabel("");
// 		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/public/gifs/small_bulb.gif")));
		
// 		JLabel lblNewLabel_5 = new JLabel("");
// 		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/public/gifs/small_open_book.gif")));
		
// 		btnNewButton_1 = new JButton("Login");
// 		btnNewButton_1.setBackground(new Color(139, 0, 0));
// 		btnNewButton_1.setForeground(new Color(250, 250, 210));
// 		btnNewButton_1.setFont(new Font("Ravie", Font.BOLD, 12));
// 		frame.add(btnNewButton_1) ;
		
// 		lblNewLabel_6 = new JLabel();
// 		lblNewLabel_6.setForeground(Color.RED);
// 		lblNewLabel_6.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 12));
// 		GroupLayout gl_panel = new GroupLayout(panel);
// 		gl_panel.setHorizontalGroup(
// 			gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
// 					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 552, Short.MAX_VALUE).addGap(18)
// 					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
// 							.addGap(19).addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
// 							.addGap(18).addComponent(textField, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
// 							.addGap(4)).addGroup(gl_panel.createSequentialGroup()
// 							.addGap(19).addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
// 							.addGap(18).addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
// 							.addGap(4)).addGroup(gl_panel.createSequentialGroup()
// 							.addGap(19).addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
// 							.addPreferredGap(ComponentPlacement.RELATED)
// 							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
// 							.addGroup(gl_panel.createSequentialGroup().addGap(19)
// 							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
// 							.addGroup(gl_panel.createSequentialGroup().addGap(85)
// 							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
// 							.addGap(26)).addGroup(gl_panel.createSequentialGroup()
// 							.addPreferredGap(ComponentPlacement.RELATED)
// 							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
// 							.addGap(28).addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))).addGap(10))
// 		);
		
// 		gl_panel.setVerticalGroup(
// 			gl_panel.createParallelGroup(Alignment.LEADING)
// 				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
// 				.addGroup(gl_panel.createSequentialGroup().addGap(78)
// 				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
// 				.addGap(9).addComponent(lblNewLabel_1))
// 				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)).addGap(73)
// 				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
// 				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addComponent(lblNewLabel_2))
// 				.addGap(6).addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_1)
// 				.addGroup(gl_panel.createSequentialGroup().addGap(12)
// 				.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
// 				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_3)
// 				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
// 				.addGap(36).addComponent(btnNewButton).addGap(25)
// 				.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
// 				.addGroup(gl_panel.createSequentialGroup().addGap(69)
// 				.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))).addGap(34))
// 		);
		
// 		panel.setLayout(gl_panel);
// 		frame.getContentPane().setLayout(groupLayout);
// 	}
	
	
// 	public void actionPerformed(ActionEvent ae) {
// 		try {
// 			MongoDatabase database = CreateConnection.getDatabase();
// 			MongoCollection<Document> usersCollection = database.getCollection("users");
	
// 			if (ae.getSource() == btnNewButton_1) {
// 				String user = textField.getText();
// 				String password = String.valueOf(textField_1.getPassword());
// 				Document query = new Document("email", user).append("password", password);
// 				Document foundUser = usersCollection.find(query).first();
		
// 				if (foundUser != null) {
// 					lblNewLabel_6.setBounds(320, 340, 140, 40);
// 					lblNewLabel_6.setText("Success");
// 					Authenticate.setUser(foundUser.getObjectId("_id"));
// 					frame.setVisible(false);
// 					frame.dispose();
// 					Instruction instruction = new Instruction();
// 					instruction.getFrame().setVisible(true);
// 				} else {
// 					lblNewLabel_6.setBounds(250, 340, 400, 40);
// 					lblNewLabel_6.setText("Invalid input");
// 					lblNewLabel_6.revalidate();
// 					lblNewLabel_6.repaint();
// 				}
// 			}
// 		} catch (Exception e) {
// 			System.err.println("Error occured during login: " + e.getMessage());
// 		} finally {
// 			CreateConnection.closeConnection();
// 		}

// 		if (ae.getSource() == btnNewButton) {
// 			frame.setVisible(false);
// 			frame.dispose(); 
// 			SignUp signupFrame = new SignUp();
// 			signupFrame.getFrame().setVisible(true);
// 		}
// 	}
	
// 	public JFrame getFrame() {
// 		return frame ;
// 	}
// }



package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import db.CreateConnection;
import utils.SetImage;
import auth.Authenticate;

public class Login extends JPanel implements ActionListener {
    private JTextField textField;
    private JPasswordField textField_1;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JLabel lblMessage;
    
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Login(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        initialize();
        btnLogin.addActionListener(this);
        btnSignUp.addActionListener(this);
    }

    private void initialize() {
        setBackground(new Color(255, 218, 185));
        setLayout(null);

        JPanel lblBackground = new SetImage("/public/images/login_page.jpg", 0, 0, 400, getHeight());
        add(lblBackground);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                lblBackground.setBounds(0, 0, 700, getHeight());
                lblBackground.repaint();
            }
        });

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Ravie", Font.BOLD, 12));
        lblUsername.setForeground(new Color(165, 42, 42));
        lblUsername.setBounds(750, 100, 100, 30);
        add(lblUsername);

        textField = new JTextField();
        textField.setBounds(900, 100, 200, 30);
        add(textField);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Ravie", Font.BOLD, 12));
        lblPassword.setForeground(new Color(139, 0, 0));
        lblPassword.setBounds(750, 150, 100, 30);
        add(lblPassword);

        textField_1 = new JPasswordField();
        textField_1.setBounds(900, 150, 200, 30);
        add(textField_1);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Ravie", Font.BOLD, 12));
        btnLogin.setBackground(new Color(139, 0, 0));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBounds(900, 200, 100, 40);
        add(btnLogin);

        JLabel lblNewUser = new JLabel("NEW USER?");
        lblNewUser.setFont(new Font("Ravie", Font.BOLD, 14));
        lblNewUser.setForeground(new Color(139, 0, 0));
        lblNewUser.setBounds(900, 260, 150, 30);
        add(lblNewUser);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Ravie", Font.BOLD, 12));
        btnSignUp.setBackground(new Color(139, 0, 0));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBounds(900, 300, 100, 40);
        add(btnSignUp);
       
        ImageIcon bulbIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/small_bulb.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel bulb = new JLabel(bulbIcon);
        bulb.setBounds(1150, 20, 200, 200);
        add(bulb);
		
		ImageIcon bookIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/small_open_book.gif"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        JLabel book = new JLabel(bookIcon);
        book.setBounds(700, 200, 200, 200);
        add(book);

        ImageIcon thinkIcon = new ImageIcon(new ImageIcon(getClass().getResource("/public/gifs/think.gif"))
                .getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        JLabel think = new JLabel(thinkIcon);
        think.setBounds(900, 420, 250, 250);
        add(think);
		
        lblMessage = new JLabel();
        lblMessage.setForeground(Color.RED);
        lblMessage.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 12));
        lblMessage.setBounds(900, 350, 200, 40);
        add(lblMessage);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            MongoDatabase database = CreateConnection.getDatabase();
            MongoCollection<Document> usersCollection = database.getCollection("users");

            if (ae.getSource() == btnLogin) {
                String user = textField.getText();
                String password = String.valueOf(textField_1.getPassword());
                Document query = new Document("email", user).append("password", password);
                Document foundUser = usersCollection.find(query).first();

                if (foundUser != null) {
                    lblMessage.setText("Success");
                    Authenticate.setUser(foundUser.getObjectId("_id"));

                    mainPanel.revalidate();
                    mainPanel.repaint();
                    cardLayout.show(mainPanel, "instruction");
                } else {
                    lblMessage.setText("Invalid input");
                    lblMessage.revalidate();
                    lblMessage.repaint();
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred during login: " + e.getMessage());
        } finally {
            CreateConnection.closeConnection();
        }

        if (ae.getSource() == btnSignUp) {
            cardLayout.show(mainPanel, "signup");
        }
    }
}
