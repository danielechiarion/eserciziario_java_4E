package biglietti;

public enum TipoGiostra {
    ruota_panoramica("Ruota panoramica"),
    autoscontro("Autoscontri"),
    ottovolante("Ottovolante"),
    tagadà("Tagadà");

    private final String nome;

    /* metodo costruttore */
    TipoGiostra(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    /* metodo che mi ritorna l'array di
    * stringhe con i nomi delle giostre */
    public static String[] getArrayStringTipoGiostra(){
        TipoGiostra[] tipoGiostra = TipoGiostra.values();
        String[] nomiGiostre = new String[tipoGiostra.length+1];
        nomiGiostre[0] = "GIOSTRE DISPONIBILI";
        for(int i=0;i<tipoGiostra.length;i++)
            nomiGiostre[i+1] = tipoGiostra[i].nome;

        return nomiGiostre;
    }

    /* metodo che in base alla stringa generata
    * ritorna la costante dell'enumeratore trovata */
    public static TipoGiostra fromNome(String nome){
        for(TipoGiostra tipo : TipoGiostra.values()){
            if(tipo.getNome().equals(nome))
                return tipo;
        }

        return null;
    }
}
