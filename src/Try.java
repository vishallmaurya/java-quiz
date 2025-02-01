import java.util.Scanner ;

public class Try {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in) ;
		String str = sc.nextLine() ;
		
		if(str.equals("\n"))
			System.out.println("new line") ;
		else
			System.out.println(str) ;
	} 
}