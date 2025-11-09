import java.util.Scanner;

public class kvadratna_jednacina {

	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	double a = sc.nextDouble(), b = sc.nextDouble();
	double c = sc.nextDouble();
	
	double d = b*b - 4*a*c;
	double x1 = (-b + Math.sqrt(d)) / (2*a);
	double x2 = (-b - Math.sqrt(d)) / (2*a);
	
	System.out.printf("x1 %.6f x2 %.6f%n", x1, x2);
	
	sc.close();
		
	}
}

	

