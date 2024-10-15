import static utility.Tools.*;
import static utility.Array.*;
import frontScreen.*;
import mensola.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta=0;
        /* dichiarazione costanti */
        final int dimensioneLibreria = 3;
        /* istanza vettori */
        String[] opzioni = {"OPZIONI POSSIBILI",
                            "Inserimento libro",
                            "Visualizza",
                            "Fine"};
        Libro[] libreria = new Libro[dimensioneLibreria];
        /* creazione oggetti */
        Scanner keyboard = new Scanner(System.in);

        /* ripeto ogni volta il ciclo */
        do{
            scelta = menu(opzioni, keyboard);
            switch(scelta){
                case 1:
                    try{
                        insertElementArray(libreria, FrontEnd.leggiLibro(keyboard, true, libreria));
                    }catch(ArrayIndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                case 2:
                    FrontEnd.printBookList(libreria);
                    break;
                default:
                    System.out.println("Uscita programma");
                    Wait(3);
            }
        }while(scelta!=opzioni.length-1);
    }
}