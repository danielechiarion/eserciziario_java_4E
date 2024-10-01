import static utility.Tools.*;

import java.util.Random;
import java.util.Scanner;

/* programma che genera numeri casuali senza ripetizioni */

public class Main {
    public static void main(String[] args) {
        final String[] opzioni = {"NUMERI RANDOM",  //predisposizione menu
                "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Raddoppia dimensione vettore",
                "Riempi vettore",
                "Fine"};
        Scanner scanner = new Scanner(System.in); //creazione oggetto scanner

        /* dichiarazioni variabili */
        int scelta, inputNumero;
        /* dichiatarazione costanti */
        final int QUANTINUMERI = 10;
        final int MINRANGE = 0, MAXRANGE = 20;
        /* creazione vettori */
        int[] arrayRandom = null;

        /* il ciclo di istruzioni si ripete fin
         * quando non viene scelta l'operazione di uscita */
        do {
            scelta = Menu(opzioni, scanner);
            /* apro lo switch case con le varie
             * operazioni da compiere */
            switch (scelta) {
                case 1:
                    arrayRandom = generaRandom(QUANTINUMERI, MINRANGE, MAXRANGE); //generazione numeri casuali
                    System.out.println("I numeri sono stati generati"); //output riuscita operazione
                    Wait(3);
                    break;
                case 2:
                    stampaArray(arrayRandom);
                    System.out.println("Digita qualsiasi tasto per continuare");
                    scanner.nextLine();
                    break;
                case 3:
                    do {
                        System.out.println("Inserisci il numero");
                        inputNumero = Integer.parseInt(scanner.nextLine());
                        if (inputNumero < MINRANGE || inputNumero > MAXRANGE) {
                            System.out.println("Il numero non appartiene all'intervallo stabilito.");
                            clrScr();
                        }
                    } while (inputNumero < MINRANGE || inputNumero > MAXRANGE);
                    int posizione = cercaPosizione(arrayRandom, inputNumero);
                    if (posizione < 0)
                        System.out.println("Il numero non è presente");
                    else
                        System.out.println("Il numero è nella posizione " + posizione);
                    Wait(5);
                    break;
                case 4:
                    if (arrayRandom == null) {
                        System.out.println("Array vuoto");
                        Wait(3);
                    } else
                        arrayRandom = raddoppiaVettore(arrayRandom);
                    break;
                case 5:
                    if(arrayRandom==null){
                        System.out.println("L'array è vuoto");
                        Wait(3);
                    }
                    else{
                        System.out.println("Inserisci il numero: ");
                        inputNumero = Integer.parseInt(scanner.nextLine());
                        riempiVettore(arrayRandom, inputNumero);
                    }
                    break;
                default:
                    System.out.println("Fine programma");
            }
        } while (scelta != opzioni.length - 1); //finisce quando non viene scelta l'ultima opzione
    }

    /* metodo che ritorna un nuovo vettore di numeri random */
    private static int[] generaRandom(int dimArray, int numMin, int numMax) {
        Random random = new Random(); //creazione generatore random
        int numero; //variabile che verrà utilizzata per il numero corrente estratto
        /* istanze array */
        int[] array = new int[dimArray];
        boolean[] checkRipetizioni = new boolean[numMax - numMin]; //booleano che segna quali numeri sono stati già estratti

        for (int i = 0; i < array.length && i < numMax - numMin; i++) {
            do {
                numero = random.nextInt(numMin, numMax) + 1;
            } while (checkRipetizioni[numero + numMin - 1]); //ripete il ciclo se il numero estratto è gia stato selezionato

            array[i] = numero;
            checkRipetizioni[numero + numMin - 1] = true;
        }

        return array;
    }

    /* metodo che stampa i valori presenti all'interno dell'array */
    private static void stampaArray(int[] array) {
        if (array == null) {
            System.out.println("Non è stata fatta ancora nessuna estrazione");
            return;
        }
        System.out.println("ARRAY NUMERI RANDOM");
        for (int numero : array)
            System.out.print(numero + "\t");
        System.out.println();
    }

    /* metodo di ricerca per trovare un valore
     * inserito all'interno di un array */
    private static int cercaPosizione(int[] arrayRandom, int numero) {
        if (arrayRandom != null) {
            for (int i = 0; i < arrayRandom.length; i++) {
                if (numero == arrayRandom[i])
                    return i;
            }
        }

        return -1;
    }

    /* metodo che serve a raddoppiare il vettore iniziale */
    private static int[] raddoppiaVettore(int[] array) {
        int[] array2 = new int[array.length * 2];

        for (int i = 0; i < array.length; i++)
            array2[i] = array[i];

        return array2;
    }

    /* metodo che sostiusce i valori di 0
     * con un altro valore */
    private static void riempiVettore(int[] array, int numero) {
        int posNumero = cercaPosizione(array, numero);

        if (posNumero >= 0)
            return;

        int dimArray = contaPosOccupateArray(array);
        if(dimArray<array.length)
            array[dimArray]=numero;
    }

    /* metodo che conta quanti elementi sono
     * presenti all'interno di un array */
    private static int contaPosOccupateArray(int[] array) {
        int cont = 0;

        for (int i=0;i<array.length && array[i]>0;i++)
            cont++;

        return cont;
    }
}