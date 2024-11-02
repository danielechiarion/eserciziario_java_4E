package gestPazienti;

import javax.naming.event.ObjectChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Iterator;

public class Paziente {
    private String nome;
    private String cognome;
    private Reparto reparto;
    private LocalDateTime dataInizioRicovero;
    private LocalDateTime dataDimissione;
    private ArrayList<Termometro> listaTemperatura;

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public Reparto getReparto() {
        return this.reparto;
    }

    public LocalDateTime getDataInizioRicovero() {
        return this.dataInizioRicovero;
    }

    public LocalDateTime getDataDimissione() {
        return this.dataDimissione;
    }

    public ArrayList<Termometro> getListaTemperatura() {
        return this.listaTemperatura;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setReparto(Reparto reparto){
        this.reparto = reparto;
    }

    /* metodo costruttore */
    public Paziente(String nome, String cognome, Reparto reparto){
        this.nome = nome;
        this.cognome = cognome;
        this.reparto = reparto;
        this.dataInizioRicovero = LocalDateTime.now();

        this.listaTemperatura = new ArrayList<>();
    }

    /* metodo per la dimissione del paziente */
    public void dimettiPaziente()throws Exception{
        /* controllo se il paziente è già stato dimesso */
        if(!this.isRicoverato())
            throw new Exception("Paziente già dimesso");

        this.dataDimissione = LocalDateTime.now();
    }

    /* restituisce se il paziente è attualmente in ricovero
    * oppure no */
    public boolean isRicoverato(){
        if(dataDimissione==null)
            return true;

        return false;
    }

    /* metodo che aggiunge misurazione
    * alla scheda del paziente */
    public void addMisurazione()throws Exception{
        /* controllo che il paziente non sia già stato dimesso */
        if(!this.isRicoverato())
            throw new Exception("Paziente già dimesso");

        Termometro termometro = new Termometro();
        termometro.misuraTemperatura();
        this.listaTemperatura.add(termometro);
    }

    /* metodo che rimuove le misurazioni
    * in base all'intervallo inserito */
    public void removeMisurazioni(LocalDateTime dataInizio, LocalDateTime dataFine){
        Iterator iteratoreMisure = this.listaTemperatura.iterator();
        while(iteratoreMisure.hasNext()){
            Termometro termometro = (Termometro) iteratoreMisure.next();
            if(termometro.getDataMisura().isBefore(dataFine) && termometro.getDataMisura().isAfter(dataInizio) || termometro.getDataMisura().isEqual(dataInizio) || termometro.getDataMisura().isEqual(dataFine))
                iteratoreMisure.remove();
        }
    }

    /* metodo che fa rientrare un paziente
    * in ricovero */
    public void rientroPaziente(Reparto reparto)throws Exception{
        /* prima controllo se il paziente è già ricoverato */
        if(this.isRicoverato())
            throw new Exception("Paziente già ricoverato");

        this.reparto = reparto;
        this.dataInizioRicovero = LocalDateTime.now();
        this.dataDimissione = null;
    }

    /* toString del paziente */
    public String toString(boolean dettaglio){
        /* trasformo in stringa tutte le misurazioni effettuate */
        String listaTemperatura = "";
        if(dettaglio && !this.listaTemperatura.isEmpty()){
            for(Termometro termometro : this.listaTemperatura)
                listaTemperatura += String.format("%s\n", termometro.toString());
        }

        /* imposto un DateTimeFormatter per stampare la data */
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        /* inserisco i dati generali di un paziente */
        String output = String.format("Nome: %s\tCognome: %s\tReparto: %s\nData inizio ricovero: %s\n", this.nome, this.cognome, this.reparto.toString(), this.dataInizioRicovero.format(dt));
        if(!this.isRicoverato()) //controllo se è possibile inserire la data di dimissione
            output += String.format("Data dimissione: %s\n", this.dataDimissione.format(dt));
        output += listaTemperatura; //aggiungo infine le temperature misurate

        return output;
    }

    /* ovverride del metodo equals */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Paziente))
            return false;

        Paziente pazienteConfronto = (Paziente) obj;

        return this.nome.equals(pazienteConfronto.nome) && this.cognome.equals(pazienteConfronto.cognome);
    }
}
