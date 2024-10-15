package utility;

import mensola.*;

public class Array {
    public static Libro[] extendArray(Libro[] array) {
        if(array==null)
            return new Libro[1];

        Libro[] largeArray = new Libro[array.length + 1]; //dichiaro un nuovo array con una nuova dimensione

        /* copio i valori nel
         * secondo array */
        for (int i = 0; i < array.length; i++)
            largeArray[i] = array[i];

        return largeArray; //ritorno il nuovo array
    }

    public static void insertElementArray(Libro[] array, Libro element)throws ArrayIndexOutOfBoundsException{
        int effectiveDimension = actualDimensionArray(array);

        /* se l'array è pieno l'elemento non viene inserito */
        if(effectiveDimension == array.length){
            throw new ArrayIndexOutOfBoundsException("Mensola piena");
        }

        array[effectiveDimension] = element; //altrimenti viene inserito nella prima posizione disponibile
    }

    /* metodo che conta la dimensione effettiva di un array,
    * ovvero quante posizioni sono occupate */
    public static int actualDimensionArray(Libro[] array){
        int cont=0;

        while(cont<array.length && array[cont]!=null)
            cont++; //conta quanti posizioni sono occupate

        return cont; //ritorna il contatore
    }
}
