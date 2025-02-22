package backend;

import java.util.Random;

public class Dado {
    private int nFacce;

    private static Random lanciatore = new Random();

    public Dado(int nFacce){
        this.nFacce = nFacce;
    }

    public int lancia(){
        return lanciatore.nextInt(1, this.nFacce+1);
    }
}
