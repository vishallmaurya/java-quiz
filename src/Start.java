import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Start extends Canvas{
	JFrame jf;
	JButton bs;
	JButton bq;
	JLabel l;
	Start(){
		jf = new JFrame("Start and Quit");						//Title on frame
		bs = new JButton("Start Quiz");							//Caption on button 1
		bq = new JButton("Quit");								//Caption on button 2
		l = new JLabel("Quiz It Out!");							//quiz name
		ImageIcon icon = new ImageIcon("quiz.jpg");				//quiz logo
		JLabel Ilabel = new JLabel(icon);						//making icon a label

		bs.setBounds(100, 300, 100, 40);						//placing components on the frame
		bq.setBounds(300, 300, 100, 40);
		l.setBounds(170, 10, 170, 40);
		Ilabel.setBounds(100, 50, 300, 300);
		
		bs.setBackground(Color.green);											//background of button 1
		bq.setBackground(Color.red);											//background of button 2
		Font f = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 15);		//font formation
		bs.setFont(f);
		Font f2 = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 15);
		bq.setFont(f2);

		l.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Border brdr1 = BorderFactory.createBevelBorder(1);						//creating borders of the quiz name
		l.setBorder(brdr1);
		l.setOpaque(true);							
		l.setBackground(Color.cyan);

		jf.add(Ilabel);
		jf.add(bs);
		jf.add(bq);
		jf.add(l);
		jf.getContentPane().setBackground(Color.getHSBColor(200, 780, 800));	//generating background colour through HSB

		jf.setSize(500, 500);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);											//opens frame from the center of the window
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		
		bs.addActionListener(new ActionListener() {		//if "Start quiz" is pressed a new frame will open to resume the quiz
			public void actionPerformed(ActionEvent ae) {
				jf.setVisible(false);
				new Window2();
			}
		}) ;
		
		bq.addActionListener(new ActionListener() {								//if "Quit" is pressed the frame will exit
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		}) ;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Start() ;
			}
		}) ;
	}
	
}
