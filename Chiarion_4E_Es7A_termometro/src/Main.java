import gestPazienti.*;
import static utility.Tools.*;
import Frontend.*;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta;
        /* istanzio lo scanner e l'arrayList
        * di pazienti */
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Paziente> listaPazienti = new ArrayList<>();
        /* creo l'array di stringhe con tutte
        * le opzioni disponibili */
        String[] opzioni = {
                "GESTIONE CLINICA",
                "Aggiungi paziente",
                "Rimuovi paziente",
                "Visualizza lista pazienti",
                "Cerca paziente",
                "Effettua misurazione paziente",
                "Rimuovi misurazioni paziente",
                "Dimetti paziente",
                "Fine"
        };
        /* dichiarazione oggetti utilizzati nel menu */
        Paziente pazienteInput;

        do{
            scelta=Menu(opzioni, keyboard);
            switch(scelta){
                /* INSERIMENTO PAZIENTE */
                case 1:
                    try{
                        inserisciPaziente(listaPazienti, keyboard);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                /* RIMOZIONE PAZIENTE */
                case 2:
                    try{
                        listaPazienti.remove(ricercaPaziente(listaPazienti, keyboard));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                /* VISUALIZZAZIONE DI TUTTI I PAZIENTI */
                case 3:
                    try{
                        visualizzaPazienti(listaPazienti);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    Wait(5);
                    break;
                /* RICERCA DI UN PAZIENTE */
                case 4:
                    try{
                        System.out.println(listaPazienti.get(ricercaPaziente(listaPazienti, keyboard)).toString(true));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    Wait(5);
                    break;
                /* MISURAZIONE TEMPERATURA PAZIENTE */
                case 5:
                    try{
                        listaPazienti.get(ricercaPaziente(listaPazienti, keyboard)).addMisurazione();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                /* RIMOZIONI MISURAZIONI TEMPERATURA
                * che rispettano un certo intervallo di tempo */
                case 6:
                    try{
                        rimuoviMisurazioniPaziente(listaPazienti, keyboard);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                /* DIMISSIONI PAZIENTE */
                case 7:
                    try{
                        listaPazienti.get(ricercaPaziente(listaPazienti, keyboard)).dimettiPaziente();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                default:
                    System.out.println("Fine programma");
                    Wait(3);
            }
        }while(scelta!=opzioni.length-1);
    }

    /* metodo per l'inserimento di un paziente */
    public static void inserisciPaziente(ArrayList<Paziente> listaPazienti, Scanner scanner)throws Exception{
        Paziente paziente = FrontScreen.leggiPaziente(scanner, false);
        if(listaPazienti.contains(paziente))
            throw new Exception("Paziente già presente");
        listaPazienti.add(paziente);
    }

    /* metodo per la ricerca di un paziente */
    public static int ricercaPaziente(ArrayList<Paziente> listaPazienti, Scanner scanner)throws Exception{
        Paziente paziente = FrontScreen.leggiPaziente(scanner, true);

        if(!listaPazienti.contains(paziente))
            throw new Exception("Paziente non trovato");

        return listaPazienti.indexOf(paziente);
    }

    /* metodo per la visualizzazione di tutti i
    * pazienti all'interno della clinica */
    public static void visualizzaPazienti(ArrayList<Paziente> listaPazienti)throws Exception{
        if(listaPazienti.isEmpty())
            throw new Exception("Nessun paziente registrato");

        for(Paziente paziente : listaPazienti)
            System.out.println(paziente.toString(false)); //fornisco solo le informazioni di base del paziente
    }

    /* metodo per la rimozione delle misure effettuate
    * di un paziente */
    public static void rimuoviMisurazioniPaziente(ArrayList<Paziente> listaPazienti, Scanner scanner)throws Exception{
        int indexPaziente = ricercaPaziente(listaPazienti, scanner); //trovo indice paziente

        /* se non viene lanciata un'eccezione, chiedo
        * l'inserimento dell'intervallo di date di cui si desidera eliminare
        * le misurazioni */
        LocalDateTime primaData;
        LocalDateTime secondaData;
        do{
            System.out.println("PRIMA DATA");
            primaData = FrontScreen.inputData(scanner);
            System.out.println("SECONDA DATA");
            secondaData = FrontScreen.inputData(scanner);
            if(!primaData.isBefore(secondaData)){
                System.out.println("La prima data deve essere antecedente alla seconda");
                Wait(4);
                clrScr();
            }
        }while(!primaData.isBefore(secondaData));

        /* rimuovo le misurazioni seguendo la data indicata */
        listaPazienti.get(indexPaziente).removeMisurazioni(primaData, secondaData);
    }
}
