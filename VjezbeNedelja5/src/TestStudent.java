
public class TestStudent {

	
	
	
	    public static void main(String[] args) {

	        System.out.println("=== Lista studenata i njihovi prosjeci ===\n");

	        for (Enumeracije_studenata s : Enumeracije_studenata.values()) {
	            System.out.printf("%-20s -> Prosjek: %.2f%n",
	                    s.getImePrezime(), s.prosjek());
	        }
	    }
	}

