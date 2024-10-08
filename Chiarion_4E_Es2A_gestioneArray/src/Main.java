public class Main {
    public static void main(String[] args) {
        /* dichiazione variabili */
        final int numDelete = 2;
        final int numIndex = 1;

        int[] array = {1, 2, 1, 3, 7, 1, 10};
        array = removeNum(array, numDelete);

        if (array == null)
            System.out.println("Il numero non è stato trovato");
        else
            stampaArray(array);

        int[] arrayIndex = findNum(array, numIndex);
        if (arrayIndex == null)
            System.out.println("Il numero non è presente all'interno dell'array ");
        else {
            System.out.println("Il numero è presente nelle posizioni:");
            stampaArray(arrayIndex);
        }

        if(checkFindNum(array, arrayIndex, numIndex))
            System.out.println("\nMetodo funzionante nella ricerca indici");
        else
            System.out.println("Errore nel metodo di ricerca indici");
    }

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

    /* metodo che controlla se il metodo findNum è corretto */
    private static boolean checkFindNum(int[] array, int[] arrayIndex, int numero){
        if(array!=null && arrayIndex!=null){
            for(int i=0;i<arrayIndex.length;i++)
                if(array[arrayIndex[i]]!=numero) //al primo numero sbagliato ritorna che il metodo non funziona
                    return false;
        }

        return true; //se arriva alla fine vuol dire che il metodo è riuscito
    }
}