package backend;

public class Sfera extends Solido{
    private double raggio;

    public Sfera(double raggio) {
        super("Sfera");
        this.raggio = raggio;
    }

    @Override
    public double calcolaVolume(){
        return (double)4/3 * Math.PI * Math.pow(this.raggio, 3);
    }

    @Override
    public double calcolaSuperficie(){
        return 4 * Math.PI * Math.pow(this.raggio, 2);
    }
}