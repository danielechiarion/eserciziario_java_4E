/*
Modifica il programma principale (main) in modo che:
1.	Chieda all'utente di inserire i dati da tastiera per creare un nuovo rettangolo, un quadrato e una circonferenza.
2.	Stampi i dati e le aree delle figure create.
Esempio di input richiesto:
•	Per il rettangolo: base e altezza.
•	Per il quadrato: lunghezza del lato.
•	Per la circonferenza: lunghezza del raggio.
Assicurati che il programma verifichi se i valori inseriti dall'utente siano positivi, e in caso contrario stampi un messaggio di errore.
*/

import poligoni.*;
import static FrontEnd.FrontScreen.*;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        /* dichiarazione variabili */
        double input1, input2;

        /* creo lo scanner */
        Scanner scanner = new Scanner(System.in);

        // Creazione di un rettangolo e calcolo area
        /* si accettano anche base e altezza uguali */
        input1 = safeDoubleInput("Inserisci la base del rettangolo: ", scanner);
        input2 = safeDoubleInput("Inserisci l'altezza del rettangolo", scanner);
        Rettangolo rettangolo = new Rettangolo(input1, input2);
        System.out.println("Rettangolo - Base: " + rettangolo.getBase() + ", Altezza: " + rettangolo.getAltezza());
        System.out.println("Area del rettangolo: " + rettangolo.calcolaArea());

        // Creazione di un quadrato e calcolo area
        input1 = safeDoubleInput("Inserisci il lato del quadrato: ", scanner);
        Quadrato quadrato = new Quadrato(input1);
        System.out.println("\nQuadrato - Lato: " + quadrato.getLato());
        System.out.println("Area del quadrato: " + quadrato.calcolaArea());

        // Creazione di un triangolo rettangolo e calcolo area
        input1 = safeDoubleInput("Inserisci la base del triangolo rettangolo: ", scanner);
        input2 = safeDoubleInput("Inserisci l'altezza del triangolo rettangolo", scanner);
        TriangoloRettangolo triangolo = new TriangoloRettangolo(input1, input2);
        System.out.println("\nTriangolo Rettangolo - Base: " + triangolo.getBase() + ", Altezza: " + triangolo.getAltezza());
        System.out.println("Area del triangolo rettangolo: " + triangolo.calcolaArea());

        // Creazione di una circonferenza e calcolo area
        input1 = safeDoubleInput("Inserisci il raggio della circonferenza: ", scanner);
        Circonferenza circonferenza = new Circonferenza(7);
        System.out.println("\nCirconferenza - Raggio: " + circonferenza.getRaggio());
        System.out.println("Area della circonferenza: " + circonferenza.calcolaArea());
    }
}
