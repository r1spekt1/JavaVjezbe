import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
   		
	   	Scanner sc = new Scanner(System.in);

		System.out.println("Unesi rijec: ");	
	   		
		String rijec = sc.nextLine().trim();
		
		String y = new StringBuilder(rijec).reverse().toString();
		
		
		
		System.out.println(rijec.equalsIgnoreCase(y) ? "Rijec je palindrom" : "Rijec nije palindrom");
		
		/*
   		rijec = rijec.toLowerCase();
   		String obrnutaRijec = "";
   		
   		for(int i = rijec.length() - 1; i >= 0; i--) {
   			obrnutaRijec += rijec.charAt(i);
   		}
   		
   		if(rijec.equals(obrnutaRijec)) {
   			System.out.println("Rijec je palindrom");
   		} else {
   			System.out.println("Rijec nije palindrom");
   		*/
		   		sc.close();
   	}
}
