import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class Bubbles extends JPanel{
  
    private Ellipse2D.Float[] ellipses;
    private double esize[];
    private float estroke[];
    private final double MAX_SIZE=40;
   
    public Bubbles() {
        ellipses = new Ellipse2D.Float[5];
        esize    = new double[ellipses.length];
        estroke  = new  float[ellipses.length];
        for (int i = 0; i < ellipses.length; i++) {
            ellipses[i] = new Ellipse2D.Float();
            getRandomXY(i, 20 * Math.random(),getWidth()-60,getHeight()-60);
        }
    }
    public void build(){
        while(true){
           for (int i = 0; i < ellipses.length; i++) {
            estroke[i] += 0.025f; //increasing stroke
            esize[i]++; //increasing size
            if (esize[i] > MAX_SIZE) //new values if reaches maximum
                getRandomXY(i, 20 * Math.random(),getWidth()-60,getHeight()-60);
            else
                ellipses[i].setFrame(ellipses[i].getX(), ellipses[i].getY(),
                                     esize[i], esize[i]);
           }
           repaint(); //repainting
            try {
               Thread.sleep(50); //sleeping
             }catch (Exception ex) {}
        }
    }
    public void getRandomXY(int i, double size, int w, int h) {
        esize[i] = size;
        estroke[i] = 1.0f; //setting size.strokes,coordinates
        double x = Math.random() * (getWidth()-(MAX_SIZE/2));
        double y = Math.random() * (getHeight()-(MAX_SIZE/2));
        ellipses[i].setFrame(x, y, size, size); //setting ellipse
    }
   
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        //clearing previous trails
        g2d.setColor(Color.black);
        g2d.fillRect(0,0,this.getWidth(),this.getHeight());
        for (int i = 0; i < ellipses.length; i++) {              
               g2d.setStroke(new BasicStroke(estroke[i]));
               int red=(int)(Math.random()*256);
               int green=(int)(Math.random()*256);
               int blue=(int)(Math.random()*256);
               g2d.setColor(new Color(red,green,blue));
               g2d.draw(ellipses[i]); //drawing ellipses
        }
    }
    public static void main(String[] args) {
        JFrame f=new JFrame("Bubbles");
        Bubbles b=new Bubbles();
        f.getContentPane().add(b);
        f.setSize(350,350);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        b.build();
    }
}