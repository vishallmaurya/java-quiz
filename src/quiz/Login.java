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

        JLabel lblUsername = new JLabel("Email");
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
        lblMessage.setBounds(900, 350, 400, 40);
        add(lblMessage);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
            MongoDatabase database = null;
            MongoCollection<Document> usersCollection = null;
            try {
                database = CreateConnection.getDatabase();
                usersCollection = database.getCollection("users");
                
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
                
            } catch (Exception e) {
                lblMessage.setText("Unexpected error occured!!" + e.getMessage());
                lblMessage.revalidate();
                lblMessage.repaint();
            } 
        }

        if (ae.getSource() == btnSignUp) {
            cardLayout.show(mainPanel, "signup");
        }
    }
}
