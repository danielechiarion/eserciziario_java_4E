package gestGara;

import java.util.Objects;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;

    public Pilota(String nome, String cognome, String nazionalita) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getNazionalita() {
        return this.nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    /* metodo toString
     * della classe Pilota */
    public String toString() {
        return String.format("%s %s\t%s", this.nome, this.cognome, this.nazionalita);
    }

    /* metodo equals che confronti
     * due piloti che abbiano da confrontare
     * nome e cognome */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pilota pilota)) return false;
        return Objects.equals(nome, pilota.nome) && Objects.equals(cognome, pilota.cognome);
    }
}