package vjezbe8;

public class ObracunPlate {

	private int mjesec;
	private int godina;
	private Zaposleni zaposleni;
	private double iznos;
	private String napomena;

	public ObracunPlate(int mjesec, int godina, Zaposleni zaposleni, double iznos, String napomena) {
		this.mjesec = mjesec;
		this.godina = godina;
		this.zaposleni = zaposleni;
		this.iznos = iznos;
		this.napomena = napomena;
	}

	@Override
	public String toString() {
		return mjesec + "/" + godina + " - " + zaposleni.getIme() + " " + zaposleni.getPrezime() +
				" (" + zaposleni.getClass().getSimpleName() + ") " + " | Plata: " + iznos + "€ | " + napomena;
	}
}
