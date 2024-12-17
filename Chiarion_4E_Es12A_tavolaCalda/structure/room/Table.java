package room;

import order.*;

import org.json.JSONObject;
import java.util.Comparator;

public class Table {
    private static int lastTableNumber; //memorizza l'ultimo numero assegnato ad un tavolo
    /**
     * Comparatore per i tavoli,
     * utilizzato nelle liste per l'ordinamento
     */
    public static Comparator<Table> tableComparator;

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
    public void setOccupiedSeats(int numSeats)throws Exception{
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

    /**
     * Metodo che calcola il numero del tavolo aggiornando un contatore
     * già inserito
     * @return
     */
    public static int calculateTableNumber(){
        return 0;
    }
}

    /**
     * Metodo che si occupa di aggiungere ordini al tavolo,
     * verificando che questo sia il primo o sia uno successivo
     * @param singleOrder oggetto ordine da inserire alla lista
     */
    public void addOrder(SingleOrder singleOrder){
        /* questo metodo controlla se l'ordine del
        * tavolo è stato creato,
        * altrimenti istanzia nuovamente l'ordine del tavolo */
    }

    /**
     * Metodo che libera un tavolo cancellando tutti i dati associati,
     * come gli ordini e i posti occupati
     */
    public void freeTable(){
        /* i dati da cancellare sono gli ordini al tavolo
        * e il numero di persone che occupano il tavolo */
    }

    /**
     * Metodo che indica se il tavolo è attualmente occupato o meno
     * @return TRUE se il tavolo è libero, FALSE se il tavolo è impegnato
     */
    public boolean isTableFree(){
        return false;
    }

    /**
     * Metodo che controlla se il tavolo ha un numero di posti
     * necessari per inserire un determinato numero di persone,
     * quindi se il numero massimo di posti è maggiore o uguale
     * delle persone da inserire
     * @param numberofPeople numero di persone da inserire nel tavolo
     * @return TRUE se il tavolo è adatto, FALSE se non è adatto
     */
    public boolean isTableBigEnough(int numberofPeople){
        return false;


    /**
     * Metodo che restituisce le informazioni relative al tavolo
     * scelto
     * @return formato stringa con le indicazioni del tavolo
     */
    @Override
    public String toString(){
        /* i dati da inserire dovrebbero essere:
        * - NUMERO TAVOLO
        * - NUMERO POSTI DISPONIBILI
        * - POSTI ATTUALMENTE OCCUPATI
        * - EVENTUALI ORDINAZIONI EFFETTUATI */
        return "";
    }

    /**
     * Override del metodo equals che controlla
     * se due tavoli sono uguali
     * in base al loro numero
     * @param object oggetto della classe Object da confrontare
     * @return TRUE se i due tavoli corrispondono, FALSE altrimenti
     */
    @Override
    public boolean equals(Object object){
        return false;
    }

    /**
     * Metodo che compara tra di loro i tavoli
     * in base al loro numero
     * @param anotherTable tavolo da confrontare
     * @return 0 se il numero dei tavoli corrisponde,
     * -1 se il numero tavolo viene prima di quello di anotherTable,
     * 1 se il numero tavolo di anotherTable viene prima di quello di questo tavolo
     */
    public int compare(Table anotherTable){
        return 0;
    }

    /**
     * Metodo che converte i dati del Tavolo in un oggetto
     * JSON per il salvataggio su file
     * @return JSONObject con le principali informazioni relative al tavolo
     */
    public JSONObject toJSON(){
        /* i dati da salvare nel JSON sono:
        * - numero del tavolo
        * - posti disponibili */
        return null;
    }

    /**
     * Metodo che converte quanto letto da file JSON
     * in un oggetto della classe Tavolo
     * @param object oggetto letto da file JSON
     * @return oggetto convertito nella classe Tavolo
     */
    public static Table parseJSON(JSONObject object){
        return null;
    }
}
