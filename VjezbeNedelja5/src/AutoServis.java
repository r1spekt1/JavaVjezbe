import java.util.ArrayList;

public class AutoServis {

public static ArrayList <Auto>	neregistrovaniKojiSeMoguRegistrovati (ArrayList <Auto> listaAuta) {
		
		ArrayList <Auto> list = new ArrayList <Auto> ();
		
		for (Auto a : listaAuta) {
			if (a.mozeSeRegistrovati() && !a.isRegistrovan()) {
				list.add(a);
			}
		}
		return list;
	}
	
	public static double ukupnaRegistracija (ArrayList <Auto> listaAuta) {
		double suma = 0.0;
		
		for (Auto a : listaAuta) {
			suma += a.cijenaRegistracije();
		}
		return suma;
	}





}
