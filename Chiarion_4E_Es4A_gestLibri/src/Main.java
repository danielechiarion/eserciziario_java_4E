import static utility.Tools.*;
import static utility.Array.*;
import frontScreen.*;
import mensola.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        int scelta=0;
        /* dichiarazione costanti */
        final int dimensioneLibreria = 3;
        /* istanza vettori */
        String[] opzioni = {"OPZIONI POSSIBILI",
                            "Inserimento libro",
                            "Visualizza",
                            "Cambia numero pagine",
                            "Rimuovi libro",
                            "Cerca libri dello stesso autore",
                            "Fine"};
        Libro[] libreria = new Libro[dimensioneLibreria];
        /* creazione oggetti */
        Scanner keyboard = new Scanner(System.in);
        /* creazione variabili input dati */
        Libro libroInput;
        int posizione;

        /* ripeto ogni volta il ciclo */
        do{
            scelta = menu(opzioni, keyboard);
            switch(scelta){
                case 1:
                    try{
                        insertElementArray(libreria, FrontEnd.leggiLibro(keyboard, true, libreria));
                    }catch(ArrayIndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                case 2:
                    FrontEnd.printBookList(libreria);
                    break;
                case 3:
                    libroInput = FrontEnd.inputDatiRicerca(false, keyboard);
                    posizione = Libreria.searchBook(libreria, libroInput.autore, libroInput.titolo);
                    if(posizione<0){
                        System.out.println("Libro non trovato");
                        Wait(3);
                    }
                    else{
                        int numPagine = FrontEnd.inputNumPagine(keyboard);
                        libreria[posizione].numPagine = numPagine;
                    }
                    break;
                case 4:
                    libroInput = FrontEnd.inputDatiRicerca(false, keyboard);
                    posizione = Libreria.searchBook(libreria, libroInput.autore, libroInput.titolo);
                    if(posizione<0){
                        System.out.println("Libro non trovato");
                        Wait(3);
                    }
                    else{
                        Libreria.rimuoviLibro(libreria, posizione);
                    }
                    break;
                case 5:
                    libroInput = FrontEnd.inputDatiRicerca(true, keyboard);
                    Libreria.visualizzaLibroAutore(libreria, libroInput.autore);
                    Wait(5);
                    break;
                default:
                    System.out.println("Uscita programma");
                    Wait(3);
            }
        }while(scelta!=opzioni.length-1);
    }
}