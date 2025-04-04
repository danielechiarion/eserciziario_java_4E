package backend;

public abstract class ProdottoElettronico extends Prodotto{
    protected String marca;

    /* costruttore */
    public ProdottoElettronico(String codiceProdotto, double prezzo, String marca) throws Exception{
        super(prezzo, codiceProdotto);
        this.setMarca(marca);
    }

    /* costruttore che prende in input solo il codice prodotto */
    public ProdottoElettronico(String codiceProdotto){
        super(codiceProdotto);
    }

    /* GETTER E SETTER */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /* metodo toString che stampa le prime indicazioni
    * di un prodotto elettronico */
    @Override
    public String toString(){
        return String.format("%s\t%.2f€\t%s", this.marca, this.prezzo, this.codiceProdotto);
    }
}
