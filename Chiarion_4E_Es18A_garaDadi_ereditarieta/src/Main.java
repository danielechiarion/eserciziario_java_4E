import java.util.Scanner;

import backend.*;

public class Main {
    public static void main(String[] args) {
        /* creazione oggetto scanner */
        Scanner scanner = new Scanner(System.in);
        /* dichiatazione variabili */
        String repeat;

        //Gara gara = leggiGara(scanner); //lettura della gara
        GaraAvanzata gara = null;
        try{
            gara = new GaraAvanzata(10, 6, new GiocatoreAvanzato("mario"), new GiocatoreAvanzato("luigi"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        do {
            for(int i=0;i<gara.getNumRound();i++){
                System.out.println("Digita INVIO per far partire il round");
                scanner.nextLine();
                try{
                    gara.round();
                    System.out.println(gara.getRoundWinner());
                    System.out.println(gara.statusGara());
                    if(gara.fineGara()){
                        System.out.println(gara.gameWin());
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Digita SI per resettare il gioco, qualsiasi altro input per chiudere il programma");
            repeat = scanner.nextLine();
            if(repeat.equals("SI"))
                gara.resetGame();
        }while(repeat.equals("SI"));
    }

    private static Gara leggiGara(Scanner scanner){
        /* dichiarazione variabili */
        String nome1, nome2;
        int numRound = 0, numFacce=0;
        boolean check;

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

        return new Gara(numRound, numFacce, new Giocatore(nome1), new Giocatore(nome2));
    }
}
