package veicoli;

/* classe auto fatta solo per la ricerca */
public class AutoRicerca extends Auto{
    public AutoRicerca(int annoImmatricolazione){
        super("", "", 0.0, annoImmatricolazione, -1, false);
    }

    public AutoRicerca(int id, boolean terminator){
        super("", "", 0.0, 12, id, false);
    }

    public AutoRicerca(String marca){
        super(marca, "", 0.0, 12, -2, false);
    }

    @Override
    public String mostraDettagli(){
        return null;
    }
}
