public class Persona {
    private String anagrafica;
    private int eta;

    public Persona(String anagrafica, int eta) {
        this.anagrafica = anagrafica;
        this.eta = eta;
    }

    public String getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(String anagrafica) {
        this.anagrafica = anagrafica;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "anagrafica='" + anagrafica + '\'' +
                ", eta=" + eta +
                '}';
    }
}
