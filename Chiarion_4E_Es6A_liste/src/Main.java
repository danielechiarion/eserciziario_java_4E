import java.util.ArrayList;
import java.util.Scanner;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> valori = null;
        Scanner scanner = new Scanner(System.in);
        String[] opzioni = {
                "ARRAYLIST",
                "Creazione",
                "Dimensione",
                "Inserisci elemento",
                "Visualizza",
                "Esci",
        };

        boolean quit = true;

        do{
            switch(menu(opzioni, scanner)){
                case 1 -> valori = new ArrayList<>(2);
                case 2 -> {
                    System.out.println(valori.size());
                    Wait(3);}
                case 3 -> {
                    System.out.println("Inserisci numero");
                    int inputNum = Integer.parseInt(scanner.nextLine());
                    valori.add(inputNum);
                }
                case 4 -> {
                    if(valori == null || valori.isEmpty())
                        break;
                    for(Object object : valori.toArray())
                        System.out.println(object.toString());
                    Wait(5);
                }
                default -> quit = false;
            }
        }while(quit);
    }
}