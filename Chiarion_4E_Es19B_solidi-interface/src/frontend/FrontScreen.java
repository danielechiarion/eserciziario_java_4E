package frontend;

import java.util.Scanner;

import backend.*;

public class FrontScreen {
    public static double safeDoubleInput(Scanner scanner){
        double value = 0;
        boolean check;

        do{
            check = false;
            try{
                value = Double.parseDouble(scanner.nextLine());
                if(value<=0)
                    throw new Exception("Non puoi inserire un numero negativo o nullo");
            }catch(NumberFormatException e){
                System.out.println("Errore di dominio");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        return value;
    }

    public static FiguraSolida inserisciSolido(Scanner scanner){
        /* definisco le opzioni dell'utente */
        String[] opzioni = {"INSERIMENTO SOLIDI", "Inserisci una sfera", "Inserisci un cubo"};

        /* dichiarazione variabili */
        double lato, raggio;
        int scelta;

        /* scelgo quale solido inserire */
        scelta = Tools.Menu(opzioni, scanner);

        if(scelta == 1){
            System.out.println("Inserisci il raggio: ");
            raggio = safeDoubleInput(scanner);
            return new Sfera(raggio);
        }else if (scelta == 2){
            System.out.println("Inserisci il lato: ");
            lato = safeDoubleInput(scanner);
            return new Cubo(lato);
        }else
            return null;
    }

    public static void stampaRisultati(String intestazione, String[] risultati)throws Exception{
        if(risultati == null)
            throw new Exception("Nessun risultato trovato");

        System.out.println("\n*** "+intestazione+" ***");
        for(String currentString : risultati)
            System.out.println(currentString);
    }
}
