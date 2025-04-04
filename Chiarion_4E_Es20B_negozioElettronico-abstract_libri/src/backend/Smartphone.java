package backend;

public class Smartphone extends ProdottoElettronico{
    private String modello;
    private int memoria; //la memoria è in GB

    /* override del metodo costruttore */
    public Smartphone(String codiceProdotto, double prezzo, String marca, String modello, int memoria)throws Exception{
       super(codiceProdotto, prezzo, marca);
       this.setModello(modello);
       this.setMemoria(memoria);
    }

    /* GETTER e SETTER */
    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) throws Exception{
        /* controllo se la memoria è minore di 0,
        * così da lanciare un'eccezione */
        if(memoria<=0){
            throw new Exception("Memoria non valida. Deve essere positiva");
        }
        this.memoria = memoria;
    }

    /* override del metodo toString */
    @Override
    public String toString(){
        return String.format("Smartphone: %s\nModello: %s\tMemoria: %dGB", super.toString(), this.modello, this.memoria);
    }
}
