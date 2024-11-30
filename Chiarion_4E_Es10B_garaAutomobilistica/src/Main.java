import java.util.Scanner;
import java.util.ArrayList;

import FrontEnd.*;
import gestGara.*;
import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        /* definisco le opzioni */
        String[] opzioni = {
                "GARA AUTOMOBILISTICA",
                "Inserisci pilota",
                "Inserisci auto",
                "Visualizza piloti",
                "Visualizza classifica",
                "Inizia misurazione tempo",
                "Concludi misurazione tempo",
                "Fine"
        };
        /* dichiarazione variabili */
        int scelta;
        Pilota pilotaInput;
        Auto autoInput;
        /* istanza delle liste da utilizzare */
        ArrayList<Auto> listaAuto = new ArrayList<>();
        ArrayList<Pilota> listaPiloti = new ArrayList<>();
        /* istanza degli oggetti da utilizzare */
        Scanner keyboard = new Scanner(System.in);

        do{
            scelta = menu(opzioni, keyboard);
            try{
                switch (scelta){
                    /* INSERISCI PILOTA */
                    case 1 -> {
                        pilotaInput = FrontScreen.leggiPilota(keyboard, false);
                        if(listaPiloti.contains(pilotaInput))
                            throw new Exception("Pilota già inserito");

                        listaPiloti.add(pilotaInput);
                    }
                    /* INSERISCI AUTO */
                    case 2 -> {
                        autoInput = FrontScreen.leggiAuto(keyboard, listaPiloti);
                        if(listaAuto.contains(autoInput))
                            throw new Exception("Auto già inserita");

                        listaAuto.add(autoInput);
                    }
                    /* VISUALIZZA PILOTI */
                    case 3 -> {
                        if(listaPiloti.isEmpty())
                            throw new Exception("Nessun pilota inserito");

                        listaPiloti.forEach(x -> System.out.println(x.toString()));
                    }
                    /* VISUALIZZA AUTO */
                    case 4 -> {
                        if(listaAuto.isEmpty())
                            throw new Exception("Nessuna auto inserita");

                        listaAuto.forEach(x -> System.out.println(x.toString()));
                    }
                    /* INIZIO MISURAZIONE AUTO */
                    case 5 -> {
                        if(listaAuto.isEmpty()) //controllo se la lista esiste
                            throw new Exception("Nessuna auto inserita");
                        autoInput = FrontScreen.leggiAuto(keyboard, listaPiloti);
                        if(!listaAuto.contains(autoInput)) //controllo se l'auto esiste
                            throw new Exception("Auto non trovata");

                        /* se l'auto è stata trovata avvio il cronometro */
                        listaAuto.get(listaAuto.indexOf(autoInput)).avviaCronometro();
                    }
                    /* FINE MISURAZIONE AUTO */
                    case 6 -> {
                        if(listaAuto.isEmpty()) //controllo se la lista esiste
                            throw new Exception("Nessuna auto inserita");
                        autoInput = FrontScreen.leggiAuto(keyboard, listaPiloti);
                        if(!listaAuto.contains(autoInput)) //controllo se l'auto esiste
                            throw new Exception("Auto non trovata");

                        /* se l'auto è stata trovata avvio il cronometro */
                        listaAuto.get(listaAuto.indexOf(autoInput)).finisciCronometro();
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                Wait(3);
            }
        }while(scelta != opzioni.length-1);
    }
}
