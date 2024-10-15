package frontScreen;

import mensola.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utility.Tools.*;
import java.time.LocalDate;

public class FrontEnd {
    public static Libro leggiLibro(Scanner scanner, boolean noRepetitionMode, Libro[] array){
        Libro libro = new Libro();
        int result, scelta;
        boolean repeat;

        /* inserimento dati */
        do{
            System.out.println("Inserisci autore: ");
            libro.autore = scanner.nextLine();
            System.out.println("Inserisci titolo: ");
            libro.titolo = scanner.nextLine();

            result = Libreria.searchBook(array, libro.autore, libro.titolo);

            if(noRepetitionMode && result>=0)
                System.out.println("Libro già esistente");
        }while(noRepetitionMode && result>=0);
        do{
            try{
                repeat = false;
                System.out.println("Inserisci numero pagine: ");
                libro.numPagine = Integer.parseInt(scanner.nextLine());
                if(libro.numPagine<=0)
                    System.out.println("Non puoi inserire numero negativo");
            }catch(Exception e){
                System.out.println("Input non appartiene al dominio degli interi");
                repeat = true;
            }
        }while(repeat);

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
        for(Libro libro : array)
            System.out.println(libro.toString());
    }
}