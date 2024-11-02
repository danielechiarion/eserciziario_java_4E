package Frontend;

import gestPazienti.*;
import static utility.Tools.*;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FrontScreen{
    public static Paziente leggiPaziente(Scanner scanner, boolean ricerca){
        /* dichiaro le variabili forndamentali per l'inserimento
        * di un paziente */
        String nome, cognome;

        /* input dati essenziali paziente */
        System.out.println("Inserisci nome: ");
        nome = scanner.nextLine();
        System.out.println("Inserisci cognome: ");
        cognome = scanner.nextLine();

        /* ritorno subito il paziente
        * senza richiedere il reparto
        * se stiamo eseguendo una ricerca */
        if(ricerca){
            return new Paziente(nome, cognome, null);
        }

        /* altrimenti ritorno il paziente con anche
        * il reparto indicato */
        int sceltaReparto = Menu(Reparto.stampaReparto(), scanner);
        Reparto reparto = Reparto.valueOf(Reparto.stampaReparto()[sceltaReparto]);

        return new Paziente(nome, cognome, reparto); //ritorno il paziente completo
    }

    /* metodo per gestire l'input di una data */
    public static LocalDateTime inputData(Scanner scanner){
        boolean check;
        LocalDateTime data = null;

        do{
            check = true;
            try{
                System.out.println("Inserisci la data nel seguente formato -> gg/MM/aaaa HH:mm");
                data = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            }catch (Exception e){
                System.out.println("Data inserita non corretta o non rispetta il formato");
                check = false;
            }
        }while(!check);

        return data;
    }
}
