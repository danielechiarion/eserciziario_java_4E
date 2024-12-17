package room;

import order.SingleOrder;

import java.util.ArrayList;
public class Waiter {
    /**
     * Lista con gli id degli ordini
     */
    protected ArrayList<SingleOrder> orderList;

    /* GETTER AND SETTER */
    /**
     * Metodo che ritorna la lista con gli id
     * delle singole ordinazioni effettuate
     * @return lista con gli id delle ordinazioni effettuate
     */
    public ArrayList<SingleOrder> getOrderList(){
        return this.orderList;
    }

    /**
     * Metodo che ottiene l'ordine a partire
     * dal suo numero
     * @param numOrder ottiene l'ordine a partire dal suo numero
     * @throws Exception se non viene trovato l'ordine
     * @return new numOrder
     */
    public SingleOrder getSingleOrder(int numOrder)throws Exception{
        return null;
    }

    /**
     * Metodo che aggiunge l'ordinazione
     * alla lista del cameriere
     * @param order ordinazione da inserire
     */
    public void addOrder(SingleOrder order){}
    /**
     * Metodo che rimuove l'ordinazione dalla lista
     * del cameriere, in quanto risulta consegnata
     * @param order ordinazione da rimuovere
     */
    public void removeOrder(SingleOrder order){}

    /**
     * Metodo che ritorna la lista di
     * ordini archiviati dal cameriere
     * @return
     */
    @Override
    public String toString(){return "";}
}
