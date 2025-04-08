package mediaPlaylist;

public interface Media{
    String play();
    String stop();
    String pausa();
    String getTitolo();
    Media clone();
    boolean equals(Object o);
}
