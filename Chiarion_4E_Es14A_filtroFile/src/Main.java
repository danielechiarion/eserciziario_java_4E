import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.Tools.*;

public class Main {
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

    private static String readFromFile(String path)throws Exception{
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static void main(String[] args) {
        String[] file = fileFilter(getFileList(System.getProperty("user.dir")), ".txt");
        int scelta = menuOnlyData("File disponibili", file, new Scanner(System.in));
        try{
            System.out.println(readFromFile(file[scelta-1]));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
