package poligoni;

public class Quadrato extends Poligono{
    private double lato;

    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    @Override
    public double calcolaArea() {
        return lato * lato;
    }

    @Override
    public String descrizione(){
        return String.format("Quadrato con lato %.1f", this.lato);
    }

    @Override
    public double calcolaPerimetro(){
        return this.lato*4;
    }
}
