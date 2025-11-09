public class Televizor_klasa {

    private int brojKanala;
    private String nazivKanala;
    private int jacinaTona;

    // Konstruktor
    public Televizor_klasa(int brojKanala, String nazivKanala, int jacinaTona) {
        if (brojKanala >= 1)
            this.brojKanala = brojKanala;
        else
            this.brojKanala = 1;

        this.nazivKanala = nazivKanala;

        if (jacinaTona >= 0 && jacinaTona <= 10)
            this.jacinaTona = jacinaTona;
        else
            this.jacinaTona = 5; // podrazumijevana vrijednost
    }

    // Getteri
    public int getBrojKanala() {
        return brojKanala;
    }

    public String getNazivKanala() {
        return nazivKanala;
    }

    public int getJacinaTona() {
        return jacinaTona;
    }

    // Setteri
    public void setBrojKanala(int brojKanala) {
        if (brojKanala >= 1)
            this.brojKanala = brojKanala;
        else
            System.out.println("Broj kanala mora biti ≥ 1.");
    }

    public void setNazivKanala(String nazivKanala) {
        this.nazivKanala = nazivKanala;
    }

    public void setJacinaTona(int jacinaTona) {
        if (jacinaTona >= 0 && jacinaTona <= 10)
            this.jacinaTona = jacinaTona;
        else
            System.out.println("Jačina tona mora biti između 0 i 10.");
    }

    // Metod za pojačavanje tona
    public void pojacajTon() {
        if (jacinaTona < 10)
            jacinaTona++;
        else
            System.out.println("Ton je već na maksimumu (10).");
    }

    // Ispis
    public void ispisi() {
        System.out.println("Kanal " + brojKanala + ": " + nazivKanala + ", ton: " + jacinaTona);
    }

    // Test
    public static void main(String[] args) {
        Televizor_klasa tv = new Televizor_klasa(1, "RTCG", 5);
        tv.ispisi();
        tv.pojacajTon();
        tv.ispisi();
        tv.setBrojKanala(2);
        tv.setNazivKanala("National Geographic");

        tv.setJacinaTona(11); // pogrešan unos
        tv.ispisi();
    }
}
