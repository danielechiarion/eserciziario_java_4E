import static frontScreen.FrontEnd.*;
import static utility.Tools.*;

import mensola.*;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int MAX_LIBRI = 2;
        final String[] elenco = {
                "Libreria",
                "Inserisci Libro",
                "Visualizza tutti i libri inseriti",
                "Modifica pagine libro",
                "Cancella libro",
                "Visualizza libri di un autore",
                "Esci"
        };
        ArrayList<Libro> libreria = new ArrayList<>(MAX_LIBRI); //dichiaro l'arraylist con una dimensione iniziale
        boolean fine = true, spazio;

        do {
            switch (Menu(elenco, keyboard)) {
                case 1:
                    try{
                        inserimentoLibro(libreria, LeggiLibro(libreria, keyboard), MAX_LIBRI);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                       visualizzaLibri(libreria);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    Wait(5);
                    break;
                case 3:
                    try{
                        modificaPagineLibro(libreria, keyboard);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try{
                        libreria.remove(libreria.indexOf(inputDatiRicerca(1, keyboard)));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        visualizzaLibriSimili(libreria, inputDatiRicerca(2,keyboard));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    Wait(5);
                    break;
                default:
                    fine = false;
                    System.out.println("Fine programma");
                    Wait(3);
            }
        } while (fine);
    }

    private static void inserimentoLibro(ArrayList<Libro> listaLibri, Libro libro, int nMaxLibri)throws Exception{
        /* prima controllo se la libreria è già piena */
        if(listaLibri.size() == nMaxLibri)
            throw new Exception("Libreria piena");

        listaLibri.add(libro); //se ha passato i controlli, aggiungo il libro
    }

    private static void modificaPagineLibro(ArrayList<Libro> libreria, Scanner scanner)throws Exception{
        int index = libreria.indexOf(inputDatiRicerca(1, scanner));

        if(index<0)
            throw new Exception("Libro non trovato");

        libreria.get(index).numeroPagine = inserisciNumPagine(scanner);
    }

    private static void visualizzaLibriSimili(ArrayList<Libro> libreria, Libro libro)throws Exception{
        if(!libreria.contains(libro))
            throw new Exception("Nessun risultato trovato");

        System.out.println("*** LIBRI TROVATI ");
        for(Libro libroCorrente : libreria){
            if(libroCorrente.equals(libro))
                System.out.println(libroCorrente.toString());
        }
    }
}
