import java.util.Scanner;

public class Broj_rijeci {
	
 	public static void main(String[] args) {
 		
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesi recenicu");
		String line = sc.nextLine();
		line = line.trim();
		
		String[] djelovi = line.split("\\s+");
		
		String[] rijeci = line.trim().split("\\s+");
		int brojRijeci = line.trim().isEmpty() ? 0 : rijeci.length;
		
		System.out.println(rijeci.length);
		sc.close();
	}
}
