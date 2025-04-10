package mediaPlaylist;

import java.util.Objects;

public class Video implements Media, Cloneable{
    private String titolo;
    private int durata; //espressa in minuti
    private boolean riproduzione;

    public Video(String titolo, int durata) throws Exception{
        this.setTitolo(titolo);
        this.setDurata(durata);
        this.riproduzione = false;
    }

    /* GETTER E SETTER */
    @Override
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) throws Exception{
        if(durata <= 0)
            throw new Exception("Durata non valida");
        this.durata = durata;
    }

    public boolean isRiproduzione() {
        return riproduzione;
    }

    /* METODI */
    @Override
    public String play(){
        this.riproduzione = true;
        return "Video in riproduzione";
    }

    @Override
    public String stop(){
        this.riproduzione = false;
        return "Video fermato";
    }

    /* la differenza tra la pausa e lo stop
     * è che lo stop non permette di riprodurre in seguito la canzone,
     * la pausa sì */
    @Override
    public String pausa(){
        this.riproduzione = false;
        return "Video pausa";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Video video)) return false;
        return this.durata == video.durata && this.titolo.equalsIgnoreCase(video.titolo);
    }

    @Override
    public String toString() {
        String status;
        if(this.riproduzione)
            status = "In riproduzione";
        else
            status = "Non in riproduzione";
        return String.format("VIDEO: %s - %d min\t%s", this.titolo, this.durata, status);
    }

    @Override
    public Video clone(){
        try{
            return (Video) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}