import static frontend.Tools.*;
import backend.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mensola mensola = new Mensola(10);
        Libro libro = leggiLibro(scanner);

        try{
            mensola.addBook(libro);
            mensola.addBook(new Libro("Libro aggiunto", "Scrittore esperto", 25));
            visualizzaMensola(mensola.getVolumi());
            System.out.println(mensola.containsBook(libro.clone()));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
