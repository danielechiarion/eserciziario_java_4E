package gestPazienti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.time.LocalDateTime;

public class Termometro {
    private static final int temperaturaReset = 36;
    private double temperatura;
    private LocalDateTime dataMisura;

    public double getTemperatura() {
        return this.temperatura;
    }

    public LocalDateTime getDataMisura() {
        return this.dataMisura;
    }

    public void setDataMisura(LocalDateTime dataMisura) {
        this.dataMisura = dataMisura;
    }

    /* metodo costruttore */
    public Termometro() {
        this.temperatura = temperaturaReset;
    }

    /* metodo per misurare una temperatura */
    public double misuraTemperatura() {
        this.dataMisura = LocalDateTime.now(); //imposto data e ora misurazione

        Random random = new Random();
        return random.nextDouble(36, 41);
    }

    @Override
    public String toString() {
        /* imposto un DateTimeFormatter per stampare la data */
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("Temperatura: %.1f - %s", this.temperatura, this.dataMisura.format(dt));
    }

    @Override
    public boolean equals(Object obj) {
        /* controllo che l'oggetto sia un'istanza
         * della classe, altrimenti restituisco false */
        if (!(obj instanceof Termometro))
            return false;

        Termometro termometroVerifica = (Termometro) obj; //faccio cast dell'object

        return this.temperatura == termometroVerifica.temperatura && this.dataMisura.equals(termometroVerifica.dataMisura);
    }

    /* metodo che compara una temperatura con un altra,
    * tenendo conto della data di misurazione e del valore riscontrato */
    public int compare(Termometro termometro) {
        return this.dataMisura.compareTo(termometro.dataMisura);
    }
}
