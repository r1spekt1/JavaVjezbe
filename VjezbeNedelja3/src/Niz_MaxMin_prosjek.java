import java.util.Scanner;
	
public class Niz_MaxMin_prosjek {


	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Unesite velicinu niza: ");
	        int velicinaNiz = sc.nextInt();
	        int[] bodovi = new int[velicinaNiz];
	        
	        // Unos
	        for (int i = 0; i < bodovi.length; i++) {
	            System.out.println("Unesite " + (i + 1) + ". element niza: ");
	            bodovi[i] = sc.nextInt();
	        }

	        // prosjek
	        double prosjek = 0;
	        for (int x : bodovi) {
	            prosjek += x;
	        }
	        System.out.println("Prosjek je: " + (prosjek / bodovi.length));

	        // minimum
	        int min = 100;
	        for (int x : bodovi) {
	            if (x < min) {
	                min = x;
	            }
	        }
	        System.out.println("Minimum je: " + min);

	        // maksimum
	        int max = 0;
	        for (int x : bodovi) {
	            if (x > max) {
	                max = x;
	            }
	        }

	        // DODAJ SAMO OVU LINIJU da ispišeš i maksimum:
	        System.out.println("Maksimum je: " + max);

	        sc.close();
	    }
}
