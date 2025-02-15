package backend;

public enum Livello {
    base,
    medio,
    avanzato;

    public static String[] getLivelliArrayString(){
        String[] output = new String[Livello.values().length+1];
        Livello[] valori = Livello.values();

        output[0] = "LIVELLI MANUALE";
        for(int i=0; i<valori.length; i++)
            output[i+1] = valori[i].toString();

        return output;
    }

    public static Livello getLivello(int pos){
        return Livello.values()[pos];
    }
}
