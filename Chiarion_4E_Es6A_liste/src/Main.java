import java.io.ObjectInputValidation;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.Arrays;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> valori = null;
        Scanner scanner = new Scanner(System.in);
        String[] opzioni = {
                "ARRAYLIST",
                "Creazione",
                "Dimensione",
                "Inserisci elemento",
                "Valori costanti",
                "Visualizza",
                "Cancella elemento",
                "Esiste numero",
                "Cancella elementi",
                "Esci",
        };
        final Integer[] valoriAutomatici = {1,2,3,4,5,6}; //se non metti Integer non accetta asList
        boolean quit = true;

        do{
            switch(menu(opzioni, scanner)){
                case 1 -> valori = new ArrayList<>(2);
                case 2 -> {
                    System.out.println(valori.size());
                    Wait(3);}
                case 3 -> {
                    if(valori == null)
                        break;
                    System.out.println("Inserisci numero");
                    int inputNum = Integer.parseInt(scanner.nextLine());
                    valori.add(inputNum);
                }
                case 4 -> {
                    valori = new ArrayList<>(Arrays.asList(valoriAutomatici));
                    valori.add(0,10);
                    valori.set(0,20);
                    //System.out.println("Valore: "+valori.getFirst());
                }
                case 5 -> {
                    if(valori == null || valori.isEmpty())
                        break;
                    // PRIMO METODO DI VISUALIZZAZIONE
                    /*for(Object object : valori.toArray())
                        System.out.println(object.toString()); */
                    // SECONDO METODO
                    /*for(int i=0;i<valori.size();i++)
                        System.out.println(String.format("%d^ valore : %d",(i+1), valori.get(i)));*/

                    //TERZO METODO
                    /* valori.forEach(System.out::println); */

                    //QUARTO METODO: notazione lambda
                    /* valori.forEach(x-> System.out.printf("valore %d\n",x)); */

                    //QUINTO METODO : utilizzo classe iteratore
                    Iterator iteratore = valori.iterator();
                    while(iteratore.hasNext()){
                        System.out.println("Dato: "+iteratore.next());
                        iteratore.remove();
                    }

                    Wait(5);
                }
                case 6 -> {
                    valori.remove(1);
                    Integer numero = 10;
                    valori.remove(numero);
                }
                case 7 -> {
                    if(valori.contains(5))
                        System.out.println("Valore esiste nella posizione "+valori.indexOf(5));
                    else
                        System.out.println("Valore non esiste");

                    Wait(3);
                }
                case 8 -> valori.clear();
            }
        }while(quit);
    }
}