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
        return String.format("Autore: %s\tTitolo: %s\tNumero di pagine: %d\tGenere: %s:\tData pubblicazione: %s\tCosto: %d",
                this.autore, this.titolo, this.numPagine, this.tipologia.toString(), this.dataPubblicazione.format(formattazioneData), this.costoPerPagina*this.numPagine);
    }
}
