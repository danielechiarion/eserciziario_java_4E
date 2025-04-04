package backend;

public class Manuale extends Libro{
    private String argomento;

    public Manuale(String codiceAlfanumerico, String titolo, String autore, double prezzo, int quantita, String argomento)throws Exception{
        super(codiceAlfanumerico, titolo, autore, prezzo, quantita);
        this.argomento = argomento;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    @Override
    public String toString(){
        return String.format("%s\nManuale: %s", super.toString(), this.argomento);
    }
}
