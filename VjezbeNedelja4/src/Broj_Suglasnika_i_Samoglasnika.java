
public class Broj_Suglasnika_i_Samoglasnika {
	
public static void main(String[] args) {
		
		String rijec = "Programiranje";
		
		int brojSamoglasnika = 0;
		int brojSuglasnika = 0;
		
		rijec = rijec.toLowerCase();
		  String samoglasnici = "aeiou";
		
		for(int i = 0; i < rijec.length(); i++) {
			char slovo = rijec.charAt(i);
			
			/*
			if(slovo >= 'a' && slovo <= 'z') {
				if(slovo == 'a' || slovo == 'e' || slovo == 'i' || slovo == 'o' || slovo == 'u') {
					brojSamoglasnika++;
				} else {
					brojSuglasnika++;
				}
			*/
			
			 if (Character.isLetter(slovo)) { // provjera da li je slovo
	                if (samoglasnici.contains(String.valueOf(slovo))) {
	                    brojSamoglasnika++;
	                } else {
	                    brojSuglasnika++;
	                }
			
			}
			
		}
		
		System.out.println("Broj samoglasnika: " + brojSamoglasnika);
		System.out.println("Broj suglasnika: " + brojSuglasnika);
	}
	
}
