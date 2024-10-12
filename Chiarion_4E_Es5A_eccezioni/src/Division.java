import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a=0,b=0;
        double quoziente;

        while(true){
            try{
                System.out.println("Inserisci il primo numero: ");
                a = Integer.parseInt(keyboard.nextLine());
                System.out.println("Inserisci il secondo numero: ");
                b = Integer.parseInt(keyboard.nextLine());

                quoziente = divisione(a,b);
                System.out.println("La divisione e': "+quoziente);
                break;
            }catch (NumberFormatException e){
                System.out.println("Invalid Number");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static double divisione(int a, int b)throws Exception{
        if(b==0)
            throw new Exception("Can't divide a number with 0");

        return (double)a/b;
    }
}
