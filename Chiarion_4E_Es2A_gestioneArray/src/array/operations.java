package array;

public class operations {
    /* metodo che rimuove tutte le ricorrenze
     di un numero all'interno del vettore.
     Se l'operazione non è riuscita, ritorna null */
    private static int[] removeNum(int[] array, int numero) {
        int dimArray = 0;

        /* scorre tutti i valori e trova la
         * dimensione dell'array */
        for (int n : array) {
            if (n != numero)
                dimArray++;
        }

        /* controllo se viene trovato il numero da eliminare,
        altrimenti ritorna null */
        if (dimArray == array.length)
            return null;

        /* istanzio il nuovo array e
         dichiaro il suo indice */
        int[] nuovoArray = new int[dimArray];
        int indexNuovoArray = 0;

        /* copio i valori dell'array */
        for (int i = 0; i < array.length; i++)
            if (array[i] != numero)
                nuovoArray[indexNuovoArray++] = array[i];

        return nuovoArray; //ritorno l'array se non è stato trovato alcun errore
    }

    /* metodo che ritorna un vettore con gli indici
    ricorrenze relative ad un numero dato
     */
    private static int[] findNum(int[] array, int num) {
        int cont = 0; //dichiarazione contatore

        if (array != null) {
            /* conto quanti numeri sono presenti */
            for (int val : array)
                if (val == num)
                    cont++;
        }

        if (cont == 0) //controllo se ha trovato il numero
            return null;

        /* dichiaro l'array con il relativo indice */
        int[] arrayIndex = new int[cont];
        int indexArrayIndex = 0;

        /* copio gli indici del numero
         * all'interno dell'array */
        for (int i = 0; i < array.length && indexArrayIndex < arrayIndex.length; i++) {
            if (array[i] == num)
                arrayIndex[indexArrayIndex++] = i;
        }

        return arrayIndex; //ritorno l'array con gli indici del numero trovato se non ci sono errori
    }

    /* metodo che stampa a video
    il vettore e i suoi numeri
     */
    private static void stampaArray(int[] array) {
        for (int numero : array)
            System.out.print(numero + "\t");
        System.out.println();
    }
}
