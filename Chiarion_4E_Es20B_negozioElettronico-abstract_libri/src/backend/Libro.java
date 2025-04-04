package backend;

import java.util.Objects;

public abstract class Libro extends Prodotto{
    /* ATTRIBUTI */
    protected String titolo;
    protected String autore;
    protected int quantita;

    /* COSTRUTTORE */
    public Libro(String codiceAlfanumerico, String titolo, String autore, double prezzo, int quantita)throws Exception {
        super(prezzo, codiceAlfanumerico);
        this.setTitolo(titolo);
        this.setAutore(autore);
        this.setQuantita(quantita);
    }

    /* GETTER E SETTER */
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

    public void setQuantita(int quantita) throws Exception{
        if(quantita<=0)
            throw new Exception("Quantità non valida");
        this.quantita = quantita;
    }

    /* metodo che ritorna il totale da pagare di un libro */
    public double getTotale(){
        return this.prezzo*this.quantita;
    }

    /* ALTRI METODI */
    @Override
    public String toString(){
        return String.format("%s\t'%s' di %s\t%.2f€ - %d unità",
                this.codiceProdotto, this.titolo, this.autore, this.prezzo, this.quantita);
    }
}
