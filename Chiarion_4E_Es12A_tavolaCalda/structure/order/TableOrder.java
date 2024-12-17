package order;

import java.util.ArrayList;

/**
 * Classe che gestisce gli ordini associati ad un tavolo
 */
public class TableOrder {
    /* ATTRIBUTI */
    protected ArrayList<SingleOrder> orderList;

    /* GETTER AND SETTER */
    /**
     * Ritorna la lista con gli ordini effettauti
     * @return lista con ordini effettuati
     */
    public ArrayList<SingleOrder> getOrderList() {
        return this.orderList;
    }

    /* ALTRI METODI */
    /**
     * Costruttore che richiede almeno
     * un ordinazione per poter iniziare a gestire
     * gli ordini da un tavolo
     * @param order primo ordine da aggiungere
     */
    public TableOrder(SingleOrder order){}

    /**
     * Metodo che aggiunge un ordine alla lista
     * @param order ordine da aggiungere
     */
    public void addOrder(SingleOrder order){
        /* l'ordine deve essere aggiunto senza evitare ripetizioni
        * (due ordini singoli con stessa pietanza e stesso prezzo) */
    }

    /**
     * Metodo che calcola il prezzo di tutte le pietanze consumate
     * @return prezzo totale delle pietanze consumate
     */
    public double calculateTotalPrice(){
        return 0;
    }

    /**
     * Metodo che restituisce il conto da pagare
     * con le stringhe formattate
     * @return array di stringhe con le pietanze consumate
     */
    public String[] getBill(){
        return null;
    }

    /**
     * Metodo che ritorna il formato stringa
     * con tutte le singole ordinazioni effettuate
     * @return stringa formattata con tutte le informazioni disponibili per il tavolo
     */
    @Override
    public String toString(){
        return "";
    }
}
