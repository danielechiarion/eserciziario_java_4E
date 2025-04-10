import java.util.Scanner;

import frontend.*;
import static frontend.Tools.*;
import mediaPlaylist.*;
import playlist.*;

public class Main {
    public static void main(String[] args) {
        /* opzioni possibili per l'utente */
        String[] opzioni = {
                "PLAYLIST",
                "Aggiungi media",
                "Rimuovi media",
                "Riproduci media",
                "Metti in pausa",
                "Riprendi",
                "Stop",
                "Prossimo",
                "Visualizza playlist",
                "Fine"
        };
        /* istanziazione degli oggetti */
        Scanner scanner = new Scanner(System.in);
        GestionePlayer gestionePlayer = new GestionePlayer();
        /* dichiarazione variabili */
        int scelta;

        do{
            scelta = Menu(opzioni, scanner);
            try {
                switch(scelta){
                    case 1 -> FrontScreen.inserimentoMedia(gestionePlayer, scanner);
                    case 2 -> FrontScreen.rimozioneMedia(gestionePlayer, scanner);
                    case 3 -> FrontScreen.riproduzioneMedia(gestionePlayer, scanner);
                    case 4 -> FrontScreen.interruzioneMedia(gestionePlayer);
                    case 5 -> FrontScreen.ripresaRiproduzioneMedia(gestionePlayer);
                    case 6 -> FrontScreen.stoppingMedia(gestionePlayer);
                    case 7 -> FrontScreen.prossimoMedia(gestionePlayer);
                    case 8 -> FrontScreen.visualizzazionePlaylist(gestionePlayer);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                Wait(3);
                clrScr();
            }
        }while(scelta != opzioni.length-1);
    }
}
