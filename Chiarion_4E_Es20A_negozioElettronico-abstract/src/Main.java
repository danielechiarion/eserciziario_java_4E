import java.util.ArrayList;
import java.util.Scanner;

import backend.*;
import static frontend.Frontscreen.*;
import static frontend.Tools.*;

public class Main {
    public static void main(String[] args) {
        /* definisco le opzioni per il programma */
        String[] opzioni = {
          "NEGOZIO ELETTRONICO",
          "Aggiungi prodotto",
          "Rimuovi prodotto",
          "Ricerca prodotto",
          "Modifica prezzo prodotto",
          "Visualizza tutti i prodotti",
          "Fine"
        };
        /* creazione oggetti per il funzionamento del programma */
        Scanner scanner = new Scanner(System.in);
        ProdottoElettronico prodottoInput;
        ArrayList<ProdottoElettronico> listaProdotti = new ArrayList<>();
        /* dichiarazione variabili */
        int scelta;

        do{
            scelta = Menu(opzioni, scanner);
            try{
               clrScr();
               switch(scelta){
                   /* INSERIMENTO PRODOTTO */
                   case 1:
                       inserisciProdotto(scanner, listaProdotti);
                       break;
                   /* RIMOZIONE PRODOTTO */
                   case 2:
                       rimuoviProdotto(scanner, listaProdotti);
                       break;
                   /* RICERCA PRODOTTO */
                   case 3:
                       ricercaProdotto(scanner, listaProdotti);
                       break;
                   /* MODIFICA PREZZO PRODOTTO */
                   case 4:
                       cambiaPrezzoProdotto(scanner, listaProdotti);
                       break;
                   /* VISUALIZZAZIONE DI TUTTI I PRODOTTI */
                   case 5:
                       visualizzaProdotti(listaProdotti);
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
