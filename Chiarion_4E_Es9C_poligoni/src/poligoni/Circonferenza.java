package poligoni;

public class Circonferenza extends Poligono{
    private double raggio;

    public Circonferenza(double raggio) {
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    @Override
    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }

    @Override
    public String descrizione(){
        return String.format("Circonferenza con raggio %.1f", this.raggio);
    }

    @Override
    public double calcolaPerimetro(){
        return this.raggio*2*Math.PI;
    }
}
