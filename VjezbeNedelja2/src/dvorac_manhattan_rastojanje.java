import java.util.Scanner;

public class dvorac_manhattan_rastojanje {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt(); // broj katapulta
	long D = sc.nextLong(); // domet (Manhattan)
	long HD = sc.nextLong(); // health dvorca
	long KA = sc.nextLong(); // svaki katapult u dometu
	
	int threatCount = 0;
	
	for (int i = 0; i < N; i++) {
		long x = sc.nextLong();
		long y = sc.nextLong();
		long manhattan = Math.abs(x) + Math.abs(y);
		if (manhattan <= D) {
				threatCount++;
		}
	}
	
	long totalDamage = (long) threatCount * KA;
	
	System.out.println(threatCount);
		if (totalDamage >= HD) {
			System.out.println("Dvorac unisten");
		} 
		else {
			System.out.println("Dvorac nije unisten");
	}
		
	sc.close();
}
	
}
