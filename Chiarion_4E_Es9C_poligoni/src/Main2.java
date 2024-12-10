/*
Modifica le classi Rettangolo, Quadrato, TriangoloRettangolo e Circonferenza per fare in modo che il programma compili correttamente ed esegua quanto segue:
1.	Aggiungi un metodo String descrizione() in ciascuna classe che restituisca una stringa con i dettagli della figura.
o	Esempio per un rettangolo: "Rettangolo con base 5.0 e altezza 8.0".
o	Esempio per un quadrato: "Quadrato con lato 6.0".
o	Fai in modo che il metodo restituisca descrizioni simili per le altre figure.
2.	Verifica che il metodo calcolaArea() sia presente in tutte le classi e che restituisca correttamente l'area.
Nota: Non modificare il codice del main. Adatta le classi al codice esistente.

*/

import poligoni.*;

public class Main2 {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(5, 8);
        Quadrato quadrato = new Quadrato(6);
        TriangoloRettangolo triangolo = new TriangoloRettangolo(3, 4);
        Circonferenza circonferenza = new Circonferenza(7);

        // Stampa delle descrizioni delle figure
        System.out.println(rettangolo.descrizione());
        System.out.println(quadrato.descrizione());
        System.out.println(triangolo.descrizione());
        System.out.println(circonferenza.descrizione());

        // Stampa delle aree delle figure
        System.out.println("\nAree delle figure:");
        System.out.println("Rettangolo: " + rettangolo.calcolaArea());
        System.out.println("Quadrato: " + quadrato.calcolaArea());
        System.out.println("Triangolo Rettangolo: " + triangolo.calcolaArea());
        System.out.println("Circonferenza: " + circonferenza.calcolaArea());
    }
}
