package utility;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
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

    public static int menuOnlyData(String intestazione, String[] opzioni, Scanner keyboard){
        String[] opzioniComplete = new String[opzioni.length+1];
        opzioniComplete[0] = intestazione;
        for (int i = 1; i < opzioniComplete.length; i++) {
            opzioniComplete[i] = opzioni[i-1];
        }
        return menu(opzioniComplete, keyboard);
    }

    public static void printArrayStringValues(ArrayList<?> lista)throws NullPointerException{
        if(lista.isEmpty())
            throw new NullPointerException("Nessun valore disponibile");

        for (Object object : lista)
            System.out.println(object.toString());
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

    /* metodo che ritorna il contenuto dei file nella cartella corrente */
    public static File currentFileDirectory(String nameDirectory){
        //String UserDirectory = System.getProperty("user.dir"); //ritorna la directory di lavoro corrente del programma
        String UserDirectory = nameDirectory;
        return new File(UserDirectory);
    }

    public static String[] getFileList(String nameDirectory){
        File dir = currentFileDirectory(nameDirectory);
        return dir.list();
    }

    /* ritorna i file con solo l'estensione indicata */
    public static String[] fileFilter(String[] fileList, String extensionFilter){
        ArrayList<String> lista = new ArrayList<>();
        for(String file : fileList){
            if(file.endsWith(extensionFilter))
                lista.add(file);
        }
        return lista.toArray(new String[lista.size()]);
    }

    /*private static String readFromFile(String path)throws Exception{
        return new String(Files.readAllBytes(Paths.get(path)));
    }*/

    /*public static void main(String[] args) {
        String[] file = fileFilter(getFileList("src/gestGara"), ".java");
        int scelta = menuOnlyData("File disponibili", file, new Scanner(System.in));
        try{
            System.out.println(readFromFile("src/gestGara/"+file[scelta]));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}