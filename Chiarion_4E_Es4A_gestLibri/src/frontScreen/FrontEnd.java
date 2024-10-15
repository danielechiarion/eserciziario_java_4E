package frontScreen;

import mensola.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utility.Tools.*;
import static utility.Array.*;
import java.time.LocalDate;

public class FrontEnd {
    public static Libro leggiLibro(Scanner scanner, boolean noRepetitionMode, Libro[] array){
        Libro libro;
        int result, scelta;
        boolean repeat;

        /* inserimento dati */
        do{
            libro = inputDatiRicerca(false, scanner);

            result = Libreria.searchBook(array, libro.autore, libro.titolo);

            if(noRepetitionMode && result>=0)
                System.out.println("Libro già esistente");
        }while(noRepetitionMode && result>=0);

        libro.numPagine = inputNumPagine(scanner); //input numero di pagine

        /* chiesto genere */
        scelta = menu(Genere.listaGenere(), scanner);
        libro.tipologia = Genere.valueOf(Genere.listaGenere()[scelta]);
        /* inserimento data */
        do{
            try{
                repeat = false;
                System.out.println("Inserisci la data nel seguente formato gg/mm/aaaa");
                String data = scanner.nextLine();
                libro.dataPubblicazione=LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }catch(Exception e){
                System.out.println("Formato data non valido");
                repeat = true;
            }
        }while(repeat);
        return libro;
    }

    /* metodo che stampa i valori del vettore in un array */
    public static void printBookList(Libro[] array){
        System.out.println("*** LIBRI INSERITI");
        for(int i=0;i<actualDimensionArray(array);i++)
            System.out.println(array[i].toString());
    }

    /* metodo che prevede i dati essenziali per l'input
    * della ricerca di un libro.
    * Vengono quindi chiesti autore e titolo, quest'ultimo se necessario */
    public static Libro inputDatiRicerca(boolean soloAutore, Scanner scanner){
        Libro libro = new Libro();

        System.out.println("Inserisci autore:");
        libro.autore = scanner.nextLine();
        if(!soloAutore){
            System.out.println("Inserisci titolo:");
            libro.titolo = scanner.nextLine();
        }

        return libro;
    }

    /* metodo che permette di inserire correttamente il numero di
    * pagine */
    public static int inputNumPagine(Scanner scanner){
        int input=0;
        boolean repeat;

        do{
            try{
                repeat = false;
                System.out.println("Inserisci numero pagine: ");
                input = Integer.parseInt(scanner.nextLine());
                if(input<=0)
                    System.out.println("Non puoi inserire numero negativo");
            }catch(Exception e){
                System.out.println("Input non appartiene al dominio degli interi");
                repeat = true;
            }
        }while(repeat);

        return input;
    }
}