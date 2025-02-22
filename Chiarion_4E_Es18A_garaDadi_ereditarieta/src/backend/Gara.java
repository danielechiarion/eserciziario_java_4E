package backend;

import java.util.ArrayList;

public class Gara<T extends Giocatore> {
    private int numRound;
    protected Dado dado;
    protected ArrayList<Round> risultati;
    protected T giocatore1;
    protected T giocatore2;

    public Gara(int numRound, int numFacce, T giocatore1, T giocatore2){
        this.numRound = numRound;
        this.dado = new Dado(numFacce);
        this.risultati = new ArrayList<>();
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
    }

    public int getNumRound() {
        return numRound;
    }

    /* metodo che controlla se siamo arrivati
     * all'ultimo round della gara e se la partita è stata conclusa */
    public boolean fineGara(){
        return this.risultati.size() == numRound;
    }

    /* metodo che genera un round e riporta il possibile
     * vincitore, se c'è stato */
    public void round()throws Exception{
        if(this.fineGara())
            throw new Exception("Non è possibile proseguire oltre");
        /* creo un round e carico i risultati */
        this.risultati.add(new Round(this.giocatore1, this.giocatore2));
        this.risultati.getLast().lancioDadi(this.dado);
    }

    /* metodo che ritorna lo status della gara */
    public String statusGara()throws Exception{
        if(this.risultati.isEmpty())
            throw new Exception("Nessun round ancora avviato");
        if(!this.fineGara())
            return "GARA IN CORSO";
        else
            return "GARA TERMINATA";
    }

    /* metodo che ritorna l'ultimo vincitore del round */
    public String getRoundWinner(){
        return this.risultati.getLast().toString();
    }

    /* metodo che ritorna il nome del vincitore,
     * controllando che la partita sia finita.
     * In caso di partita in corso, lancia un'eccezione */
    public String gameWin()throws Exception{
        /* prima controllo se la gara
         * è stata conclusa */
        if(!this.fineGara())
            throw new Exception("Gara non terminata");

        /* in base ai risultati scelgo qual è il vincitore della gara */
        if(this.giocatore1.compareTo(giocatore2)>0)
            return this.giocatore1.toString();
        else if(this.giocatore1.compareTo(giocatore2)==0)
            return "PAREGGIO";
        else
            return this.giocatore2.toString();
    }

    /* metodo che resetta il gioco */
    public void resetGame(){
        /* per resettare il gioco è utile cancellare la lista dei risultati */
        this.risultati.clear();
        this.giocatore1.resetGiocate();
        this.giocatore2.resetGiocate();
    }
}
