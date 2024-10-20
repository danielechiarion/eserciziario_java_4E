package mensola;

import static utility.Array.*;

public class Libreria {
    /* metodo che ricerca un libro cercando quelli già esistenti */
    public static int searchBook(Libro[] array, Libro libroInserito) {
        for (int i = 0; i < array.length && array[i] != null; i++)
            if (array[i].equals(libroInserito))
                return i;

        return -1;
    }

    public static void rimuoviLibro(Libro[] array, int posizione) {
        int lunghezzaArray = actualDimensionArray(array);
        for (int i = posizione; i < lunghezzaArray - 1; i++)
            array[i] = array[i + 1];

        array[lunghezzaArray - 1] = null;
    }

    public static void visualizzaLibroAutore(Libro[] array, String autore) {
        System.out.println("LIBRI DI " + autore + ":");
        for (int i = 0; i < actualDimensionArray(array); i++) {
            if (array[i].autore.equals(autore))
                System.out.println(array[i].toString());
        }
    }

    public static boolean mensolaVuota(Libro array[]) throws Exception {
        if (actualDimensionArray(array) == 0)
            throw new Exception("Mensola vuota");

        return false;
    }

    /* conta le corrispondenze trovate all'interno di un
    * array */
    public static int contaRisultati(Libro[] array, Libro libroInput){
        /* conta quante corrispondenze trovate */
        int cont = 0;
        for (int i = 0; i < actualDimensionArray(array); i++) {
            if (array[i].titolo.equals(libroInput.titolo))
                cont++;
        }

        return cont;
    }

    public static Libro[] findAll(Libro[] array, Libro libroInput) throws Exception {
        int cont = contaRisultati(array, libroInput);
        if (cont == 0)
            throw new Exception("Nessun libro trovato");

        /* dichiaro un nuovo array e
         * inserisco tutti i libri da restituire */
        Libro[] libriTrovati = new Libro[cont];
        int indexLibriTrovati = 0;
        for (int i = 0; i < actualDimensionArray(array); i++) {
            if (array[i].titolo.equals(libroInput.titolo))
                libriTrovati[indexLibriTrovati++] = array[i];
        }

        return libriTrovati;
    }

    public static int[] findPositions(Libro[] array, Libro libroInput){
        int cont = contaRisultati(array, libroInput);

        /* se non trova corrispondenze ritorna null */
        if(cont==0)
            return null;

        /* creo l'array e scorro tutti i valori
        * trovando le posizioni corrispondenti */
        int[] posTrovate = new int[cont];
        int indexPosTrovate = 0;

        for(int i=0;i<actualDimensionArray(array);i++){
            if(array[i].autore.equals(libroInput.autore))
                posTrovate[indexPosTrovate++] = i;
        }

        return posTrovate; //ritorna infine l'array
    }
}
