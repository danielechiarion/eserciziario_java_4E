package gestGara;

import tempo.*;

import java.util.ArrayList;

public class Gara {
    private String nome;
    private String nazionalita;
    private ArrayList<Scuderia> griglia;
    private Cronometro cronometro;
    private String vincitore;
    private int numAutoGara;

    /* getter */

    public String getNome() {
        return nome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    /* in questo caso il getter ritorna una copia della griglia */
    public ArrayList<Scuderia> getGriglia() {
        ArrayList<Scuderia> copia = new ArrayList<>();
        for(Scuderia s : griglia) {
            copia.add(s.clone());
        }

        return copia;
    }

    public Cronometro getCronometro() {
        return this.cronometro;
    }

    public String getVincitore() {
        return this.vincitore;
    }

    public int getNumAutoGara() {
        return this.numAutoGara;
    }

    /* costruttore della classe gara */
    public Gara (String nome, String nazionalita, int numAutoGara) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.numAutoGara = numAutoGara;

        this.griglia = new ArrayList<>();
        this.cronometro = new Cronometro();
        this.vincitore = "";
    }

    /* metodo che aggiunge una scuderia alle auto in gara,
    * controllando che non esista già o che sia esaurito
    * il numero di posti disponibili */
    public void addScuderia(Scuderia scuderia) throws Exception {
        if(this.griglia.contains(scuderia))
            throw new Exception("Scuderia già inserita");
        if(this.griglia.size() == this.numAutoGara)
            throw new Exception("Griglia occupata");
    }
}