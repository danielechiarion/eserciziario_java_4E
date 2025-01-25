import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione costanti */
        final double pesoProsciutto = 0.4;
        final double pesoFarina = 1.2;
        final double pesoPomodoro = 1.4;
        final int numPizzaMargherita = 4;
        final int numPizzaProsciutto = 8;
        final double pesoPizza = (double)(pesoProsciutto+pesoPomodoro+pesoFarina) / (numPizzaProsciutto+numPizzaMargherita);

        /* dichiarazione variabili */
        int pizzaMargheritaInput, pizzaProsciuttoInput;
        double pesoPizzaMargherita, pesoPizzaProsciutto;
        double pesoProsciuttoCorrente, pesoFarinaCorrente, pesoPomodoroCorrente, pesoTotaleFarina=0, pesoTotalePomodoro=0, pesoTotaleProsciutto=0;

        /* creazione scanner per l'input dei dati */
        Scanner scanner = new Scanner(System.in);

        /* richiesta inserimento input */
        System.out.println("Inserisci il numero di pizze margherita: ");
        pizzaMargheritaInput = scanner.nextInt();
        System.out.println("Inserisci il numero di pizze al prosciutto: ");
        pizzaProsciuttoInput = scanner.nextInt();

        /* nel primo ciclo calcolo il numero di pizze al prosciutto */
        pesoFarinaCorrente = pesoFarina/(numPizzaProsciutto+numPizzaMargherita);
        pesoProsciuttoCorrente = pesoProsciutto/numPizzaProsciutto;
        pesoPomodoroCorrente = pesoPomodoro/(numPizzaProsciutto+numPizzaMargherita)-pesoProsciuttoCorrente;
    }
}
