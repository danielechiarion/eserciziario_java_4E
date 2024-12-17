package FrontEnd;

import java.util.Scanner;

import order.*;
import room.*;

public class Input {
    /**
     * Metodo che consente di eseguire l'input di un numero
     * intero, consentendo di omettere l'inserimento del dato
     * se si è in fase di ricerca
     * @param request testo della richiesta da porre all'utente
     * @param scanner per l'input dei dati
     * @param search se a TRUE è possibile omettere il dato, se è a FALSE è obbligatorio inserirlo
     * @return valore inserito in input, -1 se non è stato inserito alcun valore
     */
    public static int safeIntInput(String request, Scanner scanner, boolean search){
        /* dichiarazioni variabili */
        boolean check;
        int input = -1;

        do{
            check = false;
            try{
                System.out.println(request);
                String inputString = scanner.nextLine();

                if(!(inputString.isBlank() && search)){
                    input = Integer.parseInt(inputString);
                    if(input<=0)
                        throw new Exception("Non è possibile inserire un valore negativo");
                }
            }catch(NumberFormatException e){
                check=true;
                System.out.println("Input fuori dal dominio");
            }catch(Exception e){
                System.out.println(e.getMessage());
                check=true;
            }
        }while(check);

        return input;
    }

    /**
     * Metodo che consente di eseguire l'input di un double,
     * consentendo di omettere l'inserimento del dato
     * se si è in fase di ricerca
     * @param request testo della richiesta da porre all'utente
     * @param scanner per l'input dei dati
     * @param search se a TRUE è possibile omettere il dato, se è a FALSE è obbligatorio inserirlo
     * @return valore inserito in input, -1 se non è stato inserito alcun valore
     */
    public static double safeDoubleInput(String request, Scanner scanner, boolean search){
        /* dichiarazioni variabili */
        boolean check;
        double input = -1;

        do{
            check = false;
            try{
                System.out.println(request);
                String inputString = scanner.nextLine();

                if(!(inputString.isBlank() && search)){
                    input = Double.parseDouble(inputString);
                    if(input<=0)
                        throw new Exception("Non è possibile inserire un valore negativo");
                }
            }catch(NumberFormatException e){
                check=true;
                System.out.println("Input fuori dal dominio");
            }catch(Exception e){
                System.out.println(e.getMessage());
                check=true;
            }
        }while(check);

        return input;
    }

    /**
     * Metodo che legge il tavolo, sia per una modolità
     * di inserimento sia per una modalità di ricerca
     * @param scanner per l'input dei dati
     * @param search se impostato a TRUE indica che la modalità è di ricerca, false altrimenti
     * @return nuovo tavolo creato
     */
    public static Table readTable(Scanner scanner, boolean search){
        /* dichiarazione variabili */
        boolean check;
        int tableNumber, totalSeats;
        int tableNumberChoice=2; //lo metto già a 2 perchè in fase di ricerca viene inserito già il numero

        check = false;
        /* chiedo prima in quale modo generare il numero */
        if(!search)
            tableNumberChoice = twoOptionChoice("Genera automaticamente il numero", "Scegli tu il numero", scanner);

        if(tableNumberChoice == 1)
            tableNumber = Table.calculateID();
        else
            tableNumber = safeIntInput("Inserisci il numero del tavolo", scanner, search);
        /* poi chiedo il numero di posti massimo disponibili per
        * il tavolo */
        totalSeats = safeIntInput("Inserisci il numero di posti massimi per il tavolo", scanner, check);

        return new Table(tableNumber, totalSeats); //ritorno il tavolo creato
    }

    /**
     * Metodo che serve ad eseguire una scelta
     * tra sole due opzioni
     * @param firstOption testo della prima opzione
     * @param secondOption testo della seconda opzioni
     * @param scanner per l'input dei dati
     * @return 1 se viene effettuata la prima scelta, 2 per la seconda
     */
    public static int twoOptionChoice(String firstOption, String secondOption, Scanner scanner){
        /* dichiarazione variabili */
        int choice;


        /* output delle opzioni */
        System.out.println("Scegli tra le seguenti opzioni: ");
        System.out.println("[1] "+firstOption);
        System.out.println("[2] "+secondOption);
        /* controllo che l'input sia valido,
         * anche come intervallo */
        do{
            choice = safeIntInput("", scanner, true);
        }while(choice<1 || choice>2);


        /* ritorno alla fine la scelta effettuata */
        return choice;
    }
}
