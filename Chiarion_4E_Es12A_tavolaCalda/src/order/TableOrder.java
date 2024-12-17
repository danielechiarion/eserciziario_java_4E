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
    public TableOrder(SingleOrder order){
        this.orderList = new ArrayList<>();
        this.orderList.add(order);
    }

    /**
     * Metodo che aggiunge un ordine alla lista
     * @param order ordine da aggiungere
     */
    public void addOrder(SingleOrder order){
        /* l'ordine deve essere aggiunto senza evitare ripetizioni
         * (due ordini singoli con stessa pietanza e stesso prezzo).
         * Provo a vedere se abbiamo quindi una ordinazione simile
         * e cambio la quantità */
        for(SingleOrder currentOrder : this.orderList){
            if(order.isSimilar(currentOrder)){
                currentOrder.setQuantity(currentOrder.getQuantity()+order.getQuantity());
                return;
            }
        }

        /* altrimenti aggiungo normalmente */
        this.orderList.add(order);
    }

    /**
     * Metodo che calcola il prezzo di tutte le pietanze consumate
     * @return prezzo totale delle pietanze consumate
     */
    public double calculateTotalPrice(){
       double totalPrice = 0;

       for(SingleOrder currentOrder : this.orderList)
           totalPrice += currentOrder.calculatePrice();

       return totalPrice;
    }

    /**
     * Metodo che restituisce il conto da pagare
     * con le stringhe formattate
     * @param restaurantName nome del ristorante
     * @return array di stringhe con le pietanze consumate
     */
    public String[] getBill(String restaurantName){
        String[] bill = new String[this.orderList.size()+3];
        bill[0] = restaurantName;
        bill[1] = "*** CONTO ***";
        for(int i=0;i<this.orderList.size();i++)
            bill[i+2] = this.orderList.toString();
        bill[bill.length-1] = String.format(">>> TOTALE: %.2f€", this.calculateTotalPrice());
        return bill;
    }

    /**
     * Metodo che ritorna il formato stringa
     * con tutte le singole ordinazioni effettuate
     * @return stringa formattata con tutte le informazioni disponibili per il tavolo
     */
    @Override
    public String toString(){
        if(this.orderList.isEmpty())
            return "Nessuna pietanza ordinata";

        String output = "";

        for(int i=0;i<this.orderList.size();i++)
            output += this.orderList.toString()+"\n";
        return "";
    }
}
