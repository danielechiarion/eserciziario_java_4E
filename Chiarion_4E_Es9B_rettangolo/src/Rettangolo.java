public class Rettangolo {
    /* attributi */
    private Punto puntoDiagonaleA;
    private Punto puntoDiagonaleB;

    /* metodo costruttore */
    public Rettangolo(Punto puntoDiagonaleA, Punto puntoDiagonaleB)throws Exception{
        /* controllo se i punti inseriti permettono la creazione di un rettangolo.
        * Se hanno la stessa ascissa o ordinata sarebbe una linea.
        * Se i due punti sono uguali si ha un punto */
        if(puntoDiagonaleA.getX() == puntoDiagonaleB.getX() || puntoDiagonaleA.getY() == puntoDiagonaleB.getY())
            throw new Exception("I dati che hai inserito non permettono la creazione di un triangolo");

        this.puntoDiagonaleA = puntoDiagonaleA;
        this.puntoDiagonaleB = puntoDiagonaleB;
    }

    /* metodi getter e setter */

    public Punto getPuntoDiagonaleA() {
        return this.puntoDiagonaleA;
    }

    public void setPuntoDiagonaleA(Punto puntoDiagonaleA) {
        this.puntoDiagonaleA = puntoDiagonaleA;
    }

    public Punto getPuntoDiagonaleB() {
        return this.puntoDiagonaleB;
    }

    public void setPuntoDiagonaleB(Punto puntoDiagonaleB) {
        this.puntoDiagonaleB = puntoDiagonaleB;
    }

    /* metodo che calcola la base di un rettangolo  */
    public int calcolaBase(){
        return Math.abs(this.puntoDiagonaleA.getX() - this.puntoDiagonaleB.getX());
    }

    /* metodo che calcola l'altezza del triangolo */
    public int calcolaAltezza(){
        return Math.abs(this.puntoDiagonaleA.getY() - this.puntoDiagonaleB.getY());
    }

    /* metodo che calcola l'area di un rettangolo */
    public int calcolaArea(){
        return this.calcolaAltezza()*this.calcolaBase();
    }

    /* metodo che calcola il perimetro di un rettangolo */
    public int calcolaPerimetro(){
        return (this.calcolaBase()+this.calcolaAltezza())*2;
    }

    /* metodo che serve a identificare:
    * - è un rettangolo -> TRUE
    * - è un quadrato -> FALSE */
    public boolean isRettangolo(){
        if(this.calcolaBase() != this.calcolaAltezza())
            return true;

        return false;
    }

    /* metodo per il calcolo della diagonale di un rettangolo */
    public double calcoloDiagonale(){
        /* applico il teorema di pitagora per calcolare la diagonale */
        return Math.sqrt(Math.pow(this.puntoDiagonaleA.getX()-this.puntoDiagonaleB.getX(), 2)+Math.pow(this.puntoDiagonaleA.getY()-this.puntoDiagonaleB.getY(),2));
    }

    /* override del metodo equals:
    * - OPZIONE 0 > controlla se i rettangoli condividono gli stessi punti
    * - OPZIONE 1 > controlla se i rettangoli hanno le stesse dimensioni */
    public boolean equals(Object obj, int opzione){
        /* prima controllo se l'oggetto è un istanza
        * del rettangolo */
        if(!(obj instanceof Rettangolo))
            return false;

        /* faccio il cast dell'obj e ne confronto i punti */
        Rettangolo rettangoloConfronto = (Rettangolo)obj;

        if(opzione == 0)
            return this.puntoDiagonaleA.equals(rettangoloConfronto.puntoDiagonaleA) && this.puntoDiagonaleB.equals(rettangoloConfronto.puntoDiagonaleB);
        else
            return this.calcolaBase() == rettangoloConfronto.calcolaBase() && this.calcolaAltezza() == rettangoloConfronto.calcolaAltezza();
    }

    /* override del metodo toString */
    @Override
    public String toString(){
        return String.format("Rettangolo: %b\nPunto A >> %s\nPunto B >> %s\nBase: %dcm\tAltezza: %dcm\nArea: %dcmq\tPerimetro: %dcm",
                this.isRettangolo(), this.puntoDiagonaleA.toString(), this.puntoDiagonaleB.toString(), this.calcolaBase(), this.calcolaAltezza(), this.calcolaArea(), this.calcolaPerimetro());
    }

    /* metodo per la stampa di un rettangolo in
    * base alle sue dimensioni */
    public void stampaRettangolo(){
        for(int i=0;i<this.calcolaAltezza();i++){
            for(int j=0;j<this.calcolaBase();j++){
                if(j==0 || j==this.calcolaBase()-1 || i==0 || i==this.calcolaAltezza()-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
