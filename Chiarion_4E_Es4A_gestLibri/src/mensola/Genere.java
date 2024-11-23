package mensola;

public enum Genere {
    GIALLO,
    MANUALE,
    TRILLER;

    public static String[] listaGenere(){
        Genere[] generi = Genere.values();
        String[] out = new String[generi.length+1];

        out[0] = "SCEGLI GENERE";
        for(int i = 0; i < generi.length; i++)
            out[i+1] = generi[i].toString();

        return out;
    }
}