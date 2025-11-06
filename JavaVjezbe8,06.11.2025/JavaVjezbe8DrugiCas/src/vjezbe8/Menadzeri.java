package vjezbe8;

public class Menadzeri extends Zaposleni {
	
	private double fiksnaPlata = 1300;
	private boolean bonus;

	public Menadzeri(String ime, String prezime, double plataPoSatu, double ukupanBrojSatiPoNedelji, int iD,
			double fiksnaPlata) {
		super(ime, prezime, plataPoSatu, ukupanBrojSatiPoNedelji, iD);
		this.fiksnaPlata = fiksnaPlata;
	}

	public double getFiksnaPlata() {
		return fiksnaPlata;
	}

	public void setFiksnaPlata(double fiksnaPlata) {
		this.fiksnaPlata = fiksnaPlata;
	}
	
	public boolean isBonus() {
		return bonus;
	}
	
	@Override
	public double izracunajPlatu() {
		double plata = super.izracunajPlatu();
		if (bonus) {
			return plata += (1.5 * plata) + fiksnaPlata;
		}else
		return plata + fiksnaPlata;
	}

	@Override
	public String toString() {
		return String.format("Menadzer [ime=%s, prezime=%s, plataPoSatu=%.2f, ukupanBrojSati=%.2f, ID=%d, fiksnaPlata=%.2f]", 
				ime, prezime, plataPoSatu, ukupanBrojSatiPoNedelji, ID, fiksnaPlata);
	}
	
}
