package backend;

import java.util.Objects;

public class Prodotto implements Cloneable{
    protected double prezzo;
    protected String codiceProdotto;

    public Prodotto(double prezzo, String codice)throws Exception{
        this.setPrezzo(prezzo);
        this.codiceProdotto = codice;
    }

    public Prodotto(String codice){
        this.codiceProdotto = codice;
        this.prezzo = 0.0;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) throws Exception{
        if(prezzo<0)
            throw new Exception("Prezzo non valido");
        this.prezzo = prezzo;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Prodotto prodotto)) return false;
        return this.codiceProdotto.equals(prodotto.codiceProdotto);
    }

    @Override
    public Prodotto clone(){
        try {
            return (Prodotto) super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public String toString(){
        return String.format("%s - %.2f€", this.codiceProdotto, this.prezzo);
    }
}
