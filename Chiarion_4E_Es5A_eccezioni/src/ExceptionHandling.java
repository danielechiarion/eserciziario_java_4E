import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a,b,somma;
        int[] array = {1,1,1,1};

        try {
            for(int i=0;i<=array.length;i++)
                System.out.println(array[i]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Si e' verificato un errore");
        }

        System.out.println("Il programma continua");

        while(true){
            try {
                a = gestInteger(keyboard);
                b = gestInteger(keyboard);

                System.out.println("La somma dei numeri e': "+(a+b));
                break;
            }catch(Exception e){
                System.out.println("Inserimento fallito: "+e.getMessage()+"\n\t"); //ritorna l'eccezione nel gestInteger
            }
        }
    }

    private static int gestInteger(Scanner keyboard)throws Exception{
        int n;

        System.out.println("Inserisci un numero >=0: ");
        n = Integer.parseInt(keyboard.nextLine());

        if(n>=0)
            return n;
        else
            throw new Exception("Valore non valido");
    }
}
