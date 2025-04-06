package veicoli;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public abstract class Auto implements Cloneable, Comparable<Auto> {
    /* dichiarazione variabile per conteggiare l'ID */
    private static int IDcounter;

    /* ATTRIBUTI */
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

    protected Auto(String marca, String modello, double prezzo, int annoImmatricolazione, int id, boolean terminator){
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.immatricolazione = LocalDate.of(1,1,annoImmatricolazione);
        this.id = id;
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

    /* equals basato sulla marca dell'auto
    * o sull'id in base all'inserimento effettuato */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Auto auto)) return false;
        if(auto.marca.isBlank())
            return this.marca.equals(auto.marca);
        else
            return this.id == auto.id;
    }

    @Override
    public Auto clone(){
        try{
            return (Auto) super.clone();
        }catch(CloneNotSupportedException e) {
            return null;
        }
    }

    /* compareTo dove si confrontano
    * le auto in base alla data di immatricolazione */
    @Override
    public int compareTo(Auto other){
        return this.immatricolazione.compareTo(other.immatricolazione);
    }
}
