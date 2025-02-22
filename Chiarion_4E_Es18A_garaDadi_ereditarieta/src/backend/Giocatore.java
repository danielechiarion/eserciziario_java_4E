package backend;

import java.util.Objects;

public class Giocatore implements Comparable<Giocatore> {
    private String nome;
    private int vittorie;

    public Giocatore(String nome){
        this.nome = nome;
        this.vittorie = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVittorie() {
        return vittorie;
    }

    /* metodo che incrementa il numero di vittorie
     * di 1 */
    public void incrementaVittoria(){
        this.vittorie++;
    }

    @Override
    public String toString(){
        return String.format("%s - %d vittorie", this.nome, this.vittorie);
    }

    /* metodo che confronta se i due giocatori sono
     * uguali in base al nome indicato */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giocatore giocatore = (Giocatore) o;
        return Objects.equals(nome, giocatore.nome);
    }

    @Override
    public int compareTo(Giocatore o){
        Giocatore altro = (Giocatore) o;
        return Integer.compare(this.vittorie, altro.vittorie);
    }

    public void resetGiocate(){
        this.vittorie = 0;
    }
}
