package frontend;

import backend.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Tools {
    /*public static void main(String[] args) {

    }*/
    private Tools() {
    }

    ; //impedisce di istanziare la classe

    public static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int Menu(String opzioni[], Scanner tastiera) {// parametri formali
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            scelta = (Integer.parseInt(tastiera.nextLine()));
            //tastiera.nextLine();
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));
        //tastiera.nextLine();
        return scelta;
    }

    public static Libro leggiLibro(Scanner tastiera) {
        String[] opzioniLibro = {
                "LIBRI DA INSERIRE",
                "Romanzo",
                "Manuale",
                "Triller"
        };

        int sceltaLibro = Menu(opzioniLibro, tastiera);

        System.out.print("Inserisci l'autore del libro: ");
        String autore = tastiera.nextLine();
        System.out.print("Inserisci il titolo del libro: ");
        String titolo = tastiera.nextLine();
        System.out.print("Inserisci il numero di pagine del libro: ");
        int nPagine = Integer.parseInt(tastiera.nextLine());

        if(sceltaLibro == 1){
            System.out.println("Inserisci il genere letterario del romanzo");
            String genereLetterario = tastiera.nextLine();
            return new Romanzo(titolo, autore, nPagine, genereLetterario);
        }else if(sceltaLibro == 2){
            Livello livello = Livello.getLivello(Menu(Livello.getLivelliArrayString(), tastiera)-1);
            return new Manuale(titolo, autore, nPagine, livello);
        }else{
            Genere genere = Genere.getGenere(Menu(Genere.getGeneriArrayString(), tastiera)-1);
            return new Thriller(titolo, autore, nPagine, genere);
        }
    }

    public static void visualizzaMensola(ArrayList<Libro> volumi) {
        clrScr();
        for (Libro l : volumi) {
            System.out.println(l.toString());
        }
    }
}