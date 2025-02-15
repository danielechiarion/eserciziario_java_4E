package plesso;

import personale.*;

import java.util.ArrayList;

public class Istituto {
    private ArrayList<Dipendente> listaDipendenti;
    private String nomeIstituto;

    public Istituto(String nomeIstituto) {
        this.nomeIstituto = nomeIstituto;
        this.listaDipendenti = new ArrayList<>();
    }

    public String getNomeIstituto() {
        return nomeIstituto;
    }

    public void setNomeIstituto(String nomeIstituto) {
        this.nomeIstituto = nomeIstituto;
    }

    public void addDipendente(Dipendente dipendente) {
        this.listaDipendenti.add(dipendente);
    }

    public String toString(){
        return String.format("%s", this.getNomeIstituto());
    }

    public void stampaDipendenti(){
        this.listaDipendenti.forEach(x -> System.out.println(x.toString()));
    }

    public String chiSei(Dipendente d){
        //System.out.println(d.getClass().getName());
        if(d instanceof Impiegato)
            return "Sono un impiegato";
        if(d instanceof Docente)
            return "Sono un docente";

        return "Sono un dipendente";
    }

    public String[] tipoDipendenti(){
        String[] output = new String[this.listaDipendenti.size()];

        for(int i = 0; i < this.listaDipendenti.size(); i++)
            output[i] = this.listaDipendenti.get(i).getClass().getSimpleName() + "\t"+this.listaDipendenti.get(i).getNominativo();

        return output;
    }
}
