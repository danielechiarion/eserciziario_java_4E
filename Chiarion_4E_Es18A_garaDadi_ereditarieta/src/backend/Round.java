package backend;

import java.util.Random;

public class Round {
    private Giocatore giocatore1;
    private Giocatore giocatore2;

    private int lancio1;
    private int lancio2;
    private String risultato;

    public Round(Giocatore giocatore1, Giocatore giocatore2){
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.lancio1 = 0;
        this.lancio2 = 0;
    }

    public String getRisultato() {
        return this.risultato;
    }

    /* metodo che lancia i dadi */
    public void lancioDadi(Dado dado){
        this.lancio1 = dado.lancia();
        this.lancio2 = dado.lancia();

        /* in base al valore ottenuto incremento
         * il numero di vittorie del giocatore e scrivo il suo nome
         * nella lista dei vincitori */
        if(this.lancio1>this.lancio2) {
            this.giocatore1.incrementaVittoria();
            this.risultato = this.giocatore1.getNome();
        }
        else if(this.lancio1<this.lancio2){
            this.risultato = this.giocatore2.getNome();
        }else{
            this.risultato = "PAREGGIO";
        }
    }

    /* metodo che fa il toString dei risultati e del vincitore
     * del round */
    public String toString(){
        return String.format("%s: %d\t-\t%s: %d >>> %s",
                this.giocatore1.getNome(), this.lancio1, this.giocatore2.getNome(), this.lancio2, this.risultato);
    }
}
