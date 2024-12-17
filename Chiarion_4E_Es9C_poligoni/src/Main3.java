/*
Che devi fare?
Correggi il main, se occorre:
Controlla bene il  metodo getInformazioni() e vedi come risolvere il problema dello stampare info.

Modifica alle classi:
Aggiungi un metodo getInformazioni() in ciascuna classe (Rettangolo, Quadrato, TriangoloRettangolo), che restituisca una descrizione dettagliata della figura
(simile a un metodo descrizione() ma con più dettagli, ad esempio il calcolo dell'area incluso nella stringa).
Sistema il metodo compareTo:

Fai in modo che tutte le figure abbiano un metodo compareTo(Figura altra) che consenta di confrontare le aree di due figure geometriche di tipo diverso.
Nota: Il confronto deve funzionare anche tra figure geometriche diverse, ad esempio tra un rettangolo e un quadrato. Spiega brevemente il ragionamento dietro le modifiche apportate prima di realizzare le modifiche.

*/

/* RISPOSTA: sia per il compareTo() che per il metodo getInformazioni(), intendo creare
* una classe genitore poligono dalla quale derivano tutte le figure indicate,
* così ho la possibilità di creare un metodo unico per il compare ed un metodo unico per
* le informazioni senza il bisogno di utilizzare ogni volta un metodo diverso per ogni
* classe.
* L'unica cosa da indicare sarà che le figure estendono la classe poligono e che
* alcuni metodi (come calcolaArea() e descrizione()) sono un override.
*
* Per il getInformazioni() sfrutto anche il metodo getDescrizione() */

import poligoni.*;
public class Main3 {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(5, 8);
        Quadrato quadrato = new Quadrato(6);
        TriangoloRettangolo triangolo = new TriangoloRettangolo(3, 4);
        System.out.println(rettangolo.getInformazioni());
        System.out.println(quadrato.getInformazioni());
        System.out.println(triangolo.getInformazioni());
        if (rettangolo.compareTo(quadrato) > 0) {
            System.out.println("Il rettangolo ha un'area maggiore del quadrato.");
        } else {
            System.out.println("Il quadrato ha un'area maggiore o uguale a quella del rettangolo.");
        }
    }
}
