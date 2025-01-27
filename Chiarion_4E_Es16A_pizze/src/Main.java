import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* dichiarazione costanti */
        final double pesoProsciutto = 0.4;
        final double pesoFarina = 1.2;
        final double pesoPomodoro = 1.4;
        final int numPizzaMargherita = 4;
        final int numPizzaProsciutto = 8;
        final double pesoPizza = (pesoProsciutto + pesoPomodoro + pesoFarina) / (numPizzaProsciutto + numPizzaMargherita);

        /* dichiarazione variabili */
        int pizzaMargheritaInput, pizzaProsciuttoInput;
        double pesoTotaleFarina, pesoTotaleProsciutto, pesoTotalePomodoro;
        double pesoFarinaCorrente, pesoProsciuttoCorrente, pesoPomodoroCorrente;

        /* creazione scanner per l'input dei dati */
        Scanner scanner = new Scanner(System.in);

        /* richiesta inserimento input */
        System.out.println("Inserisci il numero di pizze margherita: ");
        pizzaMargheritaInput = scanner.nextInt();
        System.out.println("Inserisci il numero di pizze al prosciutto: ");
        pizzaProsciuttoInput = scanner.nextInt();

        /* calcolo i pesi per ogni tipo di pizza */
        pesoFarinaCorrente = pesoFarina / (numPizzaProsciutto + numPizzaMargherita);
        pesoProsciuttoCorrente = pesoProsciutto / numPizzaProsciutto;
        pesoPomodoroCorrente = pesoPomodoro / (numPizzaProsciutto + numPizzaMargherita);

        // Compensazione della mancanza di prosciutto nelle pizze margherita
        double pesoPomodoroMargherita = pesoPomodoroCorrente + pesoProsciuttoCorrente / 2;
        double pesoPomodoroProsciutto = pesoPomodoroCorrente - pesoProsciuttoCorrente / 2;

        /* stampa i pesi degli ingredienti per ogni pizza */
        System.out.printf("Peso di riferimento pizza: %.2fkg\n", pesoPizza);
        System.out.printf("Peso pizza margherita: %.2fkg farina, %.2fkg pomodoro\n", pesoFarinaCorrente, pesoPomodoroMargherita);
        System.out.printf("Peso pizza prosciutto: %.2fkg farina, %.2fkg prosciutto, %.2fkg pomodoro\n", pesoFarinaCorrente, pesoProsciuttoCorrente, pesoPomodoroProsciutto);

        /* calcolo i pesi totali degli ingredienti */
        pesoTotaleFarina = pesoFarinaCorrente * (pizzaMargheritaInput + pizzaProsciuttoInput);
        pesoTotaleProsciutto = pesoProsciuttoCorrente * pizzaProsciuttoInput;
        pesoTotalePomodoro = pesoPomodoroMargherita * pizzaMargheritaInput + pesoPomodoroProsciutto * pizzaProsciuttoInput;

        System.out.printf("Totale farina: %.2fkg\tTotale pomodoro: %.2fkg\tTotale prosciutto: %.2fkg\n", pesoTotaleFarina, pesoTotalePomodoro, pesoTotaleProsciutto);
    }
}
