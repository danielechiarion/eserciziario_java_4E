import java.util.Scanner;

import backend.*;
import frontend.*;
import static frontend.Tools.*;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta;
        /* instanziazione oggetti */
        Scanner scanner = new Scanner(System.in);
        GestoreSolidi gestore = new GestoreSolidi();
        /* istanziazione dell'array con le opzioni disponibili */
        String[] opzioni = {
                "0PZIONI",
                "Inserisci un solido",
                "Visualizza solidi",
                "Fine"
        };

        do{
            scelta = Menu(opzioni, scanner);
            try{
                clrScr();
                switch (scelta){
                    case 1:
                        gestore.aggiungiSolido(FrontScreen.inserisciSolido(scanner));
                        break;
                    case 2:
                        FrontScreen.stampaRisultati("SOLIDI INSERITI", gestore.nomiSolidi());
                        Wait(5);
                        break;
                    default:
                        System.out.println("Fine programma");
                        Wait(3);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                Wait(3);
                clrScr();
            }
        }while(scelta != opzioni.length-1);
    }
}
