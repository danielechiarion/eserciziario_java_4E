import FrontEnd.*;

import static utility.Tools.*;

import biglietti.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione costanti */
        final int MAXPERSONE = 10;
        /* dichiarazione variabili */
        int scelta;
        /* istanza oggetti per il funzionamento del programma */
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Biglietto> listaBiglietti = new ArrayList<>();
        int contaPersone = 0;
        Biglietto bigliettoInput;
        /* creo le varie opzioni che un utente può inserire */
        String[] opzioni = {
                "LUNA PARK",
                "Crea biglietto",
                "Uscita persona",
                "Visualizza biglietti",
                "Cerca biglietto",
                "Accesso alla giostra",
                "Fine"
        };

        do {
            scelta = menu(opzioni, keyboard);
            try {
                switch (scelta) {
                    case 1 -> {
                        if (contaPersone >= MAXPERSONE)
                            throw new Exception("Raggiunto il numero massimo di persone");

                        listaBiglietti.add(new Biglietto()); //creo il nuovo biglietto
                        System.out.println(listaBiglietti.getLast().toString()); //stampo il biglietto
                        contaPersone++; //aumento il contatore di persone
                        Wait(3);
                    }
                    case 2 -> {
                        bigliettoInput = Input.inserisciNumeroBiglietto(keyboard);
                        if (!listaBiglietti.contains(bigliettoInput))
                            throw new Exception("Biglietto non trovato");

                        listaBiglietti.get(listaBiglietti.indexOf(bigliettoInput)).esciLunaPark();
                        contaPersone--;
                    }
                    case 3 -> {
                        if (listaBiglietti.isEmpty())
                            throw new Exception("Nessun biglietto creato");

                        System.out.println("BIGLIETTI CREATI");
                        listaBiglietti.forEach(x -> System.out.println(x.toString() + "\n")); //per ogni biglietto stampo il risultato
                        Wait(5);
                    }
                    case 4 -> {
                        bigliettoInput = Input.inserisciNumeroBiglietto(keyboard);
                        if(!listaBiglietti.contains(bigliettoInput))
                            throw new Exception("Biglietto non trovato");

                        /* stampo il biglietto trovato */
                        System.out.println(listaBiglietti.get(listaBiglietti.indexOf(bigliettoInput)).toString());
                        Wait(5);
                    }
                    case 5 -> {
                        bigliettoInput = Input.inserisciNumeroBiglietto(keyboard);
                        if(!listaBiglietti.contains(bigliettoInput))
                            throw new Exception("Biglietto non trovato");

                        /* aggiungo la giostra al biglietto trovato */
                        listaBiglietti.get(listaBiglietti.indexOf(bigliettoInput)).aggiungiGiostra(Input.inserisciGiostra(keyboard));
                    }
                    default -> {
                        System.out.println("Fine programma");
                        Wait(3);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Wait(3);
            }
        } while (scelta != opzioni.length - 1);
    }
}
