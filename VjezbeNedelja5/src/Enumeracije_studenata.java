
public enum Enumeracije_studenata {
	
	//Konstante
    PETAR_PETROVIC("Petar Petrovic",8, 9, 10),
    MILICA_MILIC("Petar Petrovic",9, 9, 8),
    IVAN_IVANOVIC("Petar Petrovic",10, 10, 9),
    JOVANA_JOVANOVIC("Petar Petrovic",7, 8, 8),
    MARIO_MARKOVIC("Petar Petrovic",6, 7, 8);

    //Atributi
    private final int ocjena1;
    private final int ocjena2;
    private final int ocjena3;
    private final String imePrezime;

    //Konstruktor
    Enumeracije_studenata(String imePrezime, int ocjena1, int ocjena2, int ocjena3){
        this.ocjena1 = ocjena1;
        this.ocjena2 = ocjena2;
        this.ocjena3 = ocjena3;
        this.imePrezime = imePrezime;
    }
    public double prosjek() {
        return(ocjena1 + ocjena2 + ocjena3) / 3.0;
    }

    public String getImePrezime(){
        return imePrezime;
    }
	

}
