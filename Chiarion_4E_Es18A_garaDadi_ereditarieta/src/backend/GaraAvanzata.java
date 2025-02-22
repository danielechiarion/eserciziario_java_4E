package backend;

public class GaraAvanzata extends Gara<GiocatoreAvanzato>{
    private int ultimoPuntoDato;
    private static final int numMinRound = 10;

    public GaraAvanzata(int numRound, int numFacce, GiocatoreAvanzato giocatore1, GiocatoreAvanzato giocatore2) throws Exception{
        super(numRound, numFacce, giocatore1, giocatore2);
        if(numRound < numMinRound)
            throw new Exception("Il numero minimo di round deve essere 10");

        this.ultimoPuntoDato = -1;
    }

    @Override
    public void round()throws Exception{
        if(super.fineGara())
            throw new Exception("Non è possibile proseguire oltre");

        this.risultati.add(new Round(giocatore1, giocatore2));
        this.risultati.getLast().lancioDadi(this.dado);

        if(this.risultati.size()%3 == 0 && this.risultati.getLast().getRisultato().equals(this.giocatore1.getNome())){
            this.giocatore1.aggiungiPuntoBonus();
            this.ultimoPuntoDato = 1;
        }else if(this.risultati.size()%3 == 0 && this.risultati.getLast().getRisultato().equals(this.giocatore2.getNome())){
            this.giocatore2.aggiungiPuntoBonus();
            this.ultimoPuntoDato = 2;
        }else if(this.risultati.size()%3 == 0){
            if(this.ultimoPuntoDato<0)
                return;
            else if(this.ultimoPuntoDato==1)
                this.giocatore1.togliPuntoBonus();
            else
                this.giocatore2.togliPuntoBonus();
        }
    }
}
