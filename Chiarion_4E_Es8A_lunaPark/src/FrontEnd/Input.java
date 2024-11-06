package FrontEnd;

import java.util.Scanner;

import static utility.Tools.*;

import biglietti.*;

public class Input {
    public static AccessoGiostra inserisciGiostra(Scanner keyboard) {
        /* dichiarazione variabili */
        int numGiri = 0;
        TipoGiostra tipoGiostra;

        /* richiedo l'inserimento del tipo giostra utilizzando il menu */
        tipoGiostra = TipoGiostra.fromNome(TipoGiostra.getArrayStringTipoGiostra()[menu(TipoGiostra.getArrayStringTipoGiostra(), keyboard)]);

        /* richiedo l'inserimento dei giri in giostra,
         * controllando eventuali errori di dominio o
         * possibili valori errati (negativi) */
        boolean check;
        do {
            check = false;
            try {
                System.out.println("Inserisci il numero di giri in giostra: ");
                numGiri = Integer.parseInt(keyboard.nextLine());
                if (numGiri <= 0) { //controllo se il numero è corretto
                    throw new Exception("Devi inserire un numero di giri per forza positivo");
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio. Non hai inserito un numero");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return new AccessoGiostra(tipoGiostra, numGiri);
    }

    public static Biglietto inserisciNumeroBiglietto(Scanner keyboard) {
        boolean check;
        int numBiglietto = 0;
        do {
            check = false;
            try {
                System.out.println("Inserisci il numero del biglietto: ");
                numBiglietto = Integer.parseInt(keyboard.nextLine());
                if (numBiglietto <= 0) { //controllo se il numero è corretto
                    throw new Exception("Devi inserire un numero per forza positivo");
                }
            } catch (NumberFormatException e) { //gestisco l'eccezione per controllare se non è un numero
                System.out.println("Errore di dominio. Non hai inserito un numero");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return new Biglietto(numBiglietto);
    }
}
