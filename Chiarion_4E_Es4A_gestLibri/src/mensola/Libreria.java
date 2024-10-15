package mensola;

import static utility.Array.*;

public class Libreria {
    /* metodo che ricerca un libro cercando quelli già esistenti */
    public static int searchBook(Libro[] array, String autore, String titolo){
        Libro libroInserito = new Libro();
        libroInserito.autore = autore;
        libroInserito.titolo = titolo;
        for(int i=0;i<array.length && array[i]!=null;i++)
            if(array[i].equals(libroInserito))
                return i;

        return -1;
    }

    public static void rimuoviLibro(Libro[] array, int posizione){
        int lunghezzaArray = actualDimensionArray(array);
        for(int i=posizione;i<lunghezzaArray-1;i++)
            array[i]=array[i+1];

        array[lunghezzaArray-1]=null;
    }

    public static void visualizzaLibroAutore(Libro[] array, String autore){
        System.out.println("LIBRI DI "+autore+":");
        for(int i=0;i<actualDimensionArray(array);i++){
            if(array[i].autore.equals(autore))
                System.out.println(array[i].toString());
        }
    }
}
