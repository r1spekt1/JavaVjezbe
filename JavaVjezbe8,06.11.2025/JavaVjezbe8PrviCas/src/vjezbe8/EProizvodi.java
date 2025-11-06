package vjezbe8;

public class EProizvodi {
	
	private String opisProizvoda, sifraProizvoda;
	private double uvoznaCijenaProizvoda;
	public EProizvodi(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda) {
		super();
		this.opisProizvoda = opisProizvoda;
		this.sifraProizvoda = sifraProizvoda;
		this.uvoznaCijenaProizvoda = uvoznaCijenaProizvoda;
	}
	public String getOpisProizvoda() {
		return opisProizvoda;
	}
	public void setOpisProizvoda(String opisProizvoda) {
		this.opisProizvoda = opisProizvoda;
	}
	
	public String getSifraProizvoda() {
		return sifraProizvoda;
	}
	
	public void setSifraProizvoda(String sifraProizvoda) {
		this.sifraProizvoda = sifraProizvoda;
	}
	
	public double getUvoznaCijenaProizvoda() {
		return uvoznaCijenaProizvoda;
	}
	
	public void setUvoznaCijenaProizvoda(double uvoznaCijenaProizvoda) {
		this.uvoznaCijenaProizvoda = uvoznaCijenaProizvoda;
	}
	
	public double izracunajMaloprodajnuCijenu() {
        return uvoznaCijenaProizvoda * 1.05;
    }
	
	@Override
	public String toString() {
		return String.format("Opis: %s | Sifra: %s | Uvozna cijena: %.2f", opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
    }
}

