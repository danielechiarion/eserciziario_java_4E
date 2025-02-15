package backend;

public class Romanzo extends Libro{
    private String genereLetterario;

    public Romanzo(String titolo, String autore, int nPagine, String genereLetterario) {
        super(titolo, autore, nPagine);
        this.genereLetterario = genereLetterario;
    }

    public String getGenereLetterario() {
        return genereLetterario;
    }

    public void setGenereLetterario(String genereLetterario) {
        this.genereLetterario = genereLetterario;
    }

    @Override
    public String toString() {
        return String.format("%s\tGenere letterario: %s", super.toString(), this.genereLetterario);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Romanzo))
            return false;

        Romanzo altro = (Romanzo) obj;
        return super.equals(altro) && this.genereLetterario.equalsIgnoreCase(altro.genereLetterario);
    }
}
