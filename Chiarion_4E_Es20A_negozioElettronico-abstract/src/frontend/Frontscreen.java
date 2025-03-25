package frontend;

import java.util.Scanner;

import backend.*;

public class Frontscreen {
    public static int safeIntInput(Scanner scanner) {
        int value = 0;
        boolean check;

        do {
            check = false;
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return value;
    }

    public static double safeDoubleInput(Scanner scanner) {
        double value = 0;
        boolean check;

        do {
            check = false;
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return value;
    }

    /* inserimento del prodotto elettronico */
    public static ProdottoElettronico inputProdotto(Scanner scanner) throws Exception {
        /* definisco il tipo di dispositivi da inserire */
        String[] opzioniDispositivi = {
                "DISPOSITIVI DISPONIBILI",
                "Smartphone",
                "PC"
        };

        /* dichiarazione variabili */
        int sceltaDispositivo;
        int memoria, hardDisk;
        double prezzo;
        String modello, marca, codiceProdotto, processore;

        /* chiedo la scelta del dispositivo */
        sceltaDispositivo = Tools.Menu(opzioniDispositivi, scanner);

        /* richiedo l'inserimento dei dati generali
         * di un prodotto */
        System.out.println("Inserisci il codice del prodotto: ");
        codiceProdotto = scanner.nextLine();
        System.out.println("Inserisci la marca: ");
        marca = scanner.nextLine();
        System.out.println("Inserisci il prezzo del prodotto: ");
        prezzo = safeDoubleInput(scanner);

        if (sceltaDispositivo == 1) {
            /* inserimento dati specifici dello smartphone */
            System.out.println("Inserisci il modello dello smartphone: ");
            modello = scanner.nextLine();
            System.out.println("Inserisci la memoria dello smartphone: ");
            memoria = safeIntInput(scanner);

            return new Smartphone(codiceProdotto, prezzo, marca, modello, memoria); //ritorna il nuovo smartphone
        } else {
            /* inserimento dati di un PC */
            System.out.println("Inserisci il modello del processore: ");
            processore = scanner.nextLine();
            System.out.println("Inserisci la memoria dell'hard disk in GB: ");
            hardDisk = safeIntInput(scanner);

            return new PC(codiceProdotto, prezzo, marca, processore, hardDisk); //ritorno il nuovo PC
        }
    }

    /* input di un prodotto solo per la ricerca */
    public static ProdottoElettronico inputProdottoRicerca(Scanner scanner) {
        String codiceProdotto;

        /* richiedo l'inserimento dei dati generali
         * di un prodotto. Nella ricerca mi interessa solo il codice prodotto */
        System.out.println("Inserisci il codice del prodotto: ");
        codiceProdotto = scanner.nextLine();

        return new ProdottoElettronicoGenerico(codiceProdotto);
    }

    public static void inserisciProdotto(Scanner scanner, GestoreNegozio negozio) throws Exception {
        ProdottoElettronico prodottoInput = inputProdotto(scanner);

        /* controllo se il prodotto è già esistente.
         * In tal caso lancio un'eccezione */
        if (negozio.prodottoExists(prodottoInput))
            throw new Exception("Prodotto già inserito");

        negozio.aggiungiProdotto(prodottoInput);
    }

    public static int ricercaProdotto(Scanner scanner, GestoreNegozio negozio) throws Exception {
        ProdottoElettronico prodottoInput = inputProdottoRicerca(scanner);

        /* se non è presente il prodotto lancio un'eccezione */
        if (negozio.prodottoExists(prodottoInput))
            throw new Exception("Prodotto non trovato");

        int index = negozio.indexProdotto(prodottoInput); //salvo l'indice perchè poi lo ritorno
        System.out.println(negozio.getNomeNegozio().toString());

        return index;
    }

    public static void rimuoviProdotto(Scanner scanner, GestoreNegozio negozio) throws Exception {
        /* dichiarazione variabili e oggetti */
        int index;
        String conferma;

        index = ricercaProdotto(scanner, negozio); //mi salvo il risultato della ricerca

        /* chiedo all'utente di confermare */
        System.out.println("Vuoi confermare l'operazione? Digita SI / qualsiasi altro input per annullare");
        conferma = scanner.nextLine();

        /* se l'input è SI rimuovo */
        if (conferma.equals("SI")) {
            negozio.rimuoviProdotto(index);
            System.out.println("Prodotto rimosso con successo");
            Tools.Wait(3);
        }
    }

    public static void cambiaPrezzoProdotto(Scanner scanner, GestoreNegozio negozio) throws Exception {
        /* dichiarazione variabili e oggetti */
        double nuovoPrezzo;
        int index;

        /* effetto la ricerca del prodotto */
        index = ricercaProdotto(scanner, negozio);

        /* chiedo l'inserimento del nuovo prezzo e lo modifico */
        System.out.println("Inserisci il nuovo prezzo del prodotto: ");
        nuovoPrezzo = safeDoubleInput(scanner);
        negozio.cambiaPrezzo(index, nuovoPrezzo);
    }

    public static void visualizzaProdotti(GestoreNegozio negozio) throws Exception {
        if (negozio.getProdotti().isEmpty())
            throw new Exception("Nessun prodotto inserito");

        System.out.println("PRODOTTI INSERITI");
        negozio.getProdotti().forEach(x -> System.out.println(x.toString()));
    }
}
