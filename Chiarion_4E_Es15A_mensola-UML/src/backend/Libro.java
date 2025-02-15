package backend;

import java.util.Objects;

public class Libro implements Cloneable{
    private String titolo;
    private String autore;
    private int nPagine;

    private static final double COSTOPAGINE = 0.05;

    public Libro(String titolo, String autore, int nPagine){
        this.titolo = titolo;
        this.autore = autore;
        this.nPagine = nPagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getnPagine() {
        return nPagine;
    }

    public void setnPagine(int nPagine) {
        this.nPagine = nPagine;
    }

    public double getPrezzo(){
        return this.nPagine * COSTOPAGINE;
    }

    @Override
    public String toString(){
        return String.format("titolo: %s; autore: %s; numero pagine: %d; Prezzo Libro: %.2f€",
                this.titolo, this.autore, this.nPagine);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Libro libro)) return false;
        return Objects.equals(getTitolo(), libro.getTitolo()) && Objects.equals(getAutore(), libro.getAutore());
    }

    @Override
    public Libro clone(){
        return new Libro(this.titolo, this.autore, this.nPagine);
    }
}
