package mediaPlaylist;

import java.io.*;
import java.nio.file.*;
import javax.sound.sampled.*;

public abstract class FileMedia implements Media, Cloneable{
    private String filePath;
    private Clip clip;

    public FileMedia(String filePath)throws Exception{
        this.setFilePath(filePath);
        this.setClip(this.filePath);
    }

    public String getFilePath(){
        return this.filePath;
    }

    private void setFilePath(String filePath)throws FileNotFoundException{
        if(!Files.exists(Paths.get(this.filePath)))
            throw new FileNotFoundException("Percorso non trovato");

        this.filePath = filePath;
    }

    private void setClip(String filePath)throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File file = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        this.clip = AudioSystem.getClip();
    }

    @Override
    public String play(){
        this.clip.start();
        return null;
    }

    @Override
    public String pausa(){
        this.clip.stop();
        return null;
    }

    @Override
    public String stop(){
        this.clip.stop();
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof FileMedia fileMedia)) return false;
        return this.filePath.equals(fileMedia.filePath);
    }

    @Override
    public abstract String getTitolo();

    @Override
    public boolean isRiproduzione(){
        return this.clip.isRunning();
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
