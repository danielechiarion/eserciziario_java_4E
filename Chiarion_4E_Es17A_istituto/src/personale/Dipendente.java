package personale;

import java.util.Objects;

public class Dipendente implements Cloneable{
    /* con gli attributi final non
    * si può impostare il set */
    private final String nominativo;
    private final char genere;
    private final String indirizzo;
    private final double incentivo = 0.5;
    private String ruolo;

    public Dipendente(String nominativo, char genere, String indirizzo, String ruolo) {
        this.nominativo = nominativo;
        this.genere = genere;
        this.indirizzo = indirizzo;
        this.ruolo = ruolo;
    }

    public String getNominativo() {
        return nominativo;
    }

    public char getGenere() {
        return genere;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public double getIncentivo() {
        return incentivo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dipendente that)) return false;
        return Objects.equals(nominativo, that.nominativo) && Objects.equals(ruolo, that.ruolo);
    }

    @Override
    public String toString(){
        return String.format("%s - %c\t%s\t%s\tIncentivo: %.2f", this.getNominativo(), this.getGenere(), this.getRuolo(), this.getIndirizzo(), this.getIncentivo());
    }
}
