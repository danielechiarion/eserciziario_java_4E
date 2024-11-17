public class Segmento {
    /* dichiarazione attributi */
    private Punto puntoA;
    private Punto puntoB;

    /* metodo costruttore */
    public Segmento(Punto a, Punto b){
        this.puntoA = a;
        this.puntoB = b;
    }

    /* get e set degli attributi indicati */
    public Punto getPuntoA(){
        return this.puntoA;
    }

    public Punto getPuntoB(){
        return this.puntoB;
    }
    public void setPuntoA(Punto x){
        this.puntoA = x;
    }
    public void setPuntoB(Punto x){
        this.puntoB = x;
    }

    /* metodo che calcola la lunghezza di un segmento,
    * applicando il teorema di pitagora */
    public double calcolaLunghezza(){
        return Math.sqrt(Math.pow(this.puntoA.getX()-this.puntoB.getX(), 2)+Math.pow(this.puntoA.getY()-this.puntoB.getY(),2));
    }

    /* override del metodo toString */
    public String toString(){
        return String.format("Punto A = %s\nPunto B = %s\nLunghezza = %.2f", this.puntoA.toString(), this.puntoB.toString(), this.calcolaLunghezza());
    }
}
