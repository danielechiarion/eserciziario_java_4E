package FrontEnd;

import scuderia.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FrontScreen {
    /* lettura di un pilota */
    public static Pilota leggiPilota(Scanner scanner, boolean siRicerca){
        /* dichiarazione variabili per l'inserimento dati
        * di un pilota */
        String nome, cognome, nazionalita="";
        LocalDate dataNascita = null;
        boolean check;

        /* inserimento dati */
        System.out.println("Inserisci il nome:");
        nome = scanner.nextLine();
        System.out.println("Inserisci il cognome:");
        cognome = scanner.nextLine();
        do{
            check = false;
            try{
                System.out.println("Inserisci la data nel seguente formato: gg/mm/aaaa");
                dataNascita = LocalDate.parse(scanner.nextLine(), Pilota.formatoData);
            }catch (Exception e){
                System.out.println("Data inserita non valida\n");
                check = true;
            }
        }while(check);

        /* solo se non sto facendo la ricerca
        * chiedo anche la nazionalità */
        if(!siRicerca){
            System.out.println("Inserisci la nazionalita': ");
            nazionalita = scanner.nextLine();
        }

        return new Pilota(nome, cognome, nazionalita, dataNascita);
    }

    /* metodo per la lettura di un'auto */
    public static Auto leggiAuto(Scanner scanner, ArrayList<Pilota> listaPiloti)throws Exception{
        /* variabili per la creazione di un'auto */
        int cilindrata = 0;
        Pilota pilota, pilotaInput;
        String nomeScuderia;
        boolean check;

        /* leggo tutti i dati necessari */
        System.out.println("Inserisci il nome della scuderia: ");
        nomeScuderia = scanner.nextLine();
        do{
            check = false;
            try{
                System.out.println("Inserisci la cilindrata: ");
                cilindrata = Integer.parseInt(scanner.nextLine());

                if(cilindrata<=0)
                    throw new Exception("Non puoi inserire una cilindrata negativa\n");
            }catch (NumberFormatException e) {
                System.out.println("ERROR! Input Out Of Domain\n");
                check = true;
            }catch (Exception e){
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        /* eseguo la ricerca del pilota */
        pilotaInput = leggiPilota(scanner, true);
        /* controllo se il pilota esiste o meno */
        if(!listaPiloti.contains(pilotaInput))
            throw new Exception("Pilota inesistente");
        /* altrienti assegno come pilota il risultato trovato */
        pilota = listaPiloti.get(listaPiloti.indexOf(pilotaInput));

        return new Auto(nomeScuderia, cilindrata, pilota);
    }
}
