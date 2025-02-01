import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class Project {
	Project() {
		new Start_frame() ;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Project() ;
			}
		}) ;
	}
}