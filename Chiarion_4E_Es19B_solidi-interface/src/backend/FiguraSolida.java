package backend;

import java.util.Scanner;

public interface FiguraSolida {
    public double calcolaVolume();
    public double calcolaSuperficie();

    public FiguraSolida clone();
    public String toString();
}
