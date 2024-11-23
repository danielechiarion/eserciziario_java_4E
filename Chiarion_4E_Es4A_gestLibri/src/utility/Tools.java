package utility;

import java.util.Scanner;

public class Tools {
    public static void ClrScr() {
        try {
            String operatingSystem = System.getProperty("os.name").toLowerCase();

            if (operatingSystem.contains("win")) {
                // Comando per Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("mac")) {
                // Comando per Unix-like e macOS
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Sistema operativo non supportato per la pulizia dello schermo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int menu(String[] opzioni, Scanner keyboard){
        int scelta;

        do {
            ClrScr();
            System.out.println("=== " + opzioni[0] + " ===");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("["+i+"] "+opzioni[i]);
            }
            try{
                scelta = Integer.parseInt(keyboard.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Numero non valido");
                scelta = 0;
            }
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    public static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}