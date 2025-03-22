package backend;

import java.util.Objects;

public abstract class ProdottoElettronico implements Cloneable{
    protected String codiceProdotto;
    protected double prezzo;
    protected String marca;

    /* costruttore */
    public ProdottoElettronico(String codiceProdotto, double prezzo, String marca) throws Exception{
        this.setCodiceProdotto(codiceProdotto);
        this.setPrezzo(prezzo);
        this.setMarca(marca);
    }

    /* costruttore che prende in input solo il codice prodotto */
    public ProdottoElettronico(String codiceProdotto){
        this.setCodiceProdotto(codiceProdotto);
    }

    /* GETTER e SETTER */
    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(String codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) throws Exception {
        /* controllo se il prezzo è minore di 0,
        * così da lanciare un'eccezione */
        if(prezzo<0){
            throw new Exception("Prezzo non valido. Deve essere >= 0€");
        }
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /* equals che confronta solo il codice prodotto */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ProdottoElettronico that)) return false;
        return this.codiceProdotto.equals(that.codiceProdotto);
    }

    /* metodo clone per il prodotto elettronico */
    @Override
    public ProdottoElettronico clone(){
        try {
            return (ProdottoElettronico) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* metodo toString che stampa le prime indicazioni
    * di un prodotto elettronico */
    @Override
    public String toString(){
        return String.format("%s\t%.2f€\t%s", this.marca, this.prezzo, this.codiceProdotto);
    }
}
