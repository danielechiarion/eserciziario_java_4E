package order;

/**
 * Classe che gestisce una singola ordinazione
 * di un tavolo
 */
public class SingleOrder {
    /**
     * Variabile che memorizza l'ultimo ID dato ad un'ordinazione
     */
    protected static int lastOrderID;

    /* ATTRIBUTI */
    /**
     * ID dell'ordinazione
     */
    protected int id;
    /**
     * Tipo di ordinazione
     */
    protected FoodType foodType;
    /**
     * Prezzo per la singola pietanza/bevanda
     * scelta
     */
    protected double price;
    /**
     * Quantità della pietanza richiesta
     */
    protected int quantity;

    /**
     * numero del tavolo da cui è stata effettuata l'ordinazione
     */
    protected int tableNumber;

    /* GETTER E SETTER */
    /**
     * Ritorna l'id della singola ordinazione
     * @return id dell'ordinazione (intero)
     */
    public int getId() {
        return this.id;
    }
    /**
     * Ritorna la pietanza / bevanda scelta
     * @return valore dell'enumeratore della pietanza o della bevanda
     */
    public FoodType getFoodType() {
        return this.foodType;
    }
    /**
     * Ritorna il prezzo della singola pietanza/bibita scelta
     * @return prezzo della singola pietanza/bibita
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * Ritorna il numero di pietanze/bibite ordinate
     * @return intero con il numero di pietanze ordinate
     */
    public int getQuantity() {
        return this.quantity;
    }
    /**
     * Imposta un nuovo tipo di cibo per l'ordinazione effettyata
     * @param foodType tipologia di cibo (enumeratore) che si sostiuisce a quella corrente
     */
    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
    /**
     * Imposta un nuovo prezzo della singola pietanza/bibita
     * @param price nuovo prezzo (double) che si sostituisce a quello già inserito
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Imposta una nuova quantità di pietanze/bevande ordinate
     * @param quantity quantità di pietanze/bevande (int) che si sostiusce alla quantità già inserita
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Ritorno il numero del tavolo dal quale
     * è stata effettuata la singola ordinazione
     * @return
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /* ALTRI METODI */
    /**
     * Costruttore del singolo ordine di una pietanza
     * @param id identificativo numerico della singola ordinazione
     * @param foodType tipo di pietanza/bevanda scelta
     * @param price prezzo della pietanza/bevanda scelta
     * @param quantity quantità della pietanza/bevanda scelta
     * @param tableNumber numero del tavolo dal quale è stata effettuata la prenotazione
     */
    public SingleOrder(int id, FoodType foodType, double price, int quantity, int tableNumber) {
        /* quando la prenotazione viene creata
        * il booleano served viene impostato automaticamente a false */
    }

    /**
     * Metodo che calcola l'id da assegnare
     * alla singola ordinazione
     * @return id della singola ordinazione
     */
    public static int calculateID(){
        /* è importante aggiornare
        * la variabile statica del lastID */
        return 0;
    }

    /**
     * Metodo che calcola il conto da pagare per l'ordinazione,
     * considerando se tale ordinazione è stata poi servita o meno
     * @return prezzo della singola ordinazione
     */
    public double calculatePrice(){
        /* controllo se la pietanza è stata servita */
        return 0;
    }

    /**
     * Metodo che confronta se due ordinazioni
     * sono simili in base al tipo di pietanza scelto
     * e al suo prezzo
     * @param order ordinazione da confrontare
     * @return TRUE se le ordinazioni sono simili, FALSE se non lo sono
     */
    public boolean isSimilar(SingleOrder order){
        return false;
    }

    /**
     * Metodo che ritorna il formato stringa
     * per l'output di una singola ordinazione
     * @return formato stringa dell'ordinazione
     */
    @Override
    public String toString(){
        return "";
    }

    /**
     * Metodo che controlla se due singole
     * prenotazioni sono uguali in base al
     * loro ID
     * @param object di cui verificare il confronto
     * @return TRUE se le due ordinazioni hanno lo stesso ID, FALSE altrimenti
     */
    @Override
    public boolean equals(Object object){
        return false;
    }
}
