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
}
