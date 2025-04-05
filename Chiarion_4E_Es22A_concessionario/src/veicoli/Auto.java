package veicoli;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Auto implements Cloneable{
    /* dichiarazione variabile per conteggiare l'ID */
    private static int IDcounter;

    protected int id;
    protected String marca;
    protected String modello;
    protected double prezzo;
    protected LocalDate immatricolazione;

    /* COSTRUTTORI */
    public Auto(String marca, String modello, double prezzo, int annoImmatricolazione, int id)throws Exception {
        this.setMarca(marca);
        this.setPrezzo(prezzo);
        this.setId(id);
        this.setImmatricolazione(annoImmatricolazione);
        this.setId(id);
    }

    public Auto(String marca, String modello, double prezzo, int annoImmatricolazione)throws Exception {
        this(marca, modello, prezzo, annoImmatricolazione, calculateID());
    }

    /* GETTER E SETTER */
    public int getId() {
        return id;
    }

    private void setId(int id) throws Exception {
        if(id<=0)
            throw new Exception("Id invalido");
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getPrezzo(){
        return prezzo;
    }

    public void setPrezzo(double prezzo) throws Exception{
        if(prezzo < 0)
            throw new Exception("Prezzo inserito non valido");
        this.prezzo = prezzo;
    }

    public void setImmatricolazione(int annoImmatricolazione) throws Exception {
        if(annoImmatricolazione < 1850 || annoImmatricolazione > LocalDate.now().getYear())
            throw new Exception("Immatricolazione invalida");
        this.immatricolazione = LocalDate.of(annoImmatricolazione, 1, 1);
    }

    /* ALTRI METODI */
    private static int calculateID(){
        return ++IDcounter;
    }

    public int etaVeicolo(){
        return (int)ChronoUnit.YEARS.between(this.immatricolazione, LocalDate.now());
    }

    public double valoreAttuale(){
        double nuovoPrezzo = this.prezzo/100*(100-this.etaVeicolo()*5);
        if(nuovoPrezzo < 0)
            return 0;

        return nuovoPrezzo;
    }

    public abstract String mostraDettagli();
}
