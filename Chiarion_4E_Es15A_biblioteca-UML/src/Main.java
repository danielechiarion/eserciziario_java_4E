import backend.Genere;
import backend.Libro;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* Libro libro = new Libro("ciao", "bello", 15, Genere.thriller);
        Libro cloneLibro = libro.clone();
        cloneLibro.setAutore("james");
        System.out.println(libro); */

        ArrayList<Libro> lista = new ArrayList<>();
        lista.add(new Libro("mario", "caio", 10, Genere.thriller));
        lista.add(new Libro("cecco", "astolfo", 15, Genere.romanzo));
        lista.add(new Libro("john", "saverio", 20, Genere.generico));
        ArrayList<Libro> cloneLista = (ArrayList<Libro>) lista.clone();
        cloneLista.get(0).setAutore("daniele");
        System.out.println(lista);
    }
}
