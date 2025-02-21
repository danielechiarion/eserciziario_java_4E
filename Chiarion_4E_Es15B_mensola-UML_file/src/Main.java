import static frontend.Tools.*;
import backend.*;

import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mensola mensola = new Mensola(10);
        Libro libro = leggiLibro(scanner);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try{
            mensola.addBook(libro);
            mensola.addBook(new Libro("Libro aggiunto", "Scrittore esperto", 25));
            visualizzaMensola(mensola.getVolumi());
            System.out.println(mensola.containsBook(libro.clone()));

            writeOnFile(mensola.toCSV(), "mensola.csv");
            writeOnFile(gson.toJson(mensola), "mensola.json");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /* method to write on a file */
    public static void writeOnFile(String content, String filePath){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
