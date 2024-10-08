package frontScreen;

import mensola.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utility.Tools.*;
import java.time.LocalDate;

public class FrontEnd {
    public static Libro leggiLibro(Scanner scanner, boolean noRepetitionMode, Libro[] array){
        Libro libro = new Libro();
        int result;

        /* inserimento dati */
        do{
            System.out.println("Inserisci autore: ");
            libro.autore = scanner.nextLine();
            System.out.println("Inserisci titolo: ");
            libro.titolo = scanner.nextLine();

            result = Libro.searchBook(array, libro.autore, libro.titolo);

            if(noRepetitionMode && result>=0)
                System.out.println("Libro già esistente");
        }while(noRepetitionMode && result>=0);
        System.out.println("Inserisci numero pagine: ");
        libro.numPagine = Integer.parseInt(scanner.nextLine());
        /* chiesto genere */
        int scelta = menu(Genere.listaGenere(), scanner);
        libro.tipologia = Genere.valueOf(Genere.listaGenere()[scelta]);
        /* inserimento data */
        System.out.println("Inserisci la data nel seguente formato gg/mm/aaaa");
        String data = scanner.nextLine();
        libro.dataPubblicazione=LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return libro;
    }
}