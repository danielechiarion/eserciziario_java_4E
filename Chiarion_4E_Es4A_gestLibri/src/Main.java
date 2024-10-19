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
                            "Cerca libri con lo stesso titolo",
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
                        libroInput = FrontEnd.leggiLibro(keyboard, true, libreria);
                        if(Libreria.searchBook(libreria, libroInput)<0)
                            insertElementArray(libreria, libroInput);
                        else
                            System.out.println("Libro già esistente");
                    }catch(ArrayIndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                        Wait(3);
                    }
                    break;
                case 2:
                    try{
                        Libreria.mensolaVuota(libreria);
                        FrontEnd.printBookList(libreria);
                        Wait(5);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        Wait(5);
                    }
                    break;
                case 3:
                    libroInput = FrontEnd.inputDatiRicerca(1, keyboard);
                    posizione = Libreria.searchBook(libreria, libroInput);
                    if(posizione>0){
                        int numPagine = FrontEnd.inputNumPagine(keyboard);
                        libreria[posizione].numPagine = numPagine;
                    }
                    break;
                case 4:
                    libroInput = FrontEnd.inputDatiRicerca(1, keyboard);
                    posizione = Libreria.searchBook(libreria, libroInput);
                    if(posizione>0)
                        Libreria.rimuoviLibro(libreria, posizione);
                    else
                        System.out.println("Libro non trovato");
                    break;
                case 5:
                    libroInput = FrontEnd.inputDatiRicerca(2, keyboard);
                    Libreria.visualizzaLibroAutore(libreria, libroInput.autore);
                    Wait(5);
                    break;
                case 6:
                    try{
                        libroInput = FrontEnd.inputDatiRicerca(3, keyboard);
                        FrontEnd.printBookList(Libreria.findAll(libreria, libroInput));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    Wait(5);
                    break;
                default:
                    System.out.println("Uscita programma");
                    Wait(3);
            }
        }while(scelta!=opzioni.length-1);
    }
}