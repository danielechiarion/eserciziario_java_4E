package backend;

public class GaraAvanzata extends Gara<GiocatoreAvanzato>{
    private static final int numMinRound = 10;

    public GaraAvanzata(int numRound, int numFacce, GiocatoreAvanzato giocatore1, GiocatoreAvanzato giocatore2) throws Exception{
        super(numRound, numFacce, giocatore1, giocatore2);
        if(numRound < numMinRound)
            throw new Exception("Il numero minimo di round deve essere 10");
    }

    @Override
    public void round()throws Exception{
        if(super.fineGara())
            throw new Exception("Non è possibile proseguire oltre");

        this.risultati.add(new Round(giocatore1, giocatore2));
        this.risultati.getLast().lancioDadi(this.dado);

        if(this.risultati.getLast().getRisultato().equals(this.giocatore1.getNome())){
            this.giocatore1.aggiungiVittorieConsecutive();
            this.giocatore2.resetVittorieConsecutive();
            if(this.giocatore1.hasVittorieConsecutive()){
                this.giocatore1.aggiungiPuntoBonus();
            }
        }else if(this.risultati.getLast().getRisultato().equals(this.giocatore2.getNome())){
            this.giocatore2.aggiungiVittorieConsecutive();
            this.giocatore1.resetVittorieConsecutive();
            if(this.giocatore2.hasVittorieConsecutive()){
                this.giocatore2.aggiungiPuntoBonus();
            }
        }else{
            this.giocatore1.resetVittorieConsecutive();
            this.giocatore2.resetVittorieConsecutive();
        }
    }
}
