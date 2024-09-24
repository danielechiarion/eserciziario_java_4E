import static utility.Tools.*;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        final String[] opzioni = {"NUMERI RANDOM",  //predisposizione menu
                "Inserimento",
                "Visualizzazione",
                "Fine"};
        Scanner scanner = new Scanner(System.in); //creazione oggetto scanner

        /* dichiarazioni variabili */
        int scelta;
        /* dichiatarazione costanti */
        final int QUANTINUMERI = 50;
        final int MINRANGE = 0, MAXRANGE = 100;
        /* creazione vettori */
        int[] arrayRandom = new int[QUANTINUMERI];

        /* il ciclo di istruzioni si ripete fin
         * quando non viene scelta l'operazione di uscita */
        do {
            scelta = Menu(opzioni, scanner);
            /* apro lo switch case con le varie
             * operazioni da compiere */
            switch (scelta) {
                case 1:
                    generaRandom(MINRANGE, MAXRANGE, arrayRandom); //generazione numeri casuali
                    System.out.println("I numeri sono stati generati"); //output riuscita operazione
                    Wait(3);
                    break;
                case 2:
                    stampaArray(arrayRandom);
                    System.out.println("Digita qualsiasi tasto per continuare");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Fine programma");
            }
        } while (scelta != opzioni.length - 1); //finisce quando non viene scelta l'ultima opzione
    }

    /* metodo che genera N numeri casuali
     * restituendo il vettore con i numeri generati */
    private static void generaRandom(int numMin, int numMax, int[] arrayNumeri) {
        Random random = new Random(); //creazione generatore casuale

        /* generazione numeri casuali */
        for (int i = 0; i < arrayNumeri.length; i++)
            arrayNumeri[i] = random.nextInt(numMin, numMax) + 1; //aumento l'estremo a 1 perchè senno non è incluso
    }

    /* metodo che ritorna un nuovo vettore di numeri random */
    private static int[] generaRandom2(int dimArray, int numMin, int numMax) {
        Random random = new Random(); //creazione generatore random
        int[] array = new int[dimArray]; //istanza array

        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(numMin, numMax) + 1;

        return array;
    }

    /* metodo che stampa i valori presenti all'interno dell'array */
    private static void stampaArray(int[] array) {
        System.out.println("ARRAY NUMERI RANDOM");
        for (int numero : array)
            System.out.print(numero + "\t");
        System.out.println();
    }
}