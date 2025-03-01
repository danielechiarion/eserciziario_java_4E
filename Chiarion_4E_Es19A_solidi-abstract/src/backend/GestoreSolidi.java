package backend;

import java.util.ArrayList;

public class GestoreSolidi {
    private ArrayList<Solido> listaSolidi;

    public GestoreSolidi(){
        this.listaSolidi = new ArrayList<>();
    }

    public ArrayList<Solido> getListaSolidi() {
        ArrayList<Solido> listaCopia = new ArrayList<>();
        for(Solido solido : this.listaSolidi)
            listaCopia.add(solido.clone());

        return listaCopia;
    }

    public void aggiungiSolido(Solido solido){
        this.listaSolidi.add(solido);
    }

    public String[] nomiSolidi(){
        /* prima controllo se l'array è null */
        if(this.listaSolidi.isEmpty())
            return null;

        String[] nomiSolidi = new String[this.listaSolidi.size()];
        for(int i = 0; i < this.listaSolidi.size(); i++)
            nomiSolidi[i] = this.listaSolidi.get(i).toString();

        return nomiSolidi;
    }
}
