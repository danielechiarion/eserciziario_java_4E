package tempo;

import java.time.Duration;
import java.time.LocalTime;

public class Cronometro {
    private LocalTime startTime;
    private LocalTime endTime;
    private int tempoGiro;

    public Cronometro(){
        this.tempoGiro = -1;
        this.startTime = null;
        this.endTime = null;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getTempoGiro() {
        return tempoGiro;
    }

    /* imposta il tempo di avvio */
    public void setStartTime() {
        this.startTime = LocalTime.now();
    }

    /* imposta il tempo di arrivo */
    public void setEndTime() {
        this.endTime = LocalTime.now();
        this.calcolaTempoGiro(); //calcola il tempo finale
    }

    /* metodo che resetta il tempo inserito */
    public void resetTime(){
        this.startTime = null;
        this.endTime = null;
        this.tempoGiro = -1;
    }

    /* metodo privato che calcola il tempo */
    private void calcolaTempoGiro(){
        this.tempoGiro = (int)Duration.between(this.startTime, this.endTime).toSeconds();
    }

    @Override
    public String toString(){
        if(this.tempoGiro<0)
            return "Tempo non registrato";
        return String.format("%s", this.tempoGiro);
    }
}