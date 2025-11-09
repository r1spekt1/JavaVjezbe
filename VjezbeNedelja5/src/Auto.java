
public class Auto {


	private String markaAuta;
    private int godisteAuta;
    private int snagaMotora;
    private boolean prodato;
    private int kubikazaMotora;
    private boolean registrovan;
    private static int brojProdatih = 0;

    public Auto(String markaAuta, int godisteAuta, int snagaMotora, boolean prodato, int kubikazaMotora, boolean registrovan) {
        this.markaAuta = markaAuta;
        this.godisteAuta = godisteAuta;
        this.snagaMotora = snagaMotora;
        this.prodato = prodato;
        this.kubikazaMotora = kubikazaMotora;
        this.registrovan = godisteAuta < 1985 ? false : registrovan;
        if (prodato) brojProdatih++;
    }

    public String getMarkaAuta() {
        return markaAuta;
    }

    public int getGodisteAuta() {
        return godisteAuta;
    }

    public int getSnagaMotora() {
        return snagaMotora;
    }

    public boolean isProdato() {
        return prodato;
    }

    public int getKubikazaMotora() {
        return kubikazaMotora;
    }

    public boolean isRegistrovan() {
        return registrovan;
    }

    public void setMarkaAuta(String markaAuta) {
        this.markaAuta = markaAuta;
    }

    public void setGodisteAuta(int godisteAuta) {
        this.godisteAuta = godisteAuta;
        if (godisteAuta < 1985) {
            this.registrovan = false;
        }
    }

    public void setSnagaMotora(int snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public void setProdato(boolean prodato) {
        if (this.prodato != prodato && prodato) brojProdatih++;
        this.prodato = prodato;
    }

    public void setKubikazaMotora(int kubikazaMotora) {
        this.kubikazaMotora = kubikazaMotora;
    }

    public void setRegistrovan(boolean registrovan) {
        if (this.godisteAuta > 1985) {
            this.registrovan = registrovan;
        } else {
            this.registrovan = false;
        }
    }

    public static int getBrojProdatih() {
        return brojProdatih;
    }

    public boolean mozeSeRegistrovati() {
        return this.godisteAuta >= 1985;
    }

    public double cijenaRegistracije() {
        if (!mozeSeRegistrovati()) {
            return 0.0;
        }
        // Example formula using koeficijentZaGodiste and kubikaza
        return kubikazaMotora * 0.1 * koeficijentZaGodiste(godisteAuta);
    }

    @Override
    public String toString() {
        return String.format(
            "Auto [markaAuta=%s, godisteAuta=%d, snagaMotora=%d, prodato=%b, kubikazaMotora=%d, registrovan=%b, cijenaRegistracije=%.2f]",
            markaAuta, godisteAuta, snagaMotora, prodato, kubikazaMotora, registrovan, cijenaRegistracije()
        );
    }

    public static double koeficijentZaGodiste(int godiste) {
        if (godiste < 1985) {
            return 0.0;
        } else if (godiste <= 2000) {
            return 3.0;
        } else if (godiste <= 2010) {
            return 2.0;
        } else {
            return 1.5;
        }
    }
}
