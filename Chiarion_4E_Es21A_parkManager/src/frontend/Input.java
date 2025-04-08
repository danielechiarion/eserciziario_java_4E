package frontend;

import java.util.Scanner;

import vehicle.*;

public class Input {
    /**
     * Method that returns an integer input,
     * with controls about possible domain errors
     * and the possibility to choose whether this data
     * is absolutely necessary or not (like in a searching mode)
     *
     * @param request    text that will be displayed as the request before the input
     * @param scanner    for the input of the data
     * @param forceInput when it's TRUE it's mandatory to have it, when it's FALSE it can be omited
     * @return the integer value typed by the user, -1 if it has been omited
     */
    public static int safeIntInput(String request, Scanner scanner, boolean forceInput) {
        /* variable declaration */
        int input = -1;
        boolean check;

        do {
            check = false;
            System.out.println(request);
            String inputString = scanner.nextLine();


            /* before converting the string read from the scanner
             * into input, it's necessary to check if the input is mandatory
             * (the value of forceInput is TRUE),
             * otherwise it will throw and exception */
            if (!(!forceInput && inputString.isEmpty())) {
                try {
                    input = Integer.parseInt(inputString);
                    if (input < 0)
                        throw new Exception("Non si può inserire un valore negativo");
                } catch (NumberFormatException e) {
                    System.out.println("Input fuori dal dominio");
                    check = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    check = true;
                }
            }
        } while (check);

        return input;
    }

    /**
     * Method that returns a double input,
     * with controls about possible domain errors
     * and the possibility to choose whether this data
     * is absolutely necessary or not (like in a searching mode)
     *
     * @param request    text that will be displayed as the request before the input
     * @param scanner    for the input of the data
     * @param forceInput when it's TRUE it's mandatory to have it, when it's FALSE it can be omited
     * @return the double value typed by the user, -1 if it has been omited
     */
    public static double safeDoubleInput(String request, Scanner scanner, boolean forceInput) {
        /* variable declaration */
        double input = -1000000;
        boolean check;

        do {
            check = false;
            System.out.println(request);
            String inputString = scanner.nextLine();

            /* before converting the string read from the scanner
             * into input, it's necessary to check if the input is mandatory
             * (the value of forceInput is TRUE),
             * otherwise it will throw and exception */
            if (!(!forceInput && inputString.isEmpty())) {
                try {
                    input = Double.parseDouble(inputString);
                } catch (NumberFormatException e) {
                    System.out.println("Input fuori dal dominio");
                    check = true;
                }
            }
        } while (check);

        return input;
    }

    /**
     * Method that generates a wait until
     * something isn't typed.
     * It's used when it's not sure about the time needed by
     * the user to see a certain result displayed
     *
     * @param scanner for the input of the value, even if it won't be saved
     */
    public static void waitingInput(Scanner scanner) {
        System.out.println("\nDigita INVIO per continuare");
        scanner.nextLine();
    }

    /**
     * Method that allows the user to choose between two options.
     *
     * @param option1 text of the first option
     * @param option2 text of the second option
     * @param scanner for the input of the user
     * @return number of the choice done
     */
    public static int twoOptionChoice(String option1, String option2, Scanner scanner) {
        /* dichiarazione variabili */
        int choice;


        /* output delle opzioni */
        System.out.println("Scegli tra le seguenti opzioni: ");
        System.out.println("[1] " + option1);
        System.out.println("[2] " + option2);
        /* controllo che l'input sia valido,
         * anche come intervallo */
        do {
            choice = safeIntInput("", scanner, true);
        } while (choice < 1 || choice > 2);


        /* ritorno alla fine la scelta effettuata */
        return choice;
    }


    public static Car readCar(Scanner scanner, boolean forceInput){
        /* variables required for the input */
        boolean gpl, reserved, vip;
        double value, power;
        int booleanChoice;

        /*  */
    }
}
