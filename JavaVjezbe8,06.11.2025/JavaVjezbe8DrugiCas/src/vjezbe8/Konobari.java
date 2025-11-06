package vjezbe8;

public class Konobari extends Zaposleni{
		private boolean prekovremeniRad;

		
		
		public Konobari(String ime, String prezime, double plataPoSatu, double ukupanBrojSatiPoNedelji, int iD,
				boolean prekovremeniRad) {
			super(ime, prezime, plataPoSatu, ukupanBrojSatiPoNedelji, iD);
			this.prekovremeniRad = prekovremeniRad;
		}

		public boolean isPrekovremeniRad() {
			return prekovremeniRad;
		}
		
		public void setPrekovremeniRad(boolean prekovremeniRad) {
			this.prekovremeniRad = prekovremeniRad;
		}
		
		@Override
		public double izracunajPlatu() {
			double plata = super.izracunajPlatu();
			if (prekovremeniRad) {
				plata += 1.2 * plata;
			}
			return plata;
		}
		
		@Override
		public String toString() {
			return String.format("Konobar [ime=%s, prezime=%s, plataPoSatu=%.2f, ukupanBrojSati=%.2f, ID=%d, prekovremeniRad=%b]", 
					ime, prezime, plataPoSatu, ukupanBrojSatiPoNedelji, ID, prekovremeniRad);
		}
}
