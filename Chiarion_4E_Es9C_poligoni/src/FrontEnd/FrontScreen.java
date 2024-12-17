package FrontEnd;

import java.util.Scanner;
public class FrontScreen {
    public static double safeDoubleInput(String testoRichiesta, Scanner scanner){
        double num = 0;
        boolean check;

        do{
            check=false;
            try{
                System.out.println(testoRichiesta);
                num = Double.parseDouble(scanner.nextLine());
                if(num<=0)
                    throw new Exception("Non puoi inserire un valore negativo\n");
            }catch(NumberFormatException e){
                System.out.println("ERROR! Input out of domain!");
                check=true;
            }catch(Exception e){
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        return num;
    }
}
