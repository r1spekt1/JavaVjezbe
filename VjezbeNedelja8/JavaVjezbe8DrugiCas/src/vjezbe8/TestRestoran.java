package vjezbe8;

public class TestRestoran {

	public static void main(String[] args) {

		Restoran r = new Restoran("Kod Pavleta", "Bulevar Sv. Petra Cetinjskog 22", "PIB987654");

		Konobari k1 = new Konobari("Marko", "Milic", 6.5, 40, 1, true);
		Kuvari ku1 = new Kuvari("Petar", "Ivanovic", 8.0, 38, 2, 1500);
		Menadzeri m1 = new Menadzeri("Lazar", "Vukovic", 9.0, 36, 3, 1300);
		Zaposleni z1 = new Zaposleni("Nikola", "Jovanovic", 5.0, 30, 4);
		Konobari k2 = new Konobari("Milan", "Ristic", 6.0, 35, 5, false);

		m1.setPlataPoSatu(9.0);
		m1.setUkupanBrojSatiPoNedelji(36);

		r.dodajZaposlenog(k1);
		r.dodajZaposlenog(ku1);
		r.dodajZaposlenog(m1);
		r.dodajZaposlenog(z1);
		r.dodajZaposlenog(k2);

		r.obracunPlata(10, 2025);
	}
}
