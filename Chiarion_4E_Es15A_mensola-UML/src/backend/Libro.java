package backend;

import java.util.Objects;

public class Libro implements Cloneable{
    private String titolo;
    private String autore;
    private int nPagine;
    private Genere tipo;

    private static final double COSTOPAGINE = 0.05;

    public Libro(String titolo, String autore, int nPagine, Genere tipo){
        this.titolo = titolo;
        this.autore = autore;
        this.nPagine = nPagine;
        this.tipo = tipo;
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

    public Genere getTipo() {
        return tipo;
    }

    public void setTipo(Genere tipo) {
        this.tipo = tipo;
    }

    public double getPrezzo(){
        return this.nPagine * COSTOPAGINE;
    }

    @Override
    public String toString(){
        return String.format("titolo: %s; autore: %s; numero pagine: %d; tipo: %s, Prezzo Libro: %.2f€",
                this.titolo, this.autore, this.nPagine, this.tipo);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Libro libro)) return false;
        return Objects.equals(getTitolo(), libro.getTitolo()) && Objects.equals(getAutore(), libro.getAutore());
    }

    @Override
    public Libro clone(){
        return new Libro(this.titolo, this.autore, this.nPagine, this.tipo);
    }
}
