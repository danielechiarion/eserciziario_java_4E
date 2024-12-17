package FrontEnd;

import gestGara.*;
import tempo.*;

import java.util.Scanner;
import java.util.ArrayList;

public class FrontScreen {
    /* lettura di un pilota */
    public static Pilota leggiPilota(Scanner scanner, boolean siRicerca){
        /* dichiarazione variabili per l'inserimento dati
         * di un pilota */
        String nome, cognome, nazionalita="";
        boolean check;

        /* inserimento dati */
        System.out.println("Inserisci il nome:");
        nome = scanner.nextLine();
        System.out.println("Inserisci il cognome:");
        cognome = scanner.nextLine();
        /* solo se non sto facendo la ricerca
         * chiedo anche la nazionalità */
        if(!siRicerca){
            System.out.println("Inserisci la nazionalita': ");
            nazionalita = scanner.nextLine();
        }

        return new Pilota(nome, cognome, nazionalita);
    }

    /* metodo per la lettura di un'auto */
    public static Scuderia leggiScuderia(Scanner scanner, ArrayList<Pilota> listaPiloti)throws Exception{
        /* variabili per la creazione di un'auto */
        int numeroAuto = 0;
        Pilota pilota, pilotaInput;
        String nomeScuderia;
        boolean check;

        /* leggo tutti i dati necessari */
        System.out.println("Inserisci il nome della scuderia: ");
        nomeScuderia = scanner.nextLine();
        do{
            check = false;
            try{
                System.out.println("Inserisci il numero della macchina: ");
                numeroAuto = Integer.parseInt(scanner.nextLine());

                if(numeroAuto<0)
                    throw new Exception("Non puoi inserire un numero negativa\n");
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

        return new Scuderia(nomeScuderia, pilota, numeroAuto);
    }

    /* metodo per leggere una gara */
    public static void leggiGara(ArrayList<Gara> listaGare, Scanner scanner)throws Exception{
        /* dichiarazione variabili */
        String nomeCircuito, nazionalita;
        int numeroAuto = 0;
        boolean check;

        /* input dati */
        System.out.println("Inserisci il nome del circuito");
        nomeCircuito = scanner.nextLine();
        System.out.println("Inserisci il nome della nazionalità");
        nazionalita = scanner.nextLine();
        do{
            check = false;
            try{
                System.out.println("Inserisci il numero di macchine in griglia: ");
                numeroAuto = Integer.parseInt(scanner.nextLine());

                if(numeroAuto<0)
                    throw new Exception("Non puoi inserire un numero negativa\n");
            }catch (NumberFormatException e) {
                System.out.println("ERROR! Input Out Of Domain\n");
                check = true;
            }catch (Exception e){
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);


        /* creo la gara e verifico
         * che non sia già stata creata */
        Gara gara = new Gara(nomeCircuito, nazionalita, numeroAuto);
        if(listaGare.contains(gara))
            throw new Exception("Gara già inserita");
        listaGare.add(gara);
    }
}
