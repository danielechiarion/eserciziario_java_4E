import static utility.Tools.*;
import static utility.Array.*;
import frontScreen.*;
import mensola.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta;
        /* istanza vettori */
        String[] opzioni = {"OPZIONI POSSIBILI",
                            "Inserimento libro",
                            "Visualizza",
                            "Fine"};
        Libro[] libreria = null;
        /* creazione oggetti */
        Scanner keyboard = new Scanner(System.in);

        /* ripeto ogni volta il ciclo */
        do{
            scelta = menu(opzioni, keyboard);
            switch(scelta){
                case 1:
                    libreria = extendArray(libreria);
                    insertElementArray(libreria, FrontEnd.leggiLibro(keyboard, true, libreria));
                    break;
                case 2:
                    Libro.printBookList(libreria);
                    break;
                default:
                    System.out.println("Uscita programma");
                    Wait(3);
            }
        }while(scelta!=opzioni.length-1);
    }
}