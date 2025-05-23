package mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    public String autore;
    public String titolo;
    public int numeroPagine;
    public double costoPerPagina = 0.05;
    public Genere tipologia;
    public LocalDate dataPubblicazione;
    private final DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return String.format("Autore: %s; Titolo: %s; Numero di pagine %s; Prezzo: %.2f; Genere: %s; Data: %s\n",
                autore, titolo, numeroPagine, numeroPagine * costoPerPagina, tipologia.toString(), dataPubblicazione.format(formattazioneData));
    }


    @Override
    public boolean equals(Object obj){
        if(obj ==null || this.getClass() != obj.getClass())
            return false;
        Libro libro = (Libro)obj;
        boolean risultato = false;
        if(libro.autore != null && this.autore!=null){
            if(this.autore.equals(libro.autore))
                risultato = true;
            else
                risultato = false;
        }
        if(libro.titolo != null && this.titolo!=null){
            if(this.titolo.equals(libro.titolo))
                risultato = true;
            else
                risultato = false;
        }
        return risultato;
    }
}
