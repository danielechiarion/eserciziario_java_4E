package mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    public String autore;
    public String titolo;
    public double costoPerPagina = 0.5;
    public Genere tipologia;
    public int numPagine;
    public LocalDate dataPubblicazione;

    private final DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return String.format("Autore: %s\tTitolo: %s\tNumero di pagine: %d\tGenere: %s\tData pubblicazione: %s\tCosto: %.2f€",
                this.autore, this.titolo, this.numPagine, this.tipologia.toString(), this.dataPubblicazione.format(formattazioneData), this.costoPerPagina*this.numPagine);
    }

    public static int searchBook(Libro[] array, String autore, String titolo){
        for(int i=0;i<array.length && array[i]!=null;i++)
            if(array[i].autore.equals(autore) && array[i].titolo.equals(titolo))
                return i;

        return -1;
    }

    public static void printBookList(Libro[] array){
        System.out.println("*** LIBRI INSERITI");
        for(Libro libro : array)
            System.out.println(libro.toString());
    }
}