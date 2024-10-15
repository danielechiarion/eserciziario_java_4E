package mensola;

public class Libreria {
    /* metodo che ricerca un libro cercando quelli già esistenti */
    public static int searchBook(Libro[] array, String autore, String titolo){
        for(int i=0;i<array.length && array[i]!=null;i++)
            if(array[i].autore.equals(autore) && array[i].titolo.equals(titolo))
                return i;

        return -1;
    }
}
