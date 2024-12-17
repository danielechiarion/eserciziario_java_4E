import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

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
                "Assegna punti",
                "Dettagli gara in corso",
                "Cambia gara",
                "Fine"
        };
        /* dichiarazione variabili */
        int scelta;
        Pilota pilotaInput;
        Auto autoInput, autoScelta;
        /* istanza delle liste da utilizzare */
        ArrayList<Auto> listaAuto = new ArrayList<>();
        ArrayList<Pilota> listaPiloti = new ArrayList<>();
        ArrayList<Gara> listaGare = new ArrayList<>();
        /* istanza degli oggetti da utilizzare */
        Scanner keyboard = new Scanner(System.in);

        try{
            FrontScreen.leggiGara(listaGare, keyboard);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

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
                        if(!listaAuto.contains(autoInput)){
                            listaAuto.add(autoInput);
                            listaGare.getLast().aggiungiAuto(listaAuto.getLast());
                        }else{
                            listaGare.getLast().aggiungiAuto(listaAuto.get(listaAuto.indexOf(autoInput)));
                        }
                    }
                    /* VISUALIZZA PILOTI */
                    case 3 -> {
                        if(listaPiloti.isEmpty())
                            throw new Exception("Nessun pilota inserito");
                        listaPiloti.forEach(x -> System.out.println(x.toString())); //visualizzo le auto
                    }
                    /* VISUALIZZA CLASSIFICA */
                    case 4 -> {
                        if(listaGare.getLast().getListaAuto().isEmpty())
                            throw new Exception("Nessuna auto inserita");

                        printArrayStringValues(listaGare.getLast().toArrayStringClassifica());
                    }
                    /* INIZIO MISURAZIONE AUTO */
                    case 5 -> {
                        if(listaGare.getLast().getListaAuto().isEmpty()) //controllo se la lista esiste
                            throw new Exception("Nessuna auto inserita");
                        autoInput = FrontScreen.leggiAuto(keyboard, listaPiloti);
                        if(!listaGare.getLast().getListaAuto().contains(autoInput)) //controllo se l'auto esiste
                            throw new Exception("Auto non trovata");

                        /* ottengo l'auto e controllo se la misurazione
                        * è già stata avviata */
                        autoScelta = listaGare.getLast().getListaAuto().get(listaGare.getLast().getListaAuto().indexOf(autoInput));
                        if(autoScelta.getCronometro() != null && autoScelta.getCronometro().timingStatus()>=0)
                            throw new Exception("Auto già partita");
                        /* se l'auto è stata trovata avvio il cronometro */
                        autoScelta.avviaCronometro();
                    }
                    /* FINE MISURAZIONE AUTO */
                    case 6 -> {
                        if(listaGare.getLast().getListaAuto().isEmpty()) //controllo se la lista esiste
                            throw new Exception("Nessuna auto inserita");
                        autoInput = FrontScreen.leggiAuto(keyboard, listaPiloti);
                        if(!listaGare.getLast().getListaAuto().contains(autoInput)) //controllo se l'auto esiste
                            throw new Exception("Auto non trovata");

                        /* ottengo l'auto e controllo se la misurazione
                        * è già stata avviata o se la macchina ha già passato il traguardo */
                        autoScelta = listaGare.getLast().getListaAuto().get(listaGare.getLast().getListaAuto().indexOf(autoInput));
                        if(autoScelta.getCronometro().timingStatus()<0)
                            throw new Exception("Auto non partita");
                        if(autoScelta.getCronometro().timingStatus()>0)
                            throw new Exception("Tempo sul giro già effettuato");

                        /* se l'auto è stata trovata avvio il cronometro */
                        listaAuto.get(listaAuto.indexOf(autoInput)).finisciCronometro();
                    }
                    /* ASSEGNAZIONE PUNTI */
                    case 7 -> {
                        listaGare.getLast().assegnaPunteggio();
                    }
                    /* INFORMAZIONI GARA IN CORSO */
                    case 8 -> {
                        System.out.println(listaGare.getLast().toString());
                        Wait(3);
                    }
                    case 9 -> {
                        listaGare.getLast().terminaGara(); //termino l'ultima gara
                        listaAuto.forEach(x -> x.setCronometro(null)); //riazzero i cronometri
                        FrontScreen.leggiGara(listaGare, keyboard); //aggiungo la nuova gara
                    }
                    default -> {
                        System.out.println("Fine programma");
                        Wait(3);
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                Wait(3);
            }
        }while(scelta != opzioni.length-1);
    }
}
