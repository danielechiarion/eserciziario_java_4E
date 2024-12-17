package gestGara;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.format.DateTimeFormatter;

public class Gara {
    /* array di valori costanti da assegnare agli arrivati */
    private final int[] punteggio = {25,17,15,12,10,8,6,4,2,1};
    /* creo il comparatore per visualizzare
     * la classifica finale */
    private static Comparator<Auto> comparatoreAuto = new Comparator<Auto>() {
        /* comparo le auto in base alla classifica finale */
        @Override
        public int compare(Auto o1, Auto o2) {
            return o1.getCronometro().compare(o2.getCronometro());
        }
    };
    /* creo il formatter per la data */
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* attributi */
    private String nomeCircuito;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private ArrayList<Auto> listaAuto;

    public String getNomeCircuito() {
        return this.nomeCircuito;
    }

    public void setNomeCircuito(String nomeCircuito) {
        this.nomeCircuito = nomeCircuito;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public ArrayList<Auto> getListaAuto(){
        return this.listaAuto;
    }

    /* METODI */
    public Gara(String nomeCircuito){
        this.nomeCircuito = nomeCircuito;
        this.dataInizio = LocalDate.now();
        this.dataFine = null;

        this.listaAuto = new ArrayList<>();
    }

    /* metodo per aggiungere un auto ad una gara */
    public void aggiungiAuto(Auto auto)throws Exception{
        if(this.listaAuto.contains(auto))
            throw new Exception("Auto già inserita");
        this.listaAuto.add(auto);
    }

    /* metodo per la stampa della classifica */
    public String[] toArrayStringClassifica(){
        /* controllo subito se la lista di auto inserite è vuota */
        if(this.listaAuto.isEmpty())
            return null;

        /* ordino la lista secondo gli arrivi */
        this.listaAuto.sort(comparatoreAuto);
        /* creo l'array e lo popolo */
        String[] array = new String[this.listaAuto.size()];
        for(int i=0;i<this.listaAuto.size();i++)
            array[i] = String.format("%d^) %s", (i+1), this.listaAuto.get(i).toString());

        return array; //ritorno l'array
    }

    /* metodo che imposta il punteggio della classifica */
    public void assegnaPunteggio(){
        this.listaAuto.sort(comparatoreAuto); //prima ordino la classifica

        for(int i=0;i<punteggio.length && i<this.listaAuto.size();i++)
            this.listaAuto.get(i).setPunti(this.listaAuto.get(i).getPunti()+punteggio[i]);
    }

    public void terminaGara(){
        this.dataFine = LocalDate.now();
    }

    /* override del metodo toString */
    @Override
    public String toString(){
        String formatDataFine;
        if(this.dataFine == null)
            formatDataFine = "//";
        else
            formatDataFine = this.dataFine.format(dateTimeFormatter);
        return String.format("Circuito: %s\tData inizio: %s\tData fine: %s",
                this.nomeCircuito, this.dataInizio.format(dateTimeFormatter), formatDataFine);
    }

    /* metodo equals, che confronta l'uguaglianza delle
    * gare in base al circuito e al periodo */
    @Override
    public boolean equals(Object object){
        if(!(object instanceof Gara))
            return false;

        Gara garaConfronto = (Gara)object;

        if(!this.nomeCircuito.equalsIgnoreCase(garaConfronto.nomeCircuito))
            return false;
        if(this.dataInizio!=null && !this.dataInizio.equals(garaConfronto.dataInizio))
            return false;
        if(this.dataFine!= null && !this.dataFine.equals(garaConfronto.dataFine))
            return false;

        return true;
    }
}
