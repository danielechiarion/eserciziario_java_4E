package frontend;

import java.awt.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListSet;

import veicoli.*;
import edifici.*;

public class Frontscreen {
    public static int safeIntInput(Scanner scanner) {
        int value = 0;
        boolean check;

        do {
            check = false;
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return value;
    }

    public static double safeDoubleInput(Scanner scanner) {
        double value = 0;
        boolean check;

        do {
            check = false;
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return value;
    }

    public static Auto inputAuto(Scanner scanner)throws Exception{
        /* dichiarazione variabili per l'inserimento dati */
        String marca, modello, alimentazione;
        int cavalli, annoImmatricolazione;
        double prezzo, tara;
        int scelta;

        /* opzioni di auto possibili */
        String[] opzioni = {
                "SCEGLI IL VEICOLO",
                "Auto",
                "Auto carro"
        };

        scelta = Tools.Menu(opzioni, scanner); //chiedo l'inserimento del tipo di veicolo, che servirà nell'inserimento degli ultimi dati

        System.out.println("Inserisci la marca: ");
        marca = scanner.nextLine();
        System.out.println("Inserisci il modello: ");
        modello = scanner.nextLine();
        do{
            System.out.println("Inserisci l'anno di immatricolazione: ");
            annoImmatricolazione = safeIntInput(scanner);
            if(annoImmatricolazione<1850 || annoImmatricolazione>LocalDate.now().getYear())
                System.out.println("Anno inserito non valido");
        }while(annoImmatricolazione<1850 || annoImmatricolazione>LocalDate.now().getYear());
        System.out.println("Inserisci il prezzo: ");
        prezzo = safeDoubleInput(scanner);

        if(scelta == 1){
            System.out.println("Inserisci l'alimentazione: ");
            alimentazione = scanner.nextLine();
            System.out.println("Inserisci la potenza in cavalli: ");
            cavalli = safeIntInput(scanner);

            return new AutoNuova(marca, modello, prezzo, annoImmatricolazione, alimentazione, cavalli);
        }else if(scelta == 2){
            System.out.println("Inserisci la tara (in quintali): ");
            tara = safeDoubleInput(scanner);

            return new AutoCarro(marca, modello, prezzo, annoImmatricolazione, tara);
        }else
            return null;
    }

    private static Auto inputRicercaID(Scanner scanner){
        System.out.println("Inserisci ID del veicolo: ");
        int id = safeIntInput(scanner);

        return new AutoRicerca(id, false);
    }

    private static String inputRicercaMarca(Scanner scanner){
        System.out.println("Inserisci la marca: ");
        return scanner.nextLine();
    }

    private static int inputRicercaImmatricolazione(Scanner scanner){
        int annoImmatricolazione;

        do{
            System.out.println("Inserisci l'anno di immatricolazione: ");
            annoImmatricolazione = safeIntInput(scanner);
            if(annoImmatricolazione<1850 || annoImmatricolazione>LocalDate.now().getYear())
                System.out.println("Anno inserito non valido");
        }while(annoImmatricolazione<1850 || annoImmatricolazione>LocalDate.now().getYear());

        return annoImmatricolazione;
    }

    public static void aggiungiAuto(Concessionario concessionario, Scanner scanner)throws Exception{
        concessionario.aggiungiAuto(inputAuto(scanner));
    }

    public static void rimuoviAuto(Concessionario concessionario, Scanner scanner)throws Exception{
        String conferma;
        Auto input = inputRicercaID(scanner);

        System.out.println("Sei sicuro di voler eliminare quest'auto? Digita SI per confermare");
        conferma = scanner.nextLine();

        if(conferma.equalsIgnoreCase("SI")){
            concessionario.rimuoviAuto(input);
        }
    }

    public static void cambiaCaratteristicheVeicolo(Concessionario concessionario, Scanner scanner)throws Exception{
        /* dichiarazione variabili possibili valori da cambiare */
        double prezzo, tara;
        String alimentazione;
        int cavalli;

        int index = concessionario.indexOf(inputRicercaID(scanner));
        Auto autoInput = concessionario.getAuto(index);

        System.out.println("Inserisci il nuovo prezzo del veicolo (numero negativo per annullare): ");
        prezzo = Double.parseDouble(scanner.nextLine());
        if(prezzo>0)
            autoInput.setPrezzo(prezzo);

        if(autoInput instanceof AutoNuova){
            System.out.println("Cambia alimentazione (premi INVIO per saltare): ");
            alimentazione = scanner.nextLine();
            System.out.println("Cambia la potenza in cavalli (numero negativo per annullare): ");
            cavalli = Integer.parseInt(scanner.nextLine());

            if(!alimentazione.isBlank())
                ((AutoNuova) autoInput).setAlimentazione(alimentazione);
            if(cavalli>0)
                ((AutoNuova) autoInput).setCavalli(cavalli);
        }else if(autoInput instanceof AutoCarro){
            System.out.println("Cambia tara (numero negativo per annullare): ");
            tara = safeDoubleInput(scanner);

            if(tara>0)
                ((AutoCarro) autoInput).setTara(tara);
        }

        concessionario.cambiaAuto(index, autoInput);
    }

    public static void ricercaPerMarca(Concessionario concessionario, Scanner scanner){
        String marca = inputRicercaMarca(scanner);

        /* ritorno i risultati della ricerca */
        System.out.println("RICERCA PER MARCA: ");
        concessionario.ricerca(marca).forEach(x -> System.out.println(x.mostraDettagli()));
    }

    public static void ricercaPerImmatricolazione(Concessionario concessionario, Scanner scanner){
        int annoImmatricolazione = inputRicercaImmatricolazione(scanner);

        /* ritorno i risultati della ricerca */
        System.out.println("RICERCA PER ANNO IMMATRICOLAZIONE: ");
        concessionario.ricerca(annoImmatricolazione).forEach(x -> System.out.println(x.mostraDettagli()));
    }

    public static void visualizzaVeicoli(Concessionario concessionario){
        System.out.println("VEICOLI REGISTRATI");
        concessionario.getShowRoom().forEach(x -> System.out.println(x.mostraDettagli()));
    }

    public static void prezzoAttualeVeicolo(Concessionario concessionario, Scanner scanner)throws Exception{
        Auto autoInput = concessionario.getAuto(concessionario.indexOf(inputRicercaID(scanner)));

        System.out.println(autoInput.mostraDettagli());
        System.out.printf("Valore attuale: %.2f€\n", autoInput.valoreAttuale());
    }
}
