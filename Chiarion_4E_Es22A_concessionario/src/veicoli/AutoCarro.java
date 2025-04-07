package veicoli;
public class AutoCarro extends Auto{
    /* ATTRIBUTI */
    private double tara; //tara espressa in quintali

    /* COSTRUTTORI */
    public AutoCarro(String marca, String modello, double prezzo, int annoImmatricolazione, int id, double tara)throws Exception{
        super(marca, modello, prezzo, annoImmatricolazione, id);
        this.setTara(tara);
    }

    public AutoCarro(String marca, String modello, double prezzo, int annoImmatricolazione, double tara) throws Exception{
        super(marca, modello, prezzo, annoImmatricolazione);
        this.setTara(tara);
    }

    /* GETTER E SETTER */
    public double getTara() {
        return tara;
    }

    public void setTara(double tara) throws Exception{
        if(tara<=0)
            throw new Exception("Tara non valida");
        this.tara = tara;
    }

    /* ALTRI METODI */
    @Override
    public String mostraDettagli(){
        return String.format("AUTOCARRO %04d: %s %s - %d\t%.2f€\tTara: %.2fq",
                this.id, this.marca, this.modello, this.immatricolazione.getYear(), this.prezzo, this.tara);
    }
}
