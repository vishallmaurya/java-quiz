
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class Check implements ActionListener {
	String question[] = new String[5] ;
	String answer[] = new String[5] ;
	JFrame frame ;
	JLabel ques ;
	JTextField ans ;
	JLabel corr ;
	JButton submit ;
	JButton next ;
	JButton quit ;
	int count = 0 ;
	
	Check() {
		frame = new JFrame("Question") ;
		submit = new JButton("Submit") ;
		next = new JButton("Next") ;
		quit = new JButton("Quit") ;
		ques = new JLabel("") ;
		corr = new JLabel("") ;
		ans = new JTextField(20) ;
		
		frame.setVisible(true) ;
		frame.setLayout(new FlowLayout()) ;
		frame.setSize(600,600) ;
		frame.setLocationRelativeTo(null);											//opens frame from the center of the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		question[0] = "In which year Mahatma Gandhi was first arrested during 'Satyagraha'" ;
		question[1] = "The famous ‘Jama-Masjid’ of Delhi was built by whom ?" ;
		question[2] = "Who is the first person of our country ?" ;
		question[3] = "I'm tall when I'm young and short when I'm old, Who am I ?" ;
		question[4] = "I follow you all the time and copy your every move, but you can’t touch me or catch me, Who am I?" ;
		answer[0] = "1908" ;
		answer[1] = "Shahjahan" ;
		answer[2] = "President" ;
		answer[3] = "Candle" ;
		answer[4] = "Shadow" ;
		
		frame.add(submit) ;
		frame.add(ques) ;
		frame.add(ans) ;
		frame.add(corr) ;
		frame.add(quit) ;

		ans.addActionListener(this) ;
		submit.addActionListener(this) ;
		quit.addActionListener(this) ;
		next.addActionListener(this) ;
		
		
		
		createQues() ;
	}
	
	public void createQues() {
		ques.setText(question[count]) ;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			frame.add(next) ;
			corr.setVisible(true) ;
			next.setVisible(true) ;
			quit.setVisible(true) ;
			
			if((ans.getText()).equalsIgnoreCase(answer[count])) {
				corr.setText("Correct answer") ;
			}else {
				corr.setText("Wrong answer " + answer[count]) ;
			}
		}
		if(ae.getSource() == next) {
			count++ ;
			
			corr.setVisible(false) ;
			next.setVisible(false) ;
			
			ans.setText(null) ;
			createQues() ;
		//	remove(quit) ;
		}
		if(ae.getSource() == quit) {
			System.exit(0) ;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Check() ;
			}
		}) ;
	}
} 




import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class Check extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count = 0, current = 0, x= 1,y=1,now=0;  
    int m[]=new int[10];      
    Check(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Quit");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Result")||e.getActionCommand().equals("Quit"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count); 
            JOptionPane.showMessageDialog(this,"Total Question= 10\nYou attempted= "+current+"\nCorrect Answer= "+count+"\nWrong Answer= "+(current-count));  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Which one among these is not a primitive datatype?");  
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which class is available to all the class automatically?");  
            jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which package is directly available to our class without importing it?");  
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which institute is best for java coaching?");  
            jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSS IT");jb[3].setText("jtek");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which one among these is not a keyword?");  
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: which one among these is not a function of Object class?");  
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");  
                        jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: which function is not present in Applet class?");  
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
            jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new Check("Online Test Of Java");  
    }  
}