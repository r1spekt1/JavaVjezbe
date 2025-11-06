package vjezbe8;

public class Zaposleni {
	protected String ime, prezime;
	protected double plataPoSatu, ukupanBrojSatiPoNedelji;
	protected int ID;

	public Zaposleni(String ime, String prezime, double plataPoSatu, double ukupanBrojSatiPoNedelji, int iD) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.plataPoSatu = plataPoSatu;
		this.ukupanBrojSatiPoNedelji = ukupanBrojSatiPoNedelji;
		ID = iD;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public double getPlataPoSatu() {
		return plataPoSatu;
	}

	public void setPlataPoSatu(double plataPoSatu) {
		this.plataPoSatu = plataPoSatu;
	}

	public double getUkupanBrojSatiPoNedelji() {
		return ukupanBrojSatiPoNedelji;
	}

	public void setUkupanBrojSatiPoNedelji(double ukupanBrojSatiPoNedelji) {
		this.ukupanBrojSatiPoNedelji = ukupanBrojSatiPoNedelji;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public double izracunajPlatu() {
		return 4 * (plataPoSatu * ukupanBrojSatiPoNedelji);
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d | Ime: %s | Prezime: %s | Plata po satu: %.2f | Ukupan broj sati: %.2f", ID, ime, prezime, plataPoSatu, ukupanBrojSatiPoNedelji);
	}
	
	
}
