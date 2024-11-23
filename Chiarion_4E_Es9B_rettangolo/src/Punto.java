public class Punto {
    /* dichiaro le coordinate del punto */
    private int x;
    private int y;

    /* dichiarazioni dei metodi costruttori */
    public Punto() {
        this.x = 10;
        this.y = 10;
    }

    public Punto(int x, int y) throws Exception {
        /* controllo se i valori sono entro il limite */
        if (x > 40)
            throw new Exception("OutOfRange x");
        if (y > 50)
            throw new Exception("OutOfRange y");

        this.x = x;
        this.y = y;
    }

    public Punto(int y) throws Exception {
        this(23, y);
    }

    /* metodi get e set degli attributi */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /* metodo che ritorna il quadrante dove il punto è posizionato */
    public int getQuadrante() throws Exception {
        if (this.x > 0 && this.y > 0)
            return 1;
        else if (this.x < 0 && this.y > 0)
            return 2;
        else if (this.x < 0 && this.y < 0)
            return 3;
        else if (this.x > 0 && this.y < 0)
            return 4;

        /* se non rispetta nessuna delle seguenti condizioni vuol dire che coincide con
        * l'origine degli assi */
        throw new Exception("Il punto coincide con l'origine degli assi");
    }

    /* override del metodo toString */
    @Override
    public String toString(){
        return String.format("X: %d\tY: %d", this.x, this.y);
    }
}
