import java.util.Scanner;

import edifici.*;
import veicoli.*;
import frontend.*;
import static frontend.Tools.*;

public class Main {
    public static void main(String[] args) {
        /* opzioni del programma */
        String[] opzioni = {
                "NEGOZIO",
                "Aggiungi veicolo",
                "Rimuovi veicolo",
                "Modifica caratteristiche veicolo",
                "Visualizza veicoli per marca",
                "Visualizza veicoli per anno di immatricolazione",
                "Visualizza tutti i veicoli",
                "Prezzo attuale veicolo",
                "Fine"
        };
        /* dichiarazione variabili */
        int scelta;
        /* oggetti per il funzionamento del programma */
        Scanner scanner = new Scanner(System.in);
        Concessionario concessionario = new Concessionario();

        do{
            scelta = Menu(opzioni, scanner);
            try{
                switch(scelta){
                    case 1 -> Frontscreen.aggiungiAuto(concessionario, scanner);
                    case 2 -> Frontscreen.rimuoviAuto(concessionario, scanner);
                    case 3 -> Frontscreen.cambiaCaratteristicheVeicolo(concessionario, scanner);
                    case 4 -> Frontscreen.ricercaPerMarca(concessionario, scanner);
                    case 5 -> Frontscreen.ricercaPerImmatricolazione(concessionario, scanner);
                    case 6 -> Frontscreen.visualizzaVeicoli(concessionario);
                    case 7 -> Frontscreen.prezzoAttualeVeicolo(concessionario, scanner);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                Wait(3);
                clrScr();
            }
        }while(scelta != opzioni.length-1);
    }
}
