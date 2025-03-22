package frontend;

import java.util.Scanner;
import java.util.ArrayList;

import backend.*;

public class Frontscreen {
    public static int safeIntInput(Scanner scanner){
        int value = 0;
        boolean check;

        do{
            check = false;
            try{
                value = Integer.parseInt(scanner.nextLine());
                if(value<=0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            }catch(NumberFormatException e){
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        return value;
    }

    public static double safeDoubleInput(Scanner scanner){
        double value = 0;
        boolean check;

        do{
            check = false;
            try{
                value = Double.parseDouble(scanner.nextLine());
                if(value<=0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            }catch(NumberFormatException e){
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        return value;
    }

    /* inserimento del prodotto elettronico */
    public static ProdottoElettronico inputProdotto(Scanner scanner)throws Exception{
        /* dichiarazione variabili */
        int memoria;
        double prezzo;
        String modello, marca, codiceProdotto;

        /* richiedo l'inserimento dei dati generali
        * di un prodotto */
        System.out.println("Inserisci il codice del prodotto: ");
        codiceProdotto = scanner.nextLine();
        System.out.println("Inserisci la marca: ");
        marca = scanner.nextLine();
        System.out.println("Inserisci il prezzo del prodotto: ");
        prezzo = safeDoubleInput(scanner);

        /* inserimento dati specifici dello smartphone.
        * Non ho condizioni da mettere perchè non ho altri tipi di prodotti */
        System.out.println("Inserisci il modello dello smartphone: ");
        modello = scanner.nextLine();
        System.out.println("Inserisci la memoria dello smartphone: ");
        memoria = safeIntInput(scanner);

        /* ora posso ritornare il prodotto */
        return new Smartphone(codiceProdotto, prezzo, marca, modello, memoria);
    }

    /* input di un prodotto solo per la ricerca */
    public static ProdottoElettronico inputProdottoRicerca(Scanner scanner){
        String codiceProdotto;

        /* richiedo l'inserimento dei dati generali
         * di un prodotto. Nella ricerca mi interessa solo il codice prodotto */
        System.out.println("Inserisci il codice del prodotto: ");
        codiceProdotto = scanner.nextLine();

        return new ProdottoElettronicoGenerico(codiceProdotto);
    }

    public static void inserisciProdotto(Scanner scanner, ArrayList<ProdottoElettronico> listaProdotti)throws Exception{
        ProdottoElettronico prodottoInput = inputProdotto(scanner);

        /* controllo se il prodotto è già esistente.
        * In tal caso lancio un'eccezione */
        if(listaProdotti.contains(prodottoInput))
            throw new Exception("Prodotto già inserito");

        listaProdotti.add(prodottoInput);
    }

    public static int ricercaProdotto(Scanner scanner, ArrayList<ProdottoElettronico> listaProdotti)throws Exception{
        ProdottoElettronico prodottoInput = inputProdottoRicerca(scanner);

        /* se non è presente il prodotto lancio un'eccezione */
        if(!listaProdotti.contains(prodottoInput))
            throw new Exception("Prodotto non trovato");

        int index = listaProdotti.indexOf(prodottoInput); //salvo l'indice perchè poi lo ritorno
        System.out.println(listaProdotti.get(index).toString());

        return index;
    }

    public static void rimuoviProdotto(Scanner scanner, ArrayList<ProdottoElettronico> listaProdotti)throws Exception{
        /* dichiarazione variabili e oggetti */
        int index;
        String conferma;

        index = ricercaProdotto(scanner, listaProdotti); //mi salvo il risultato della ricerca

        /* chiedo all'utente di confermare */
        System.out.println("Vuoi confermare l'operazione? Digita SI / qualsiasi altro input per annullare");
        conferma = scanner.nextLine();

        /* se l'input è SI rimuovo */
        if(conferma.equals("SI")){
            listaProdotti.remove(index);
            System.out.println("Prodotto rimosso con successo");
            Tools.Wait(3);
        }
    }

    public static void cambiaPrezzoProdotto(Scanner scanner, ArrayList<ProdottoElettronico> listaProdotti)throws Exception{
        /* dichiarazione variabili e oggetti */
        double nuovoPrezzo;
        int index;

        /* effetto la ricerca del prodotto */
        index = ricercaProdotto(scanner, listaProdotti);

        /* chiedo l'inserimento del nuovo prezzo e lo modifico */
        System.out.println("Inserisci il nuovo prezzo del prodotto: ");
        nuovoPrezzo = safeDoubleInput(scanner);
        listaProdotti.get(index).setPrezzo(nuovoPrezzo);
    }

    public static void visualizzaProdotti(ArrayList<ProdottoElettronico> listaProdotti)throws Exception{
        if(listaProdotti.isEmpty())
            throw new Exception("Nessun prodotto inserito");

        System.out.println("PRODOTTI INSERITI");
        listaProdotti.forEach(x -> System.out.println(x.toString()));
    }
}
