package vjezbe8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Smjena {

	private LocalDate datum;
	private LocalTime pocetak;
	private LocalTime kraj;
	private String tipSmjene; // jutarnja, popodnevna, nocna
	private ArrayList<Zaposleni> zaposleniUSmjeni;

	public Smjena(LocalDate datum, LocalTime pocetak, LocalTime kraj, String tipSmjene) {
		this.datum = datum;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tipSmjene = tipSmjene;
		this.zaposleniUSmjeni = new ArrayList<>();
	}

	public void dodajZaposlenog(Zaposleni z) {
		zaposleniUSmjeni.add(z);
	}

	public double trajanjeUSatima() {
		return java.time.Duration.between(pocetak, kraj).toHours();
	}

	public ArrayList<Zaposleni> getZaposleniUSmjeni() {
		return zaposleniUSmjeni;
	}

	@Override
	public String toString() {
		return "Smjena: " + tipSmjene + " (" + datum + ") " + " trajanje: " + trajanjeUSatima() + "h";
	}
}
