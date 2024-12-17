package poligoni;

public class Rettangolo extends Poligono {
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public double calcolaArea() {
        return base * altezza;
    }

    @Override
    public String descrizione(){
        return String.format("Rettangolo con base %.1f e altezza %.1f", this.base, this.altezza);
    }

    @Override
    public double calcolaPerimetro(){
        return (this.base+this.altezza)*2;
    }
}
