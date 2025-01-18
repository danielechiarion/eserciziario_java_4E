package gestGara;

import tempo.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

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

        this.griglia.add(scuderia);
    }

    /* metodo che ordina la classifica
    * in base al tempo indicato */
    public ArrayList<Scuderia> getClassifica(){
        ArrayList<Scuderia> classifica = this.getGriglia();
        classifica.sort(null);

        /* ne approfitto per stampare il nome del vincitore */
        this.vincitore = this.griglia.getFirst().getPilota().toString();

        return classifica;
    }

    /* metodo che setta ad una scuderia un determinato tempo */
    public void setTempo(Scuderia scuderia)throws Exception{
        if(this.cronometro.getTempoGiro() < 0)
            throw new Exception("Nessuna rilevazione effettuata");
        this.griglia.get(this.griglia.indexOf(scuderia)).setTempoGiro(this.cronometro.getTempoGiro());

        this.cronometro.resetTime(); //resetto il cronometro
    }

    /* toString della gara */
    @Override
    public String toString(){
        String output = String.format("Gran premio di %s - %s\n%d auto in gara",
                this.nome, this.nazionalita, this.numAutoGara);

        /* controllo se il vincitore è
        * stato scritto */
        if(!this.vincitore.isBlank())
            output += String.format("\nVincitore: %s", this.vincitore);

        return output;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Gara gara)) return false;
        return Objects.equals(getNome(), gara.getNome()) && Objects.equals(getNazionalita(), gara.getNazionalita());
    }

    /* genera l'intestazione del file CSV
    * dove verranno salvati tutti i file */
    public static String headerCSV(){
        return String.format("Numero auto,Pilota,Scuderia,Tempo");
    }

    /* ritorna la classifica della gara
    * in un formato valido per essere scritto su file CSV */
    public String toCSV(){
        ArrayList<Scuderia> classifica = this.getClassifica();
        StringBuilder text = new StringBuilder(headerCSV() + "\n"); //StringBuilder è più sicuro nella concatenazione in loop rispetto ad una semplice stringq

        for(int i=0;i<classifica.size();i++)
            text.append(classifica.get(i).toCSV()).append("\n");

        return text.toString(); //converto alla fine in stringa
    }
}