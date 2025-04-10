package mediaPlaylist;

import java.io.File;

public class Canzone extends FileMedia {
    private String titolo;
    private String artista;
    private boolean riproduzione;

    public Canzone(String filePath, String titolo, String artista) throws Exception{
        super(filePath);
        this.titolo = titolo;
        this.artista = artista;
    }

    /* GETTER E SETTER */
    public boolean isRiproduzione() {
        return riproduzione;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /* METODI */
    @Override
    public String play(){
        super.play();
        this.riproduzione = true;
        return "Canzone in riproduzione";
    }

    @Override
    public String pausa(){
        super.pausa();
        this.riproduzione = false;
        return "Canzone in pausa";
    }

    /* a differenza della pausa,
     * con lo stop non è più possibile tornare indietro
     * con la canzone */
    @Override
    public String stop(){
        super.stop();
        this.riproduzione = false;
        return "Canzone fermata";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Canzone canzone)) return false;
        return this.artista.equalsIgnoreCase(canzone.artista) && this.titolo.equalsIgnoreCase(canzone.titolo);
    }

    @Override
    public String toString() {
        String status;
        if (this.riproduzione)
            status = "In riproduzione";
        else
            status = "Non in riproduzione";

        return String.format("CANZONE: '%s' di %s\t%s", this.titolo, this.artista, status);
    }
}