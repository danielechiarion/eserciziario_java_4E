package backend;

public class Cubo extends Solido {
    private double lato;

    public Cubo(double lato) {
        super("Cubo");
        this.lato = lato;
    }

    public double getLato() {
        return this.lato;
    }

    @Override
    public double calcolaVolume(){
        return Math.pow(this.lato, 3);
    }

    @Override
    public double calcolaSuperficie(){
        return 6*Math.pow(this.lato, 2);
    }
}