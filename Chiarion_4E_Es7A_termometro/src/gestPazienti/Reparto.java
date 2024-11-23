package gestPazienti;

public enum Reparto{
    Ortopedia,
    Geriatria,
    Pediatria,
    Chirurgia,
    Neurologia,
    ORL;

    /* ritorna un array di stringhe
    * con i nomi dei reparti */
    public static String[] stampaReparto(){
        Reparto[] reparti = Reparto.values();
        String[] nomiReparto = new String[reparti.length + 1];

        nomiReparto[0] = "SCEGLI REPARTO";
        for(int i=1;i<nomiReparto.length;i++)
            nomiReparto[i] = reparti[i-1].name();

        return nomiReparto;
    }
}
