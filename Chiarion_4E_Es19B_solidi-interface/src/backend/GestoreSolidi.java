package backend;

import java.util.ArrayList;

public class GestoreSolidi {
    private ArrayList<FiguraSolida> listaSolidi;

    public GestoreSolidi(){
        this.listaSolidi = new ArrayList<>();
    }

    public ArrayList<FiguraSolida> getListaSolidi() {
        ArrayList<FiguraSolida> listaCopia = new ArrayList<>();
        for(FiguraSolida solido : this.listaSolidi)
            listaCopia.add(solido.clone());

        return listaCopia;
    }

    public void aggiungiSolido(FiguraSolida solido){
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
