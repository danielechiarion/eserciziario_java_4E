package edifici;

import java.util.ArrayList;

import veicoli.*;
public class Concessionario {
    /* ATTRIBUTI */
    private ArrayList<Auto> showRoom;

    /* COSTRUTTORI */
    public Concessionario(){
        this.showRoom = new ArrayList<>();
    }

    /* GETTER E SETTER */
    public ArrayList<Auto> getShowRoom(){
        ArrayList<Auto> copia = new ArrayList<>();
        for(Auto autoCorrente: this.showRoom)
            copia.add(autoCorrente.clone());

        return copia;
    }

    public Auto getAuto(int index)throws Exception{
        if(index<0 || index>=this.showRoom.size())
            throw new Exception("Veicolo non trovato");
        return this.showRoom.get(index).clone();
    }

    public int indexOf(Auto auto){
        return this.showRoom.indexOf(auto);
    }

    public boolean contains(Auto auto){
        return this.showRoom.contains(auto);
    }

    /* ALTRI METODI */
    public ArrayList<Auto> ricerca(String marca){
        ArrayList<Auto> risultato = new ArrayList<>();
        AutoRicerca autoRicerca = new AutoRicerca(marca);
        for(Auto autoCorrente : this.showRoom){
            if(autoCorrente.equals(autoRicerca))
                risultato.add(autoCorrente.clone());
        }

        return risultato;
    }

    public ArrayList<Auto> ricerca(int annoImmatricolazione){
        ArrayList<Auto> risultato = new ArrayList<>();
        AutoRicerca autoRicerca = new AutoRicerca(annoImmatricolazione);
        for(Auto autoCorrente : this.showRoom){
            if(autoCorrente.compareTo(autoRicerca)>=0)
                risultato.add(autoCorrente.clone());
        }

        return risultato;
    }

    public void aggiungiAuto(Auto auto)throws Exception{
        if(this.showRoom.contains(auto))
            throw new Exception("Auto già inserita");

        this.showRoom.add(auto);
    }

    public void rimuoviAuto(Auto auto)throws Exception{
        if(!this.showRoom.contains(auto))
            throw new Exception("Auto non trovata");

        this.showRoom.remove(auto);
    }

    public void cambiaAuto(int index, Auto auto)throws Exception {
        if (index < 0)
            throw new Exception("Auto non trovata");

        this.showRoom.set(index, auto);
    }
}
