import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;  
import java.io.*;
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JLabel msg;
	JRadioButton jb[] = new JRadioButton[5] ;
    JTextField ans ;
    JButton b1,b2;  
    ButtonGroup bg;  
    String FileName;
    boolean Computer_science[]=new boolean[100];
    boolean History[]=new boolean[100];
    boolean Mental_math[]=new boolean[100];
    boolean Culture[]=new boolean[100];
    boolean GK[]=new boolean[100];
    boolean Bollywood[]=new boolean[100];
    boolean Riddles[]=new boolean[100];
    boolean Science[]=new boolean[100];
    boolean visited_array[]=new boolean[100];
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];    
    int random_no[]=new int[10]; 
    String question_array[]=new String[10];
    String answer_array[]=new String[10];
    int start_index=0,end_index=0;
    int unattempted=0, correct=0,wrong=0;

    boolean repeated(int[] arr,int s,int e){
        for(int i=0;i<s;i++){
            if(arr[i]==e)
                return true;
        }
        return false;
    }
    boolean[] particular_array(String s){
        if(s.equals("Computer_Science"))
            return Computer_science;
        else if(s.equals("History"))
            return History;
        else if(s.equals("Mental_math"))
            return Mental_math; 
        else if(s.equals("Culture"))
            return Culture;
        else if(s.equals("GK"))
            return GK;
        else if(s.equals("Bollywood"))
            return Bollywood;
        else if(s.equals("Riddles"))
            return Riddles;
        else
            return Science;
    } 
    OnlineTest(String s)  
    {  
        super("Quiz"); 
    
		int li=s.length()-4,si=0;

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='.')
                li=i;
        }
        for(int i=li;i>=0;i--){
            if(s.charAt(i)=='/')
                si=i+1;
        }
        FileName=s.substring(si, li);
		System.out.println("s       " + s) ;
		System.out.println("FileName            " + FileName) ;
        visited_array=particular_array(s);
        l=new JLabel();  
        add(l);
        msg=new JLabel();
        add(msg);
        
        ans = new JTextField(50) ;
		add(ans);
        b1=new JButton("Next");  
        b2=new JButton("Quit");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);
        add(b2);  
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
        int nol=0;
        try{
            BufferedReader user_file = new BufferedReader(new FileReader (new File(s)));
            String line=user_file.readLine();
            while(line!=""){
                nol++;
                line=user_file.readLine();
            }
			System.out.println("number of line :    " + nol) ;
			
            for(int i=0;i<10;i++){
                int r;
                do{
                    r=(int)(Math.random()*(nol+1));  
                    if(!visited_array[r] && !repeated(random_no, i-1, r)){
                        random_no[i]=r;
                    }
                }while(visited_array[r]!=false);
                visited_array[r]=true;
            }
            for(int i=0;i<9;i++){
                for(int j=i+1;j<10;j++){
                    if(random_no[i]>random_no[j]){
                        int temp=random_no[i];
                        random_no[i]=random_no[j];
                        random_no[j]=temp;
                }
                }
            }
            user_file.close();
            user_file = new BufferedReader(new FileReader (new File(s)));
            int c=-1;
            int noq=0;
            line=user_file.readLine();
            while(line!=""){
                c++;
                if(c==random_no[noq]){
                    question_array[noq++]=line;
                }
                line=user_file.readLine();
            }
        }catch(FileNotFoundException e) {
				System.out.println ("Filename not found!");
			}catch(IOException ex){
				ex.printStackTrace();
			}
        for(int i=0;i<nol;i++)
            System.out.print(question_array[i]);
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1 && !e.getActionCommand().equals("Result"))  
        {  
            if(count==9)  
            { 
                b1.setText("Result");  
            }
            try{
                if(ans.getText().equalsIgnoreCase(answer_array[count])){
                    correct++;
                    msg.setVisible(true);
                    msg.setFont(new Font("Arial",Font.BOLD,15));
                    msg.setBounds(320,340,140,40);
                    msg.setText("Correct Answer\nClick Next to Continue.");
                }
                else{
                    wrong++;
                    msg.setVisible(true); 
                    msg.setFont(new Font("Arial",Font.BOLD,15));
                    msg.setBounds(250,340,400,40);
                    msg.setText("Oops! Wrong Answer\nThe correct answer was "+answer_array[count]+"\nClick Next to Continue.");
                }
            }catch(NullPointerException n){
                msg.setVisible(true);
                msg.setFont(new Font("Arial",Font.BOLD,15));
                msg.setBounds(250,340,470,40);
                msg.setText("You haven't answered the question.\nThe correct answer was "+answer_array[count]+"\nClick Next to Continue.");
            }
            count++;
            set();
        }  
      
        if(e.getActionCommand().equals("Result")||e.getActionCommand().equals("Quit"))  
        { 
            //System.out.println("correct ans="+count); 
            JOptionPane.showMessageDialog(this,"Total Question= 10\nYou attempted= "+(count-1)+"\nCorrect Answer= "+correct+"\nWrong Answer= "+(wrong));  
            System.exit(0);  
        } 
    }  
    void set()  
    {  
        for(int i=0;i<question_array[count].length();i++){
            if(question_array[count].charAt(i)=='.')
                start_index=i+1;
        }
        for(int i=question_array[count].length()-1;i>=0;i--){
            char c=question_array[count].charAt(i);
            if(c=='?'||c=='!'||c=='.'||c=='"')
                end_index=i+1;
        }
        answer_array[count]=question_array[count].substring(end_index);
        question_array[count]=question_array[count].substring(start_index,end_index);
        l.setText(question_array[count]);
        l.setBounds(30,40,450,20);
    }    
    public static void main(String ar[])  
    {  
        new OnlineTest("File_Name.txt");  
    }  
}  