package vjezbe8;

public class Telefoni extends EProizvodi{
	
	private String operativniSistem;
	private int velicinaEkrana; //u inchi
	
	public Telefoni(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda,
			String operativniSistem, int velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
		this.operativniSistem = operativniSistem;
		this.velicinaEkrana = velicinaEkrana;
	
	}
	
	public String getOperativniSistem() {
		return operativniSistem;
	}
	
	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;
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
        if (velicinaEkrana > 6)
            osnovna *= 1.03; // +3% ako je ekran > 6
        return osnovna;
    }
	
	@Override
    public String toString() {
        return super.toString() + 
               String.format(" | OS: %s | Ekran: %.1f\" | Maloprodajna cijena: %.2f", 
                              operativniSistem, velicinaEkrana, izracunajMaloprodajnuCijenu());
    }
}