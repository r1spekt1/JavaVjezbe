package vjezbe8;

public class Kuvari extends Zaposleni {
	
	private double fiksnaPlata = 1500;

	public Kuvari(String ime, String prezime, double plataPoSatu, double ukupanBrojSatiPoNedelji, int iD,
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
	
	@Override
	public double izracunajPlatu() {
		double plata = super.izracunajPlatu();
		return fiksnaPlata + plata;
	}
	
	
	@Override
	public String toString() {
		return String.format("Kuvar [ime=%s, prezime=%s, plataPoSatu=%.2f, ukupanBrojSati=%.2f, ID=%d, fiksnaPlata=%.2f]", 
				ime, prezime, plataPoSatu, ukupanBrojSatiPoNedelji, ID, fiksnaPlata);
	}
}
