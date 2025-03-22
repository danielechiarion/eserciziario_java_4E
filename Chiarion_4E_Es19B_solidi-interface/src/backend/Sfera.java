package backend;

public class Sfera implements FiguraSolida{
    private double raggio;
    private String nome;

    public Sfera(double raggio) {
        this.nome = "Sfera";
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

    @Override
    public String toString(){
        return String.format("%s\tVolume: %.2fcm3\tSuperficie: %.2fcm2", this.nome, this.calcolaVolume(), this.calcolaSuperficie());
    }

    @Override
    public FiguraSolida clone(){
        try {
            return (FiguraSolida) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}