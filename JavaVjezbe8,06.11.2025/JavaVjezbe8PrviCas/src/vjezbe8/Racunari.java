package vjezbe8;

public class Racunari extends EProizvodi{
	
	private String procesor;
	private int ramMemorija; //u GB
	public Racunari(String opisProizvoda, String sifraProizvoda, double uvoznaCijenaProizvoda, String procesor,
			int ramMemorija) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijenaProizvoda);
		this.procesor = procesor;
		this.ramMemorija = ramMemorija;
	}
	public String getProcesor() {
		return procesor;
	}
	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}
	public int getRamMemorija() {
		return ramMemorija;
	}
	public void setRamMemorija(int ramMemorija) {
		this.ramMemorija = ramMemorija;
	}
	
	 @Override
	    public double izracunajMaloprodajnuCijenu() {
	        double osnovna = super.izracunajMaloprodajnuCijenu();
	        return osnovna * 1.05; 
	    }
	
	 @Override
	    public String toString() {
	        return super.toString() + 
	               String.format(" | Procesor: %s | Memorija: %dGB | Maloprodajna cijena: %.2f", 
	                              procesor, ramMemorija, izracunajMaloprodajnuCijenu());
	    }
	
}
