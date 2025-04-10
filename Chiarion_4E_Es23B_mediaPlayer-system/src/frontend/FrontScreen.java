package frontend;

import java.io.File;
import java.util.Scanner;

import mediaPlaylist.*;
import playlist.*;

public class FrontScreen {
    private static int safeIntInput(Scanner scanner) {
        int value = 0;
        boolean check;

        do {
            check = false;
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return value;
    }

    private static double safeDoubleInput(Scanner scanner) {
        double value = 0;
        boolean check;

        do {
            check = false;
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            } catch (NumberFormatException e) {
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        return value;
    }

    private static FileMedia leggiMedia(Scanner scanner)throws Exception{
        /* dichiarazione variabili */
        String titolo, artista, filePath;
        int durata;
        /* opzioni per il prodotto da aggiungere */
        String[] opzioni = {
                "MEDIA",
                "Canzone",
                "Video"
        };
        int scelta;

        scelta = Tools.Menu(opzioni, scanner);

        /* lettura attributi */
        System.out.println("Inserisci il percorso: ");
        filePath = scanner.nextLine();
        System.out.println("Inserisci il titolo: ");
        titolo = scanner.nextLine();

        System.out.println("Inserisci l'artista: ");
        artista = scanner.nextLine();
        return new Canzone(filePath, titolo, artista);
    }

    public static void inserimentoMedia(GestionePlayer gestionePlayer, Scanner scanner)throws Exception{
        gestionePlayer.aggiungiMedia(leggiMedia(scanner));
    }

    public static void rimozioneMedia(GestionePlayer gestionePlayer, Scanner scanner)throws Exception{
        gestionePlayer.rimuoviMedia(leggiMedia(scanner));
    }

    public static void riproduzioneMedia(GestionePlayer gestionePlayer, Scanner scanner)throws Exception{
        System.out.println(gestionePlayer.riproduciMedia(leggiMedia(scanner)));
    }

    public static void stoppingMedia(GestionePlayer gestionePlayer)throws Exception{
        System.out.println(gestionePlayer.stopMedia());
    }

    public static void interruzioneMedia(GestionePlayer gestionePlayer)throws Exception{
        System.out.println(gestionePlayer.pausaMedia());
    }

    public static void prossimoMedia(GestionePlayer gestionePlayer)throws Exception{
        System.out.println(gestionePlayer.prossimoMedia());
    }

    public static void visualizzazionePlaylist(GestionePlayer gestionePlayer){
        System.out.println("PLAYLIST");
        gestionePlayer.getPlaylist().forEach(x -> System.out.println(x.toString()));
        Tools.Wait(5);
    }

    public static void ripresaRiproduzioneMedia(GestionePlayer gestionePlayer)throws Exception{
        System.out.println(gestionePlayer.riproduciMedia());
    }
}