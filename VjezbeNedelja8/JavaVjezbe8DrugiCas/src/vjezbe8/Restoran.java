package vjezbe8;

import java.util.ArrayList;

public class Restoran {

	private String naziv;
	private String adresa;
	private String PIB;
	private ArrayList<Zaposleni> listaZaposlenih;

	public Restoran(String naziv, String adresa, String PIB) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.PIB = PIB;
		this.listaZaposlenih = new ArrayList<>();
	}

	public void dodajZaposlenog(Zaposleni z) {
		listaZaposlenih.add(z);
	}

	public void ukloniZaposlenog(int id) {
		for (int i = 0; i < listaZaposlenih.size(); i++) {
			if (listaZaposlenih.get(i).getID() == id) {
				listaZaposlenih.remove(i);
				break;
			}
		}
	}

	public Zaposleni pretragaPoID(int id) {
		for (Zaposleni z : listaZaposlenih) {
			if (z.getID() == id)
				return z;
		}
		return null;
	}

	public void obracunPlata(int mjesec, int godina) {
		System.out.println("\n*** Obracun plata za mjesec " + mjesec + "/" + godina + " ***\n");
		System.out.printf("%-4s %-10s %-12s %-12s %-10s %-10s %-15s %-10s%n",
				"ID", "Ime", "Prezime", "Tip", "Satnica", "Sati", "Dodatno", "Plata (€)");

		for (Zaposleni z : listaZaposlenih) {
			double plata = z.izracunajPlatu();
			String tip = z.getClass().getSimpleName();
			String dodatno = "-";

			if (z instanceof Konobari) {
				Konobari k = (Konobari) z;
				if (k.isPrekovremeniRad()) dodatno = "Prekovremeni";
			}
			else if (z instanceof Menadzeri) {
				Menadzeri m = (Menadzeri) z;
				if (m.isBonus()) dodatno = "Bonus";
			}
			else if (z instanceof Kuvari) {
				Kuvari kv = (Kuvari) z;
				dodatno = "Fiksna " + kv.getFiksnaPlata();
			}

			System.out.printf("%-4d %-10s %-12s %-12s %-10.2f %-10.2f %-15s %-10.2f%n",
					z.getID(), z.getIme(), z.getPrezime(), tip,
					z.getPlataPoSatu(), z.getUkupanBrojSatiPoNedelji(),
					dodatno, plata);
		}

		System.out.printf("Ukupan trosak: %.2f EUR%n", ukupniTrosakPlata());
	}

	public double ukupniTrosakPlata() {
		double ukupno = 0;
		for (Zaposleni z : listaZaposlenih) {
			ukupno += z.izracunajPlatu();
		}
		return ukupno;
	}
}
