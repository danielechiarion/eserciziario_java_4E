package gestGara;

import java.util.Objects;

public class Scuderia implements Comparable<Scuderia>,Cloneable {
    private String nome;
    private Pilota pilota;
    private int tempoGiro;
    private int numeroAuto;

    public Scuderia(String nome, Pilota pilota, int numeroAuto) {
        this.nome = nome;
        this.pilota = pilota;
        this.numeroAuto = numeroAuto;
        this.tempoGiro = -1;
    }

    public String getNome() {
        return this.nome;
    }

    public Pilota getPilota() {
        return this.pilota;
    }

    public int getTempoGiro() {
        return this.tempoGiro;
    }

    public int getNumeroAuto() {
        return this.numeroAuto;
    }

    public void setTempoGiro(int tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    /* override del metodo toString
    * per la stampa dei dati della scuderia */
    @Override
    public String toString(){
        String output = String.format("Nome scuderia: %d\tNumero Auto: %d\nPilota: %s", this.nome, this.numeroAuto, this.pilota.toString());
        if(this.tempoGiro>0)
            output+=String.format("\nTempo su giro: %d secondi", this.tempoGiro);

        return output;
    }

    /* override del metodo equals che
    * confronta la scuderia in base al nome
    * e al numero dell'auto */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Scuderia scuderia)) return false;
        return numeroAuto == scuderia.numeroAuto && Objects.equals(nome, scuderia.nome);
    }

    /* metodo che confronta le classi in base
    * al tempo sul giro */
    @Override
    public int compareTo(Scuderia scuderia) {
        return Integer.compare(this.tempoGiro, scuderia.tempoGiro);
    }

    /* metodo per clonare un oggetto
    * scuderia */
    @Override
    protected Scuderia clone() {
        Scuderia scuderia = new Scuderia(this.nome, this.pilota, this.numeroAuto);
        scuderia.setTempoGiro(this.tempoGiro);
        return scuderia;
    }
}
