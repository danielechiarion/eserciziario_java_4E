import static frontScreen.FrontEnd.*;
import static utility.Tools.*;

import mensola.*;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int MAX_LIBRI = 2;
        final String[] elenco = {
                "Libreria",
                "Inserisci Libro",
                "Visualizza tutti i libri inseriti",
                "Modifica pagine libro",
                "Cancella libro",
                "Visualizza libri di un autore",
                "Visualizza libri con lo stesso titolo",
                "Esci"
        };
        Libro[] scaffale = new Libro[MAX_LIBRI];
        int nLibri = 0;
        boolean fine = true, spazio;

        do {
            switch (Menu(elenco, keyboard)) {
                case 1:

                    try {
                        controllaSpazio(nLibri, MAX_LIBRI);
                        Libro momentaneo = LeggiLibro(keyboard, nLibri, scaffale);
                        int doppione = indexOf(momentaneo, scaffale, nLibri);
                        if (doppione != -1) {
                            throw new Exception("Il libro è già presente");
                        } else {
                            scaffale[nLibri] = momentaneo;
                            nLibri++;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    break;

                case 2:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizza(scaffale, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                /*case 3:
                    try {
                        modificaNumPagine(nLibri, keyboard, scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        cancellaLibro(nLibri, keyboard, scaffale);
                        nLibri--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        visualizzaPerAutore(scaffale, keyboard, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;*/
                case 3:
                    fine = false;
                    break;
                case 6:
                    try{
                        Libro libroInput = inputDatiRicerca(3, keyboard);
                        Libro[] risultati = findAll(scaffale, libroInput);
                        visualizza(risultati, risultati.length);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        } while (fine);
    }

    /*private static void visualizzaPerAutore(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {
        controllaSeVuoto(nLibri);

        System.out.println("Inserisci il nome dell'autore: ");
        String autore = keyboard.nextLine();
        boolean trovato = false;

        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].autore.equals(autore)) {
                System.out.println(scaffale[i].toString());
                trovato = true;
            }
        }

        if (!trovato) {
            throw new Exception("Non è stato trovato nessun'autore con quel nome");
        }
    }

    private static void cancellaLibro(int nLibri, Scanner keyboard, Libro[] scaffale) throws Exception {
        controllaSeVuoto(nLibri);

        System.out.println("Inserire il titolo del libro che si vuole cancellare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale, nLibri);

        scaffale[pos] = null;
        compatta(scaffale, pos, nLibri);
        scaffale[nLibri - 1] = null;
    }

    private static void compatta(Libro[] scaffale, int pos, int nLibri) {
        for (int i = pos; i < nLibri - 1; i++) {
            scaffale[i] = scaffale[i + 1];
        }
    }

    private static void modificaNumPagine(int nLibri, Scanner keyboard, Libro[] scaffale) throws Exception {
        controllaSeVuoto(nLibri);

        System.out.println("Inserire il titolo del libro che si vuole modificare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale, nLibri);

        System.out.println("Inserisci il nuovo numero di pagine:\n(vecchio numero: " + scaffale[pos].numeroPagine + ")");
        int nPagine = Integer.parseInt(keyboard.nextLine());

        if (nPagine < 0) {
            throw new Exception("Non puoi inserire un numero negativo di pagine");
        } else {
            scaffale[pos].numeroPagine = nPagine;
        }
    }
     */

    private static int cercaLibro(String titolo, Libro[] scaffale, int nLibri) throws Exception {
        controllaSeVuoto(nLibri);
        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].titolo.equals(titolo))
                return i;
        }
        throw new Exception("Libro non trovato");
    }

    private static int indexOf(Libro book, Libro[] scaffale, int nLibri) {
        for (int i = 0; i < nLibri; i++) {
            if ((scaffale[i].autore.equals(book.autore)) && (scaffale[i].titolo.equals(book.titolo)))
                return i;
        }
        return -1;
    }

    private static boolean controllaSpazio(int nLibri, int maxLibri) throws Exception {
        if (nLibri < maxLibri)
            return true;
        else
            throw new Exception("Scaffale pieno");
    }

    // Metodo che verifica se esiste già un libro con lo stesso autore e titolo
    private static boolean verificaDuplicato(String autore, String titolo, int nLibri, Libro[] scaffale) throws Exception {
        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].autore.equals(autore) && scaffale[i].titolo.equals(titolo)) {
                throw new Exception("Trovato Doppione\n");  // Trovato duplicato (autore e titolo già presenti)
            }
        }
        return false;  // Nessun duplicato trovato
    }

    public static Libro[] findAll(Libro[] array, Libro libroInput)throws Exception{
        /* conta quante corrispondenze trovate */
        int cont=0;
        for(int i=0;i<array.length && array[i]!=null;i++){
            if(array[i].titolo.equals(libroInput.titolo))
                cont++;
        }

        if(cont==0)
            throw new Exception("Nessun libro trovato");

        /* dichiaro un nuovo array e
         * inserisco tutti i libri da restituire */
        Libro[] libriTrovati = new Libro[cont];
        int indexLibriTrovati = 0;
        for(int i=0;i<array.length && array[i]!=null;i++){
            if(array[i].titolo.equals(libroInput.titolo))
                libriTrovati[indexLibriTrovati++]=array[i];
        }

        return libriTrovati;
    }

    public static Libro inputDatiRicerca(int metodoRicerca, Scanner scanner){
        Libro libro = new Libro();

        if(metodoRicerca==2 || metodoRicerca==1){
            System.out.println("Inserisci autore:");
            libro.autore = scanner.nextLine();
        }
        if(metodoRicerca==3 || metodoRicerca==1){
            System.out.println("Inserisci titolo:");
            libro.titolo = scanner.nextLine();
        }

        return libro;
    }
}
