import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
public class Start_F extends Canvas{
	JFrame jf;
	JButton bs;
	JButton bq;
	JLabel l;
	Start_F(){
		jf = new JFrame("Start and Quit");						//Title on frame
		bs = new JButton("Start Quiz");							//Caption on button 1
		bq = new JButton("Quit");							//Caption on button 2
		l = new JLabel("Quiz It Out!");							//quiz name
		JLabel l1 = new JLabel(new ImageIcon("try4.png"));				//making icon of quiz
		JLabel l2 = new JLabel(new ImageIcon("tryu.png"));
		JLabel l3 = new JLabel(new ImageIcon("try.png"));
		JLabel l4 = new JLabel(new ImageIcon("try3.png"));

		JLabel l5 = new JLabel(new ImageIcon("try4.png"));				//making icon of quiz
		JLabel l6 = new JLabel(new ImageIcon("tryu.png"));
		JLabel l7 = new JLabel(new ImageIcon("try.png"));
		JLabel l8 = new JLabel(new ImageIcon("try3.png"));
		bs.setBounds(430, 300, 200, 40);						//placing components on the frame
		bq.setBounds(830, 300, 100, 40);
		l.setBounds(430, 10, 460, 100);
		l1.setBounds(40, 20, 100, 100);
		l2.setBounds(40, 160, 100, 100);
		l3.setBounds(40, 320, 100, 100);
		l4.setBounds(40, 480, 100, 100);

		l5.setBounds(1200, 20, 100, 100);
		l6.setBounds(1200, 160, 100, 100);
		l7.setBounds(1200, 320, 100, 100);
		l8.setBounds(1200, 480, 100, 100);

		bs.setBackground(Color.green);							//background of button 1
		bq.setBackground(Color.red);							//background of button 2
		Font f = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 30);		//font formation
		bs.setFont(f);
		Font f2 = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 30);
		bq.setFont(f2);

		l.setFont(new Font("Times New Roman", Font.BOLD, 80));
		Border brdr1 = BorderFactory.createBevelBorder(1);				//creating borders of the quiz name
		l.setBorder(brdr1);
		l.setOpaque(true);							
		l.setBackground(Color.cyan);

		jf.add(l1);
		jf.add(l2);
		jf.add(l3);
		jf.add(l4);
		jf.add(l5);
		jf.add(l6);
		jf.add(l7);
		jf.add(l8);
		jf.add(bs);
		jf.add(bq);
		jf.add(l);
		jf.getContentPane().setBackground(Color.getHSBColor(200, 780, 800));		//generating background colour through HSB
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setSize(ss.width, ss.height);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);							//opens frame from the center of the window
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

		bs.addActionListener(new ActionListener() {					//if "Start quiz" is pressed a new frame will open to resume the quiz
			public void actionPerformed(ActionEvent ae) {
				new Login1() ;
			}
		}) ;
		
		bq.addActionListener(new ActionListener() {					//if "Quit" is pressed the frame will exit
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		}) ;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Start_F() ;
			}
		}) ;
	}
}