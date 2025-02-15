package backend;

public enum Genere {
    horror("Horror"),
    fantastico("Fantastico"),
    serie("Serie TV");

    private final String nome;
    Genere(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public static String[] getGeneriArrayString(){
        String[] output = new String[Genere.values().length+1];
        Genere[] valori = Genere.values();

        output[0] = "GENERI THRILLER";
        for(int i=0; i<valori.length; i++)
            output[i+1] = valori[i].getNome();

        return output;
    }

    public static Genere getGenere(int pos){
        return Genere.values()[pos];
    }
}