package poligoni;

public class TriangoloRettangolo extends Poligono{
    private double base;
    private double altezza;

    public TriangoloRettangolo(double base, double altezza) {
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
        return (base * altezza) / 2;
    }

    @Override
    public String descrizione(){
        return String.format("Triangolo rettangolo con base %.1f e altezza %.1f", this.base, this.altezza);
    }

    public double calcolaIpotenusa(){
        return Math.sqrt(Math.pow(this.base,2)+Math.pow(this.altezza,2));
    }

    @Override
    public double calcolaPerimetro(){
        return this.base + this.altezza + this.calcolaIpotenusa();
    }
}
