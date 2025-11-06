package vjezbe8;

public class TV extends EProizvodi{
	
	private int velicinaEkrana; // inchi

	public TV(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda, int velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
		this.velicinaEkrana = velicinaEkrana;
	}
	
	public int getVelicinaEkrana() {
		return velicinaEkrana;
	}
	
	public void setVelicinaEkrana(int velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}
	
	 @Override
	    public double izracunajMaloprodajnuCijenu() {
	        double osnovna = super.izracunajMaloprodajnuCijenu();
	        if (velicinaEkrana > 65)
	            osnovna *= 1.10; // +10% ako je ekran > 65 inča
	        return osnovna;
	    }
	
	 @Override
	    public String toString() {
	        return super.toString() + 
	               String.format(" | Ekran: %.1f\" | Maloprodajna cijena: %.2f", 
	                              velicinaEkrana, izracunajMaloprodajnuCijenu());
	    }
}
