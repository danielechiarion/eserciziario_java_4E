package order;

/**
 * Enumeratore che contiene le tipologie di cibo
 * e benvande ordinate
 */
public enum FoodType {
    bevanda,
    primo,
    secondo,
    dolce,
    contorno;

    /**
     * metodo che converte i valori
     * dell'enumeratore in un array di stringhe
     * @return array di stringhe con i valori dell'enumeratore
     * secondo l'ordine indicato
     */
    public static String[] toArrayString(){
        /* creo gli array per il convertire
        * gli enumeratori in stringhe */
        FoodType[] foodTypeArray = FoodType.values();
        String[] output = new String[foodTypeArray.length];

        for(int i=0;i<foodTypeArray.length;i++)
            output[i] = foodTypeArray[i].name();

        return output;
    }

    /**
     * metodo che,
     * in base alla posizione scelta,
     * ritorna l'enumeratore corrispondente
     * @param num indice da cui ottenere un valore dell'enumeratore
     * @return valore dell'enumeratore corrispondente
     * @throws ArrayIndexOutOfBoundsException se viene inserita un indice errato
     */
    public static FoodType getFoodType(int num)throws ArrayIndexOutOfBoundsException{
        /* genero l'array all'interno del quale ricercare l'elemento */
        FoodType[] foodTypeArray = FoodType.values();

        /* controllo se il numero inserito è valido */
        if(num<0 || num>=foodTypeArray.length)
            throw new ArrayIndexOutOfBoundsException("Indice inserito non valido");

        /* altrimenti ritorno il valore */
        return foodTypeArray[num];
     }
}