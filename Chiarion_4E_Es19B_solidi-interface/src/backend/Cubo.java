package backend;

public class Cubo implements FiguraSolida{
    private double lato;
    private String nome;

    public Cubo(double lato) {
        this.nome = "Cubo";
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