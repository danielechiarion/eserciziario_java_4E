package veicoli;

public class AutoNuova extends Auto{
    /* ATTRIBUTI */
    private String alimentazione;
    private int cavalli;

    /* COSTRUTTORI */
    public AutoNuova(String marca, String modello, double prezzo, int annoImmatricolazione, int id, String alimentazione, int cavalli)throws Exception{
        super(marca, modello, prezzo, annoImmatricolazione, id);
        this.setAlimentazione(alimentazione);
        this.setCavalli(cavalli);
    }

    public AutoNuova(String marca, String modello, double prezzo, int annoImmatricolazione, String alimentazione, int cavalli)throws Exception{
        super(marca, modello, prezzo, annoImmatricolazione);
        this.setAlimentazione(alimentazione);
        this.setCavalli(cavalli);
    }

    /* GETTER E SETTER */
    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public int getCavalli() {
        return cavalli;
    }

    public void setCavalli(int cavalli) throws Exception{
        if(cavalli<=0)
            throw new Exception("Potenza motore non valida");
        this.cavalli = cavalli;
    }

    /* ALTRI METODI */
    @Override
    public String mostraDettagli(){
        return String.format("AUTO: %s %s - %d\t%.2f€\t%s - %dcv",
                this.marca, this.modello, this.immatricolazione.getYear(), this.prezzo, this.alimentazione, this.cavalli);
    }
}
