package frontScreen;

import mensola.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static utility.Tools.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrontEnd {
    public static Libro LeggiLibro(ArrayList<Libro> libreria, Scanner keyboard) {
        Libro output = new Libro();
        boolean trovato, dataAcc;

        do{
            output = inputDatiRicerca(1, keyboard);
            if(libreria.contains(output))
                System.out.println("Libro già inserito");
        }while(libreria.contains(output));
        //Inserire numero di pagine
        output.numeroPagine = inserisciNumPagine(keyboard);
        //Inserimento tipologia
        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Inserire Genere";
        for (int i = 0; i < generi.length; i++)
            menuData[i + 1] = generi[i].toString();
        int genereIndex = Menu(menuData, keyboard) - 1;
        output.tipologia = generi[genereIndex];
        //Inserimento data
        do {
            dataAcc = true;
            System.out.println("Inserire data nel formato dd/MM/yyyy: ");
            String dataInput = keyboard.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                output.dataPubblicazione = LocalDate.parse(dataInput, formatter);
            } catch (Exception e) {
                System.out.println("La data non rispetta la formattazione corretta");
                dataAcc = false;
            }
        } while (!dataAcc);

        return output;
    }


    public static void visualizzaLibri(ArrayList<Libro> libreria)throws Exception {
        if (libreria.isEmpty())
            throw new Exception("Nessun risultato trovato");

        libreria.forEach(x -> System.out.println(x.toString()));
    }

    /* metodo che prevede i dati essenziali per l'input
     * della ricerca di un libro.
     * Vengono quindi chiesti autore e titolo, quest'ultimo se necessario */
    public static Libro inputDatiRicerca(int metodoRicerca, Scanner scanner){
        Libro libro = new Libro();

        if(metodoRicerca==2 || metodoRicerca==1){
            System.out.println("Inserisci autore:");
            libro.autore = scanner.nextLine();
        }
        if(metodoRicerca==3 || metodoRicerca==1){
            System.out.println("Inserisci titolo:");
            libro.titolo = scanner.nextLine();
        }

        return libro;
    }

    /* metodo che fa l'input delle pagine
    * da inserire, utilizzando il try-catch */
    public static int inserisciNumPagine(Scanner scanner){
        boolean check;
        int numPagine=0;
        do{
            check = true;
            try{
                System.out.println("Inserisci numero pagine");
                numPagine = Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Dominio errato");
                check = false;
            }

            if(check && numPagine<=0){
                System.out.println("Intervallo non valido");
                check = false;
            }
        }while(!check);

        return numPagine;
    }
}
