package backend;

import java.util.ArrayList;

public class GestoreNegozio {
    private ArrayList<ProdottoElettronico> prodotti;
    private String nomeNegozio;

    public GestoreNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
        this.prodotti = new ArrayList<>();
    }

    public ArrayList<ProdottoElettronico> getProdotti() {
        ArrayList<ProdottoElettronico> copia = new ArrayList<>();
        for (ProdottoElettronico prodotto : this.prodotti) {
            copia.add(prodotto.clone());
        }

        return copia;
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public ProdottoElettronico getProdotto(int index) {
        return this.prodotti.get(index).clone();
    }

    public void aggiungiProdotto(ProdottoElettronico prodotto) throws Exception {
        if (this.prodotti.contains(prodotto)) {
            throw new Exception("Prodotto existente");
        }

        this.prodotti.add(prodotto);
    }

    public void rimuoviProdotto(ProdottoElettronico prodotto) throws Exception {
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

    public boolean prodottoExists(ProdottoElettronico prodotto) throws Exception {
        return this.prodotti.contains(prodotto);
    }

    public int indexProdotto(ProdottoElettronico prodotto) {
        return this.prodotti.indexOf(prodotto);
    }

    public void cambiaPrezzo(int index, double prezzo) throws Exception {
        if (index < 0 || index >= this.prodotti.size())
            throw new Exception("Indice prodotto non valido");

        this.prodotti.get(index).setPrezzo(prezzo);
    }
}
