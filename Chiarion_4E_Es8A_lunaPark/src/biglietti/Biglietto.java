package biglietti;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static utility.Tools.*;

public class Biglietto {
    private static int lastNumBiglietto = 0; //questo serve a contare il numero di biglietti venduti

    /* ATTRIBUTI */
    private int numBiglietto;
    private LocalDateTime dataIngresso;
    private LocalDateTime dataUscita;
    private ArrayList<AccessoGiostra> listaGiostre;

    /* GETTER */
    public int getNumBiglietto(){
        return this.numBiglietto;
    }
    public LocalDateTime getDataIngresso(){
        return this.dataIngresso;
    }
    public LocalDateTime getDataUscita(){
        return this.dataUscita;
    }

    /* METODO COSTRUTTORE */
    public Biglietto() {
        /* aggiorno il numero del biglietto */
        lastNumBiglietto++;
        this.numBiglietto = lastNumBiglietto;
        this.dataIngresso = LocalDateTime.now();
        this.listaGiostre = new ArrayList<>();
    }

    /* alternativa al metodo costruttore */
    public Biglietto(int numBiglietto){
        this.numBiglietto = numBiglietto;
    }

    public void aggiungiGiostra(AccessoGiostra accesso)throws Exception{
        /* controllo che l'utente non sia già uscito dal luna park */
        if(this.dataUscita != null)
            throw new Exception("Cliente già uscito");

        /* controllo che l'utente non sia
        * già salito su una giostra */
        if(this.listaGiostre.contains(accesso))
            throw new Exception("Giostra già presente");

        this.listaGiostre.add(accesso);
    }

    public void esciLunaPark()throws Exception{
        /* controllo se la persona è già
        * uscita prima di aggiornare la data */
        if(this.dataUscita != null)
            throw new Exception("Cliente già uscito");

        this.dataUscita = LocalDateTime.now(); //aggiorno la data uscita
        this.listaGiostre.clear(); //aggiorno la lista delle giostre
    }

    /* funzione che ritorna il tempo trascorso al luna park,
    * anche di chi non è già uscito. */
    public Duration tempoTrascorso(){
        if(this.dataUscita == null)
            return Duration.between(this.dataIngresso, LocalDateTime.now());

        return Duration.between(this.dataIngresso, this.dataUscita);
    }

    @Override
    public String toString(){
        String output;
        output = String.format("%05d\tData ingresso: %s", this.numBiglietto, this.dataIngresso.format(formatoData));

        /* controllo se è stata inserita una data uscita,
        * altrimenti visualizzo la lista di giostre */
        if(this.dataUscita != null){
            output += String.format("\tData uscita: %s", this.dataUscita.format(formatoData));
        }else if(!this.listaGiostre.isEmpty()){
            output += String.format("\n\nGIOSTRE UTILIZZATE");
            for(int i=0;i<this.listaGiostre.size();i++)
                output += String.format("\n%s", this.listaGiostre.get(i).toString());
        }
        /* aggiungo poi la permanenza nella giostra */
        Duration durata = this.tempoTrascorso();
        output += String.format("\n%dh %dmin %dsec", durata.toHoursPart(), durata.toMinutesPart(), durata.toSecondsPart());

        return output;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Biglietto))
            return false;

        Biglietto biglietto = (Biglietto) obj;

        return this.numBiglietto == biglietto.numBiglietto;
    }
}
