
public class KompleksniTest {

	public static void main(String[] args) {
		KompleksniBroj z1 = new KompleksniBroj();
		z1.odstampaj();
		KompleksniBroj z2 = new KompleksniBroj(-3);
		z2.odstampaj();
		KompleksniBroj z3 = new KompleksniBroj(3, -4);
		z3.odstampaj();
		z3.postaviRealniDio(-10);
		z3.odstampaj();
		System.out.printf("Im{Z3} = %.2f", z3.dajImaginarniDio());
		System.out.printf("|Z3| = %.2f", z3.moduo());
		
	}
	
}













