package biglietti;

import java.time.LocalDateTime;

import static utility.Tools.*;

public class AccessoGiostra {
    private TipoGiostra giostra;
    private LocalDateTime dataOraIngresso;
    private int numGiri;

    public AccessoGiostra(TipoGiostra tipoGiostra, int numGiri){
        this.giostra = tipoGiostra;
        this.dataOraIngresso = LocalDateTime.now();
        this.numGiri = numGiri;
    }

    @Override
    public boolean equals(Object obj){
        /* controllo prima se l'oggetto può essere ricondotto
        * ad un'istanza della classe object */
        if(!(obj instanceof AccessoGiostra))
            return false;

        AccessoGiostra accessoGiostra = (AccessoGiostra) obj;

        return this.giostra.name().equals(accessoGiostra.giostra.name());
    }

    @Override
    public String toString(){
        return String.format("%s\t - \t%s\t%d giri", this.giostra.getNome(), this.dataOraIngresso.format(formatoData), this.numGiri);
    }
}
