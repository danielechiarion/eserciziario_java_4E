package backend;

import java.util.ArrayList;

public class Mensola {
    protected int maxLibri;
    protected ArrayList<Libro> mensola;

    /* metodo costruttore della mensola */
    public Mensola(int maxLibri) {
        this.maxLibri = maxLibri;
        this.mensola = new ArrayList<>();
    }

    /* *** GETTER AND SETTER *** */
    public int getMaxLibri() {
        return this.maxLibri;
    }
    public void setMaxLibri(int maxLibri) {
        this.maxLibri = maxLibri;
    }
    /* metodo che ritorna una copia della mensola */
    public ArrayList<Libro> getVolumi() {
        ArrayList<Libro> copiaMensola = new ArrayList<>();
        for(Libro libro : this.mensola){
            try{
                copiaMensola.add(libro.clone());
            }catch(CloneNotSupportedException e){}
        }

        return copiaMensola; //ritorno la copia della mensola
    }
    /* metodo che ritorna il numero di libri */
    public int getNPagine() {
        return this.mensola.size();
    }

    /* *** METODI RELATIVI ALLA MENSOLA *** */
    /* metodo che controlla se c'è spazio sufficiente */
    public boolean checkSpace(){
        return this.mensola.size() < this.maxLibri;
    }

    /* metodo che aggiunnge il libro alla mensola */
    public void addBook(Libro libro)throws Exception{
        /* prima di inserirlo controllo
         * se c'è spazio disponibile */
        if(!this.checkSpace())
            throw new Exception("Mensola piena");

        this.mensola.add(libro);
    }

    /* metodo che rimuove il libro dalla mensola */
    public void removeBook(Libro libro){
        this.mensola.remove(libro);
    }

    /* metodo che aggiunge un libro
     * in una determinata posizione */
    public void setInto(Libro libro, int posizione)throws IndexOutOfBoundsException{
        if(posizione<0 || posizione > this.mensola.size())
            throw new IndexOutOfBoundsException("Posizione non valida");

        this.mensola.add(posizione, libro);
    }

    /* metodo che indica se contiene
     * il libro all'interno della mensola */
    public boolean containsBook(Libro libro){
        return this.mensola.contains(libro);
    }

    /* metodo che indica se la mensola è vuota */
    public boolean isEmpty(){
        return this.mensola.isEmpty();
    }

    /* metodo che restituisce l'indice del libro
     * indicato nella mensola, -1 se il libro
     * non è presente */
    public int findLibro(Libro libro){
        return this.mensola.indexOf(libro);
    }

    /* ritorna il csv della mensola */
    public String toCSV(){
        StringBuilder output = new StringBuilder();
        output.append(Libro.getHeaderCSV());
        output.append("\n");
        for(Libro libro : this.mensola){
            output.append(libro.toCSV());
            output.append("\n");
        }

        return output.toString();
    }
}