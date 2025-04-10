package playlist;

import java.io.File;
import java.util.ArrayList;

import mediaPlaylist.*;

public class GestionePlayer {
    private ArrayList<FileMedia> playlist;
    private int currentIndex;

    public GestionePlayer(){
        this.playlist = new ArrayList<>();
        this.currentIndex = 0;
    }

    /* GETTER */
    public ArrayList<FileMedia> getPlaylist() {
        ArrayList<FileMedia> clone = new ArrayList<>();
        for(FileMedia currentMedia : this.playlist)
            clone.add(currentMedia.clone());

        return clone;
    }

    /* ALTRI METODI */
    public void aggiungiMedia(FileMedia media)throws Exception{
        if(this.playlist.contains(media))
            throw new Exception("Media già inserito");

        this.playlist.add(media);
    }

    public void rimuoviMedia(FileMedia media)throws Exception{
        if(!this.playlist.contains(media))
            throw new Exception("Media non trovato");
        if(this.playlist.get(this.playlist.indexOf(media)).isRiproduzione())
            throw new Exception("Impossibile eliminare. Media in riproduzione");

        this.playlist.remove(media);
    }

    public String riproduciMedia(FileMedia media)throws Exception{
        if(!this.playlist.contains(media))
            throw new Exception("Media non trovato");

        this.currentIndex = this.playlist.indexOf(media);
        return this.playlist.get(this.currentIndex).play();
    }

    private void nextIndex(){
        if(this.currentIndex<this.playlist.size()-1)
            this.currentIndex++;
        else
            this.currentIndex = 0;
    }

    public String riproduciMedia()throws Exception{
        if(this.playlist.isEmpty())
            throw new Exception("Nessun media trovato");
        return this.playlist.get(this.currentIndex).play();
    }

    public String pausaMedia(){
        return this.playlist.get(this.currentIndex).pausa();
    }

    public String stopMedia()throws Exception{
        if(this.playlist.isEmpty())
            throw new Exception("Nessun media trovato");

        String output = this.playlist.get(this.currentIndex).stop();
        this.nextIndex();
        return output;
    }

    public String prossimoMedia()throws Exception{
        if(this.playlist.isEmpty())
            throw new Exception("Nessun media trovato");


        this.stopMedia(); //effettuo prima uno stop del media che è in riproduzione
        return this.playlist.get(this.currentIndex).play();
    }
}