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
       return null;
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
        return null;
    }
}
