import java.util.Scanner;
import java.util.ArrayList;

import FrontEnd.*;
import scuderia.*;
import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        /* definisco le opzioni */
        String[] opzioni = {
                "GARA AUTOMOBILISTICA",
                "Inserisci pilota",
                "Inserisci auto",
                "Visualizza piloti",
                "Visualizza auto",
                "Fine"
        };
        /* dichiarazione variabili */
        int scelta;
        Pilota pilotaInput;
        Auto autoInput;
        /* istanza delle liste da utilizzare */
        ArrayList<Auto> listaAuto = new ArrayList<>();
        ArrayList<Pilota> listaPiloti = new ArrayList<>();
        /* istanza degli oggetti da utilizzare */
        Scanner keyboard = new Scanner(System.in);

        do{
            scelta = menu(opzioni, keyboard);
            try{
                switch (scelta){
                    case 1 -> {
                        pilotaInput = FrontScreen.leggiPilota(keyboard, false);
                        if(listaPiloti.contains(pilotaInput))
                            throw new Exception("Pilota già inserito");

                        listaPiloti.add(pilotaInput);
                    }
                    case 2 -> {
                        autoInput = FrontScreen.leggiAuto(keyboard, listaPiloti);
                        if(listaAuto.contains(autoInput))
                            throw new Exception("Auto già inserita");

                        listaAuto.add(autoInput);
                    }
                    case 3 -> {
                        if(listaPiloti.isEmpty())
                            throw new Exception("Nessun pilota inserito");

                        listaPiloti.forEach(x -> System.out.println(x.toString()));
                    }
                    case 4 -> {
                        if(listaAuto.isEmpty())
                            throw new Exception("Nessuna auto inserita");

                        listaAuto.forEach(x -> System.out.println(x.toString()));
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                Wait(3);
            }
        }while(scelta != opzioni.length-1);
    }
}
