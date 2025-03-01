package frontend;

import java.util.Scanner;

public class Tools {
    /**
     * Method for clearing screen on different
     * OS (Windows and Linux supported)
     */
    public static void clrScr() {
        try {
            String operatingSystem = System.getProperty("os.name").toLowerCase();

            if (operatingSystem.contains("win")) {
                // Command for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("mac")) {
                // Command for Unix-like and macOS
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Sistema operativo non supportato per la pulizia dello schermo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to generate a wait during the execution
     * of the program
     *
     * @param s number of seconds
     */
    public static void Wait(int s) {
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that, starting from a range of options given,
     * returns the choice of the user.
     * Inside the method there are already checks about possible domain
     * and range errors.
     *
     * @param array   array of strings with the options the user can choose (the first one is not an option, but the header of the menu)
     * @param scanner scanner to get the choice given by the user
     * @return integer representing the choice made by the user
     */
    public static int Menu(String[] array, Scanner scanner) {
        int scelta = 0;
        boolean check;

        do {
            check = false;
            clrScr();
            System.out.println("------------------");
            System.out.println(array[0]);
            System.out.println("------------------");
            for (int i = 1; i < array.length; i++) {
                System.out.println("[" + i + "]" + " " + array[i]);
            }
            try {
                scelta = (Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                check = true;
            }
            //tastiera.nextLine();
            if ((scelta < 1) || (scelta > array.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2);
                check = true;
            }
        }
        while (check);
        //tastiera.nextLine();
        return scelta;
    }
}
