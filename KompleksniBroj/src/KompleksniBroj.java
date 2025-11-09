
public class KompleksniBroj {
	//Atributi klase
	
	private float realniDio;
	private float imaginarniDio;
	
	//konstruktori
	public KompleksniBroj() { 
		realniDio = 0;
		imaginarniDio = 0;
	}	
	
	public KompleksniBroj(float a, float b) {
		realniDio = a;
		imaginarniDio = b;
	}
	
	public KompleksniBroj(float a) {
		realniDio = a;
		imaginarniDio = 0;	
	}
	
	//geteri i seteri
	public float dajRealniDio() {
		return realniDio;
	}
	
	public float dajImaginarniDio() {
		return imaginarniDio;
	}
	
	public float postaviRealniDio(float a) {
		realniDio = a;
	    		return realniDio;
	}
	 
	public float postaviImaginarniDio(float b) {
		imaginarniDio = b;
		return imaginarniDio;
	}

	
	
	
	
	public void odstampaj() {
		if (imaginarniDio >= 0) 
			System.out.printf("%.2f + %.2fi\n", realniDio, imaginarniDio);
		 else 
			System.out.printf("%.2f - %.2fi\n", realniDio, -imaginarniDio);
		
	}

		
	//moduo
		
	public float moduo() {
		return (float) Math.sqrt(realniDio * realniDio + imaginarniDio * imaginarniDio);	
		
	}
	
	//sabiranje
	
	public KompleksniBroj saberi(KompleksniBroj a) {
		KompleksniBroj rez =  new KompleksniBroj();
		rez.realniDio = realniDio + a.realniDio ; 
		rez.imaginarniDio = imaginarniDio + a.imaginarniDio;
		return rez;
	}
	//oduzimanje
	public KompleksniBroj oduzmi(KompleksniBroj a) {
		KompleksniBroj rez =  new KompleksniBroj();
		rez.postaviRealniDio(dajRealniDio() - a.dajRealniDio());
		rez.postaviImaginarniDio(dajImaginarniDio() - a.dajImaginarniDio());
		return rez;
	
	}
	
	//mnozenje
	public KompleksniBroj mnozenje(KompleksniBroj a) {
		KompleksniBroj rezultat = new KompleksniBroj();
		rezultat.postaviImaginarniDio(realniDio * a.realniDio - imaginarniDio * a.imaginarniDio);
		rezultat.postaviImaginarniDio(imaginarniDio * a.realniDio + realniDio * a.imaginarniDio);
		return rezultat;
		
	}
	
	//djeljenje 
	public KompleksniBroj podijeli(kompleksniBroj a) {
		KompleksniBroj rezultat = new KompleksniBroj();
		rezultat.postaviRealniDio(dajRealni() * a.dajImaginarni() + dajImaginarni() * a.dajImaginarni() / a.modulBroja() * a.modulBroja()));
		rezultat.postaviImaginarniDio(dajImaginarni() * a.dajRealni() - dajImaginarni() * a.dajImaginarni() / a.modulBroja() * a.modulBroja()));
		return  rezultat;
	
	}
	
}
