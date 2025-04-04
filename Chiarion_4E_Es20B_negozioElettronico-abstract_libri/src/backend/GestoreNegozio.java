package backend;

import java.util.ArrayList;

public class GestoreNegozio {
    private ArrayList<Prodotto> prodotti;
    private String nomeNegozio;

    public GestoreNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
        this.prodotti = new ArrayList<>();
    }

    public ArrayList<Prodotto> getProdotti() {
        ArrayList<Prodotto> copia = new ArrayList<>();
        for (Prodotto prodotto : this.prodotti) {
            copia.add(prodotto.clone());
        }

        return copia;
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public Prodotto getProdotto(int index) {
        return this.prodotti.get(index).clone();
    }

    public void aggiungiProdotto(Prodotto prodotto) throws Exception {
        if (this.prodotti.contains(prodotto)) {
            throw new Exception("Prodotto existente");
        }

        this.prodotti.add(prodotto);
    }

    public void rimuoviProdotto(Prodotto prodotto) throws Exception {
        if (!this.prodotti.contains(prodotto)) {
            throw new Exception("Prodotto non trovato");
        }

        this.prodotti.remove(prodotto);
    }

    public void rimuoviProdotto(int index) throws Exception {
        /* controllo se l'indice è al di fuori del range */
        if (index < 0 || index >= this.prodotti.size()) {
            throw new Exception("Indice prodotto non valido");
        }
        this.prodotti.remove(index);
    }

    public boolean prodottoExists(Prodotto prodotto) throws Exception {
        return this.prodotti.contains(prodotto);
    }

    public int indexProdotto(Prodotto prodotto) {
        return this.prodotti.indexOf(prodotto);
    }

    public void cambiaPrezzo(int index, double prezzo) throws Exception {
        if (index < 0 || index >= this.prodotti.size())
            throw new Exception("Indice prodotto non valido");

        this.prodotti.get(index).setPrezzo(prezzo);
    }
}
