package backend;

public class Thriller extends Libro{
    private Genere genere;

    public Thriller(String titolo, String autore, int nPagine, Genere genere) {
        super(titolo, autore, nPagine);
        this.genere = genere;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public String toString(){
        return String.format("%s\tGenere: %s", super.toString(), this.genere.getNome());
    }
}
