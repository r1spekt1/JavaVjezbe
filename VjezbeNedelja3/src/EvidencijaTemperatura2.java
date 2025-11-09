
	import java.util.Arrays;
	import java.util.Scanner;
	
public class EvidencijaTemperatura2 {

		 private double[] temperature;

		    // Konstruktor bez argumenata (pravimo niz od 5 temperatura)
		   public EvidencijaTemperatura2() {
		        this.temperature = new double[5];
		    }

		    // Konstruktor sa parametrima
		    public void EvidencijaTemperature(double[] temperature) {
		        this.temperature = temperature;
		    }

		    // Getter
		    public double[] getTemperature() {
		        return temperature;
		    }

		    // Setter
		    public void setTemperature(double[] temperature) {
		        this.temperature = temperature;
		    }

		    // Unos temperatura od korisnika
		    public void unosTemperatura() {
		        Scanner sc = new Scanner(System.in);
		        for (int i = 0; i < temperature.length; i++) {
		            System.out.print("Unesi temperaturu " + (i + 1) + ": ");
		            temperature[i] = sc.nextDouble();
		        }
		    }

		    // Ispis temperatura
		    public void prikaziTemperature() {
		        System.out.println("Unesene temperature: " + Arrays.toString(temperature));
		    }

		    // Prosječna temperatura
		    public double prosjecnaTemperatura(double[] niz) {
		        double suma = 0;
		        for (double t : niz) {
		            suma += t;
		        }
		        return suma / niz.length;
		    }

		    // Maksimalna temperatura
		    public double maksimalnaTemperatura(double[] niz) {
		        double max = niz[0];
		        for (double t : niz) {
		            if (t > max) {
		                max = t;
		            }
		        }
		        return max;
		    }

		    // Provjera i uklanjanje temperature iz niza (ako postoji)
		    public void ukloniTemperaturu(double vrijednost) {
		        // Brojimo koliko puta se vrijednost pojavljuje
		        int brojPonavljanja = 0;
		        for (double t : temperature) {
		            if (t == vrijednost) {
		                brojPonavljanja++;
		            }
		        }

		        // Ako se ne pojavljuje, ne moramo ništa raditi
		        if (brojPonavljanja == 0) {
		            System.out.println("Temperatura " + vrijednost + " nije pronađena u nizu.");
		            return;
		        }

		        // Novi niz bez tražene vrijednosti
		        double[] noviNiz = new double[temperature.length - brojPonavljanja];
		        int j = 0;
		        for (double t : temperature) {
		            if (t != vrijednost) {
		                noviNiz[j++] = t;
		            }
		        }

		        // Ažuriramo niz
		        temperature = noviNiz;
		        System.out.println("Temperatura " + vrijednost + " uklonjena iz niza.");
		    }

		    // Glavna metoda (main)
		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        EvidencijaTemperatura2 et = new EvidencijaTemperatura2();

		        // 1. Unos temperatura
		        et.unosTemperatura();

		        // 2. Ispis dužine i unesenih temperatura
		        System.out.println("\nDužina niza: " + et.getTemperature().length);
		        et.prikaziTemperature();

		        // 3. Unos temperature za provjeru i uklanjanje
		        System.out.print("\nUnesi temperaturu koju želiš provjeriti i eventualno ukloniti: ");
		        double trazena = sc.nextDouble();

		        // Provjera da li se nalazi u nizu
		        boolean postoji = false;
		        for (double t : et.getTemperature()) {
		            if (t == trazena) {
		                postoji = true;
		                break;
		            }
		        }

		        if (postoji) {
		            System.out.println("Temperatura " + trazena + " postoji u nizu.");
		            et.ukloniTemperaturu(trazena);
		        } else {
		            System.out.println("Temperatura " + trazena + " ne postoji u nizu.");
		        }

		        // 4. Prikaz ažuriranog niza
		        System.out.println("\nAžurirani niz temperatura: " + Arrays.toString(et.getTemperature()));

		        // 5. Ispis prosječne i maksimalne temperature
		        if (et.getTemperature().length > 0) {
		            double prosjek = et.prosjecnaTemperatura(et.getTemperature());
		            double maks = et.maksimalnaTemperatura(et.getTemperature());
		            System.out.printf("\nProsječna temperatura: %.2f °C\n", prosjek);
		            System.out.printf("Maksimalna temperatura: %.2f °C\n", maks);
		        } else {
		            System.out.println("Niz je prazan, nema vrijednosti za izračun.");
		        }
		        sc.close();
		    }
}
