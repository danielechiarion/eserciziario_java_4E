import personale.*;
import plesso.*;

public class Main {
    public static void main(String[] args) {
        Dipendente dipendente = new Dipendente("Denis", 'F', "Via delle vacche 2, Ceneselli", "barbone");
        //System.out.println(dipendente.toString());
        Docente docente = new Docente("Laghi", 'X', "Via sociale", "sistemi");
        //System.out.println(docente.toString());
        Impiegato impiegato = new Impiegato("Bego", 'F', "Via spello", "Contabilità");
        //System.out.println(impiegato.toString());

        /* posso assegnare ad una classe primitiva una classe derivata
        * Non posso mai fare il contrario */
        Dipendente dipendente2 = new Docente("Giovanna", 'F', "Via sociale", "sistemi");
        //System.out.println(dipendente2.toString());
        //System.out.println(docente.upperIndirizzo());

        Istituto istituto = new Istituto("Viola Marchesini");
        istituto.addDipendente(dipendente);
        istituto.addDipendente(dipendente2);
        istituto.addDipendente(docente);
        istituto.addDipendente(impiegato);
        istituto.stampaDipendenti();

        
    }
}
