import java.util.Scanner;

import backend.*;

public class Main {
    public static void main(String[] args) {
        /* creazione oggetto scanner */
        Scanner scanner = new Scanner(System.in);
        /* dichiatazione variabili */
        String repeat;

        //Gara gara = leggiGara(scanner); //lettura della gara
        Gara gara = null;
        try{
            gara = leggiGara(scanner);
            do {
                giocaPartita(gara, scanner);
                System.out.println("Digita SI per resettare il gioco, qualsiasi altro input per chiudere il programma");
                repeat = scanner.nextLine();
                if(repeat.equals("SI"))
                    gara.resetGame();
            }while(repeat.equals("SI"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static Gara leggiGara(Scanner scanner)throws Exception{
        /* dichiarazione variabili */
        String nome1, nome2;
        int numRound = 0, numFacce=0;
        boolean check;
        int option;

        /* chiedo tipo di partita */
        System.out.println("Inserisci il tipo di gara\n1 - base\n2 - avanzata");
        option = Integer.parseInt(scanner.nextLine());

        /* richiesta inserimento dati */
        System.out.println("Inserisci nome primo giocatore: ");
        nome1 = scanner.nextLine();
        do{
            System.out.println("Inserisci il nome del secondo giocatore: ");
            nome2 = scanner.nextLine();
            if(nome2.equals(nome1))
                System.out.println("Hai inserito due numeri uguali. Riprova");
        }while(nome2.equals(nome1)); //ripeto se ho inserito due nomi uguali
        /* con le variabili intere occorre fare un controllo sull'intervallo
         * e su possibili errori di dominio */
        do{
            check = false;
            try{
                System.out.println("Inserisci il numero di round da giocare");
                numRound = Integer.parseInt(scanner.nextLine());
                if(numRound<=0)
                    throw new Exception("Non puoi inserire un numero di round negativo o nullo");
            }catch(NumberFormatException e){
                System.out.println("ERRORE DI DOMINIO");
                check = true;
            }
            catch(Exception e){
                check = true;
                System.out.println(e.getMessage());
            }
        }while(check);
        do{
            check = false;
            try{
                System.out.println("Inserisci il numero di facce per dado");
                numFacce = Integer.parseInt(scanner.nextLine());
                if(numFacce<=0)
                    throw new Exception("Non puoi inserire un numero di facce negativo o nullo");
            }catch(NumberFormatException e){
                System.out.println("ERRORE DI DOMINIO");
                check = true;
            }
            catch(Exception e){
                check = true;
                System.out.println(e.getMessage());
            }
        }while(check);

        if(option == 1)
            return new Gara(numRound, numFacce, new Giocatore(nome1), new Giocatore(nome2));
        else
            return new GaraAvanzata(numRound, numFacce, new GiocatoreAvanzato(nome1), new GiocatoreAvanzato(nome2));
    }

    /* metodo per il funzionamento di una partita */
    public static void giocaPartita(Gara garaBase, Scanner scanner){
        for(int i=0;i<garaBase.getNumRound();i++){
            System.out.println("Digita INVIO per far partire il round");
            scanner.nextLine();
            try{
                garaBase.round();
                System.out.println(garaBase.getRoundWinner());
                System.out.println(garaBase.statusGara());
                if(garaBase.fineGara()){
                    System.out.println(garaBase.gameWin());
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /* metodo per giocare la gara */
    public static void giocaPartita(GaraAvanzata garaAvanzata, Scanner scanner){
        giocaPartita((Gara)garaAvanzata, scanner); //il metodo funziona anche con una gara avanzata
    }
}
