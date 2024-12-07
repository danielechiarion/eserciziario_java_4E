package room;

import order.*;

public class Table {
    private static int lastTableNumber; //memorizza l'ultimo numero assegnato ad un tavolo

    /* ATTRIBUTI */
    /**
     * Numero identificativo del libro
     */
    protected int tableNumber;
    /**
     * Numero di posti totali disponibili
     */
    protected int totalSeats;
    /**
     * Numero di posti occupati
     */
    protected int occupiedSeats;
    /**
     * Ordine del tavolo effettuato
     */
    protected TableOrder tableOrder;

    /* GETTER AND SETTER */
    /**
     * Ritorna l'identificativo
     * del tavolo
     * @return intero che rappresenta l'id del tavolo
     */
    public int getTableNumber() {
        return this.tableNumber;
    }

    /**
     * Ritorna il numero totale di
     * posti disponibili per quel tavolo
     * @return numero totale di posti
     */
    public int getTotalSeats() {
        return this.totalSeats;
    }

    /**
     * numero di posti occupati in quel tavolo
     * @return numero di posti occupati del tavolo
     */
    public int getOccupiedSeats() {
        return this.occupiedSeats;
    }

    /**
     * Ritorna gli ordini del tavolo effettuati
     * @return oggetto TableOrder con tutti gli ordini effettuati dal tavolo
     */
    public TableOrder getTableOrder() {
        return this.tableOrder;
    }

    /**
     * Imposta il numero di posti occupati dal tavolo
     * @param numSeats numero di posti da impostare
     * @throws Exception se il numero di posti inseriti non è disponibile
     */
    private void setOccupiedSeats(int numSeats)throws Exception{
        /* qui verranno effettuati controlli
        * se il numero di posti è effettivamente disponibile */
    }

    /* ALTRI METODI */
    /**
     * Metodo che si occupa creare un tavolo
     * con i dati necessari (numero del tavolo, posti totali, posti coperti)
     * @param tableNumber identificativo numerico del tavolo
     * @param totalSeats posti totali disponibili
     */
    public Table(int tableNumber, int totalSeats){
        this.tableNumber = tableNumber;
        this.totalSeats = totalSeats;
        this.occupiedSeats = 0;
    }
}
