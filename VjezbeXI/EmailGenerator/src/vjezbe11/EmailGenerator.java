package vjezbe11;

import javax.swing.JOptionPane;

public class EmailGenerator {
    public static void main(String[] args) {
        // Unos podataka
        String ime = JOptionPane.showInputDialog(null, 
            "Unesite vaše ime:", 
            "Unos podataka", 
            JOptionPane.QUESTION_MESSAGE);
        
        String prezime = JOptionPane.showInputDialog(null, 
            "Unesite vaše prezime:", 
            "Unos podataka", 
            JOptionPane.QUESTION_MESSAGE);
        
        String godinaString = JOptionPane.showInputDialog(null, 
            "Unesite godinu rođenja:", 
            "Unos podataka", 
            JOptionPane.QUESTION_MESSAGE);
        
        // Provjera da li je korisnik otkazao unos
        if (ime == null || prezime == null || godinaString == null) {
            JOptionPane.showMessageDialog(null, 
                "Unos je otkazan!", 
                "Otkazano", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Generisanje email adrese
        String email = ime.toLowerCase() + "." + 
                       prezime.toLowerCase() + "." + 
                       godinaString + "@kompanija.me";
        
        // Pregled podataka i prikaz email adrese
        String poruka = "===== PREGLED PODATAKA =====\n\n" +
                       "Ime: " + ime + "\n" +
                       "Prezime: " + prezime + "\n" +
                       "Godina rođenja: " + godinaString + "\n\n" +
                       "Generisana email adresa:\n" + email;
        
        JOptionPane.showMessageDialog(null, 
            poruka, 
            "Rezultat", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
