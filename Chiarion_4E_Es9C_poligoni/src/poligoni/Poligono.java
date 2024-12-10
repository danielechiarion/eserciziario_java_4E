package poligoni;

public class Poligono {
    public double calcolaArea(){
        return 0;
    }

    public double calcolaPerimetro(){
        return 0;
    }

    public String descrizione(){
        return "";
    }

    public int compareTo(Poligono altroPoligono){
        return Double.compare(this.calcolaArea(), altroPoligono.calcolaArea());
    }

    public String getInformazioni(){
        return String.format("%s\nArea: %.1f\tPerimetro: %.1f", this.descrizione(), this.calcolaArea(), this.calcolaPerimetro());
    }
}
