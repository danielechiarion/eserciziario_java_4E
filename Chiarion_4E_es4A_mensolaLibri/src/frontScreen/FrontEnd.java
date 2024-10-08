package frontScreen;

import mensola.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utility.Tools.*;
import java.time.LocalDate;

public class FrontEnd {
    public static Libro leggiLibro(Scanner scanner){
        Libro libro = new Libro();

        /* inserimento dati */
        System.out.println("Inserisci autore: ");
        libro.autore = scanner.nextLine();
        System.out.println("Inserisci titolo: ");
        libro.titolo = scanner.nextLine();
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
