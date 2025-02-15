package backend;

public class Manuale extends Libro{
    private Livello livello;

    /* costruttore che richiama
    * il metodo costruttore della superclasse */
    public Manuale(String titolo, String autore, int nPagine, Livello livello) {
        super(titolo, autore, nPagine);
        this.livello = livello;
    }

    public Livello getLivello() {
        return livello;
    }

    public void setLivello(Livello livello) {
        this.livello = livello;
    }

    @Override
    public String toString() {
        return String.format("%s\tLivello: %s", super.toString(), this.livello.toString());
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Manuale))
            return false;

        Manuale altro = (Manuale) obj;
        return super.equals(altro) && this.livello == altro.livello;
    }
}
