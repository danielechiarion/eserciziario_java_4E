package backend;

public class GiocatoreAvanzato extends Giocatore implements Comparable<Giocatore> {
    private int puntiBonus;
    private int vittorieConsecutive;

    public GiocatoreAvanzato(String nome) {
        super(nome);
        this.puntiBonus = 0;
        this.vittorieConsecutive = 0;
    }

    public int getPuntiBonus() {
        return this.puntiBonus;
    }

    public void aggiungiPuntoBonus() {
        this.puntiBonus ++;
    }

    public void togliPuntoBonus(){
        if(this.puntiBonus != 0)
            this.puntiBonus--;
    }

    public void aggiungiVittorieConsecutive() {
        this.vittorieConsecutive++;
    }

    public void resetVittorieConsecutive() {
        this.vittorieConsecutive = 0;
    }

    public boolean hasVittorieConsecutive(){
        return this.vittorieConsecutive!=0 && this.vittorieConsecutive%3==0;
    }

    @Override
    public void resetGiocate(){
        super.resetGiocate();
        this.puntiBonus = 0;
    }

    @Override
    public String toString(){
        return String.format("%s - %d punti bonus", super.toString(), this.puntiBonus);
    }

    @Override
    public int compareTo(Giocatore altro) {
        if(!(altro instanceof GiocatoreAvanzato))
            return super.compareTo(altro);

        GiocatoreAvanzato altroAvanzato = (GiocatoreAvanzato) altro;

        return Integer.compare(this.getVittorie()+this.puntiBonus, altroAvanzato.getVittorie()+altroAvanzato.puntiBonus);
    }
}
