public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = null, fraction2 = null;

        /* creo le due frazioni */
        try{
            fraction1 = new Fraction(-1,-2);
            fraction2 = new Fraction("-2/3");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        /* calcolo la soluzione e la ritorno */
        try{
            System.out.println("Soluzione frazione: "+fraction1.fractionAdditionFraction(fraction2).toString());
            System.out.println("Soluzione double: "+fraction1.fractionAdditionDouble(fraction2));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
