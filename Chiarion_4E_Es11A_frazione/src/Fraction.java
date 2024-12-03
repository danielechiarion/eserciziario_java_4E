import java.math.BigInteger;

public class Fraction {
    private int numerator;
    private int denominator;
    private int segno;

    /* metodi get/set */

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator)throws Exception{
        if(denominator == 0)
            throw new Exception("Il denominatore non può essere 0");
        this.denominator = denominator;
    }

    public int getSegno() {
        return this.segno;
    }

    /* metodo costruttore che prende in input i
    * singoli valori di numeratore o denominatore,
    * controllando se il denominatore è diverso da 0. */
    public Fraction(int numerator, int denominator) throws Exception{
        /* assegno numeratore e denominatore con
        * il valore assoluto */
        this.setNumerator(Math.abs(numerator));
        this.setDenominator(Math.abs(denominator)); //serve a controllare il valore del denominatore

        /* stabilisco il segno rispetto
        * ai valori di numeratore e denominatore */
        if(numerator*denominator>=0)
            this.segno = 1;
        else
            this.segno = -1;
    }

    /* metodo costruttore della frazione a partire
    * dalla stringa */
    public Fraction(String content) throws Exception{
        /* dichiarazione variabile */
        int numerator, denominator;

        /* divido i numeri */
        try {
            String[] numbers = content.split("/");
            numerator = Integer.parseInt(numbers[0]);
            denominator = Integer.parseInt(numbers[1]);
        }catch (Exception e) {
            throw new Exception("Formato frazione non valido");
        }

        /* controllo se il numeratore non è 0 */
        if(denominator == 0)
            throw new Exception("Il denominatore non può essere 0");

        /* assegno numeratore e denominatore con
         * il valore assoluto */
        this.setNumerator(Math.abs(numerator));
        this.setDenominator(Math.abs(denominator));

        /* stabilisco il segno rispetto
         * ai valori di numeratore e denominatore */
        if(numerator*denominator>=0)
            this.segno = 1;
        else
            this.segno = -1;
    }

    /* creazione di un costruttore il cui denominatore
    * vale sempre 5 */
    public Fraction(int numerator)throws Exception{
        this(numerator, 5);
    }

    /* metodo che calcola il valore della frazione
    * in double */
    public double doubleValue(){
        return this.segno*(double)this.numerator/this.denominator;
    }

    /* metodo che esegue la somma tra due frazioni
    * e ritorna un output in double */
    public double fractionAdditionDouble(Fraction fraction){
        return this.doubleValue()+fraction.doubleValue();
    }

    /* metodo che esegue la somma tra frazioni
    * e ritorna una frazione */
    public Fraction fractionAdditionFraction(Fraction fraction)throws Exception{
        /* imposto il denominatore calcolando
        * il MCM */
        int denominator = (this.denominator * fraction.denominator)/BigInteger.valueOf(this.denominator).gcd(BigInteger.valueOf(fraction.denominator)).intValue();
        /* calcolo il numeratore tenendo conto
        * del denominatore comune e del denominatore
        * della frazione attuale */
        int numerator = this.segno*denominator/this.denominator*this.numerator + fraction.segno*denominator/fraction.denominator*fraction.numerator;

        /* creo l'oggetto frazione */
        Fraction result = new Fraction(numerator, denominator);
        return result;
    }

    /* override del metodo equals,
    * che controlla numeratore, denominatore e segno */
    @Override
    public boolean equals(Object obj){
        /* controllo se l'oggetto è
        * un'istanza della classe Fraction */
        if(!(obj instanceof Fraction))
            return false;

        /* converto l'oggetto e, per semplicità,
        * controllo i valori booleani della frazione */
        Fraction fractionCompared = (Fraction)obj;

        return this.doubleValue() == fractionCompared.doubleValue();
    }

    /* override del metodo toString,
    * che restituisce la frazione */
    @Override
    public String toString(){
        String output; //dichiarazione variabile

        /* determino quale segno mettere */
        if(this.segno>=0)
            output = "+";
        else
            output = "-";

        /* ritorno la stringa con i valori di numeratore
        * e denominatore */
        output += String.format(" %d / %d", this.numerator, this.denominator);
        return output;
    }
}
