import java.util.Scanner;

public class EvidencijaTemperatura {

    private double[] temperature;

    public EvidencijaTemperatura(double[] temperature) {
        this.temperature = temperature;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    // Metod za računanje prosječne temperature
    public double prosjecnaTemperatura(double[] niz) {
        double suma = 0;
        for (double t : niz) {
            suma += t;
        }
        return suma / niz.length;
    }

    // Metod za pronalaženje maksimalne temperature
    public double maksimalnaTemperatura(double[] niz) {
        double max = niz[0];
        for (int i = 1; i < niz.length; i++) {
            if (niz[i] > max) {
                max = niz[i];
            }
        }
        return max;
    }

    // Glavni program za testiranje
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temp = new double[5];

        // Unos temperatura
        System.out.println("Unesi 5 temperatura:");
        for (int i = 0; i < temp.length; i++) {
            System.out.print("Temperatura " + (i + 1) + ": ");
            temp[i] = sc.nextDouble();
        }

        // Kreiranje objekta klase
        EvidencijaTemperatura evidencija = new EvidencijaTemperatura(temp);

        // Ispis dužine i vrijednosti niza
        System.out.println("\nBroj unesenih temperatura: " + evidencija.getTemperature().length);
        System.out.println("Unesene temperature:");
        for (double t : evidencija.getTemperature()) {
            System.out.print(t + " ");
        }
        System.out.println();

        // Provjera postojanja unesene temperature
        System.out.print("\nUnesi temperaturu za provjeru: ");
        double trazena = sc.nextDouble();
        boolean postoji = false;

        for (double t : evidencija.getTemperature()) {
            if (t == trazena) {
                postoji = true;
                break;
            }
        }

        if (postoji) {
            System.out.println("Temperatura " + trazena + " postoji u nizu.");
        } else {
            System.out.println("Temperatura " + trazena + " se ne nalazi u nizu.");
        }

        // Uklanjanje pojave te temperature - novi niz
        int brojNovih = 0;
        for (double t : evidencija.getTemperature()) {
            if (t != trazena) brojNovih++;
        }

        double[] noviNiz = new double[brojNovih];
        int j = 0;
        for (double t : evidencija.getTemperature()) {
            if (t != trazena) {
                noviNiz[j] = t;
                j++;
            }
        }

        evidencija.setTemperature(noviNiz);

        // Prikaz ažuriranog niza
        System.out.println("\nAžurirani niz temperatura:");
        for (double t : evidencija.getTemperature()) {
            System.out.print(t + " ");
        }
        System.out.println();

        // Ispis prosječne i maksimalne temperature
        System.out.println("\nProsječna temperatura: " +
                evidencija.prosjecnaTemperatura(evidencija.getTemperature()));
        System.out.println("Maksimalna temperatura: " +
                evidencija.maksimalnaTemperatura(evidencija.getTemperature()));
        
        
        sc.close();
    }
}
