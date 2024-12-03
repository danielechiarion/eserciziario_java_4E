package gestGara;

public class Auto {
    /* dichiatarazione attributi */
    public Pilota pilota;
    public String nomeScuderia;
    public int cilindrata;
    public Cronometro cronometro;

    /* metodi get e set */

    public Pilota getPilota() {
        return this.pilota;
    }

    public void setPilota(Pilota pilota) {
        this.pilota = pilota;
    }

    public String getNomeScuderia() {
        return this.nomeScuderia;
    }

    public void setNomeScuderia(String nomeScuderia) {
        this.nomeScuderia = nomeScuderia;
    }

    public int getCilindrata() {
        return this.cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Cronometro getCronometro() {
        return this.cronometro;
    }
    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
    }

    /* metodo costruttore */
    public Auto(String nomeScuderia, int cilindrata, Pilota pilota){
        this.nomeScuderia = nomeScuderia;
        this.cilindrata = cilindrata;
        this.pilota = pilota;
        this.cronometro = new Cronometro();
        this.cronometro.setStartTime(null); //imposto il tempo di inizio a null
    }

    /* metodo che inizia il conteggio del cronometro */
    public void avviaCronometro(){
        this.cronometro = new Cronometro();
    }

    /* metodo che termina il conteggio del cronometro */
    public void finisciCronometro(){
        this.cronometro.endTiming();
    }

    /* override del metodo toString */
    @Override
    public String toString(){
        return String.format("%s\t%dcc\n%s\n%s", this.nomeScuderia, this.cilindrata, this.pilota.toString(), this.cronometro.toString());
    }

    /* override del metodo equals */
    @Override
    public boolean equals(Object obj){
        /* controllo se l'oggetto è un'istanza della classe
        * auto */
        if(!(obj instanceof Auto))
            return false;

        /* altrimenti faccio il cast dell'oggetto
        * e confronto tutti i suoi attributi */
        Auto autoConfronto = (Auto) obj;

        return this.cilindrata == autoConfronto.cilindrata && this.nomeScuderia.equalsIgnoreCase(autoConfronto.nomeScuderia) && this.pilota.equals(autoConfronto.pilota);
    }
}
