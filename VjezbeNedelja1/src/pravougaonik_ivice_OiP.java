import java.util.Scanner;

public class pravougaonik_ivice_OiP {

	   static void main(String[] args) {
		   
	        Scanner sc = new Scanner(System.in);
	        
	        double a = sc.nextDouble();
	        double b = sc.nextDouble();

	        double 	P = a * b;
	        double O = 2 * (a + b);
	        
	        System.out.printf("Povrsina %.2f %nObim je: %.2f", P, O);
	    
	   
	        sc.close();
	   }
}
