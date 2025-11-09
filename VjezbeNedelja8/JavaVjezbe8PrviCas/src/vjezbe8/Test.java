package vjezbe8;

import java.util.*;

public class Test {
    private static Scanner unos = new Scanner(System.in);
    private static List<EProizvodi> proizvodi = new ArrayList<>();

    public static void main(String[] args) {
        int opcija;

        do {
            System.out.println("\n===== MENI =====");
            System.out.println("1. Unos uredjaja");
            System.out.println("2. Pregled svih uredjaja");
            System.out.println("3. Pregled uredjaja odredjenog tipa");
            System.out.println("0. Izlaz");
            System.out.print("Izaberite opciju: ");
            opcija = unos.nextInt();
            unos.nextLine(); 

            switch (opcija) {
                case 1 -> unosUredjaja();
                case 2 -> prikaziSve();
                case 3 -> prikaziPoTipu();
                case 0 -> System.out.println("Kraj programa.");
                default -> System.out.println("Nepoznata opcija!");
            }

        } while (opcija != 0);
    }

    // unosenje uredjaja
    private static void unosUredjaja() {
        System.out.print("Unesite sifru proizvoda (RA / TE / TV...): ");
        String sifra = unos.nextLine();

        System.out.print("Unesite opis proizvoda: ");
        String opis = unos.nextLine();

        System.out.print("Unesite uvoznu cijenu: ");
        double cijena = unos.nextDouble();
        unos.nextLine(); // potroši novi red

        if (sifra.startsWith("RA")) {
            System.out.print("Unesite procesor: ");
            String procesor = unos.nextLine();
            System.out.print("Unesite memoriju (GB): ");
            int memorija = unos.nextInt();
            unos.nextLine();

            proizvodi.add(new Racunari(opis, sifra, cijena, procesor, memorija));
            System.out.println("Računar uspješno unesen!");

        } else if (sifra.startsWith("TE")) {
            System.out.print("Unesite operativni sistem: ");
            String os = unos.nextLine();
            System.out.print("Unesite velicinu ekrana (inča): ");
            double ekran = unos.nextDouble();
            unos.nextLine();

            proizvodi.add(new Telefoni(opis, sifra, cijena, os, (int) ekran));
            System.out.println("Telefon uspješno unesen!");

        } else if (sifra.startsWith("TV")) {
            System.out.print("Unesite velicinu ekrana (inča): ");
            double ekran = unos.nextDouble();
            unos.nextLine();

            proizvodi.add(new TV(opis, sifra, cijena, (int) ekran));
            System.out.println("TV uspješno unesen!");

        } else {
            System.out.println("Nepoznata šifra! (Mora počinjati sa RA, TE ili TV)");
        }
    }

    
    // prikaz svih uredjaja
    private static void prikaziSve() {
        if (proizvodi.isEmpty()) {
            System.out.println("Nema unesenih uređaja!");
            return;
        }

        System.out.println("\n=== SVI UREĐAJI ===");
        for (EProizvodi p : proizvodi)
            System.out.println(p);
    }

    // prikaz po tipu uredjaja
    private static void prikaziPoTipu() {
        if (proizvodi.isEmpty()) {
            System.out.println("Nema unesenih uređaja!");
            return;
        }

        System.out.print("Unesite tip uređaja (RA / TE / TV): ");
        String tip = unos.nextLine().toUpperCase();

        System.out.println("\n=== UREĐAJI TIPA: " + tip + " ===");

        boolean nadjeno = false;
        for (EProizvodi p : proizvodi) {
            if (p.getSifraProizvoda().startsWith(tip)) {
                System.out.println(p);
                nadjeno = true;
            }
        }

        if (!nadjeno)
            System.out.println("Nema uređaja tog tipa.");
    }
}
