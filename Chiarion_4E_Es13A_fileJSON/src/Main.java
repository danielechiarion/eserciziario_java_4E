import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        /* salva singola persona */
        Gson gson = new Gson();
        Persona persona1 = new Persona("Mario Bianchi", 17);
        String gsonString = gson.toJson(persona1);
        System.out.println(gsonString);
        Persona fromJSON = gson.fromJson(gsonString, Persona.class);
        System.out.println(fromJSON.toString());

        /* salvo archivio */
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        Persona persona2 = new Persona("Giovanni Lucio", 19);
        Persona persona3 = new Persona("Caio Rollo", 23);
        ArrayList<Persona> archivio = new ArrayList<>();
        archivio.add(persona1);
        archivio.add(persona2);
        archivio.add(persona3);
        String archivioJSON = gson2.toJson(archivio);
        /* 1 - SERIALIZZAZIONE */
        try{
            Files.write(Paths.get("archivio.json"), archivioJSON.getBytes());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        /* 1 - DESERIALIZZAZIONE */
        ArrayList<Persona> archivioFromJSON = new ArrayList<>();
        try{
            byte[] jsonData = Files.readAllBytes(Path.of("archivio.json"));
            Persona[] collezione = gson2.fromJson(new String(jsonData), Persona[].class);
            archivioFromJSON = new ArrayList<>(Arrays.asList(collezione));
            System.out.println(archivioFromJSON);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        /* 2 - SCRITTURA SERIALIZZAZIONE
        * secondo modo della scrittura file */
        try{
           FileWriter file = new FileWriter("archivio2.json");
           file.write(gson2.toJson(archivio));
           file.flush(); //aggiorna file su disco, altrimenti non scrive niente
           file.close();
           System.out.println("Archivio 2 salvato con successo");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        archivioFromJSON.clear(); //pulisco la lista di prima
        /* 2 - LETTURA DESERIALIZZAZIONE
        secondo modo per la lettura da file */
        Type listType = new TypeToken<ArrayList<Persona>>() {} .getType(); //serve per salvare il tipo di arraylist, altrimenti non si salva
        try{
            FileReader fileReader = new FileReader("archivio.json");
            archivioFromJSON = gson.fromJson(fileReader, listType);
            System.out.println("Contenuto Archivio 2");
            System.out.println(archivioFromJSON);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
