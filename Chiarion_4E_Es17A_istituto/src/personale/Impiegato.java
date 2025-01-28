package personale;

public class Impiegato extends Dipendente {
    private String ufficio;

    public String getUfficio() {
        return ufficio;
    }

    public void setUfficio(String ufficio) {
        this.ufficio = ufficio;
    }

    @Override
    public double getIncentivo() {
        return super.getIncentivo()*3;
    }

    public Impiegato(String nominativo, char genere, String indirizzo, String ufficio) {
        super(nominativo, genere, indirizzo, Impiegato.class.getSimpleName());
        this.ufficio = ufficio;
    }

    @Override
    public String toString() {
        return String.format("%s\nUfficio: %s", super.toString(), this.getUfficio());
    }
}
