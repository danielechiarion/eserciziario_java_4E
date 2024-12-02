package gestGara;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Cronometro {
    /* formato del tempo da stampare in output */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    /* definisco gli attributi */
    private LocalTime startTime;
    private LocalTime endTime;

    /* metodi get/set */
    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /* metodo costruttore che fa partire
    * il contatore del tempo */
    public Cronometro() {
        this.startTime = LocalTime.now();
    }

    /* metodo che assegna il tempo
    * di arrivo alla fine della gara */
    public void endTiming(){
        this.endTime = LocalTime.now();
    }

    /* metodo che indica lo stato del pilota:
    * - <0 >> non partito
    * - =0 >> in gara
    * - >0 >> terminato */
    public int timingStatus(){
        /* se non è stata impostata una data
        * di inizio */
        if(this.startTime == null)
            return -1;
        /* se non è stata impostata una data di fine */
        if(this.endTime == null)
            return 0;

        return 1; //altrimenti vuol dire che la misurazione è stata completata
    }

    /* metodo che calcola la distanza tra una misurazione
    * e l'altra */
    public Duration calculateTime(){
        if(this.timingStatus()<=0)
            return Duration.ZERO;
        return Duration.between(this.startTime, this.endTime);
    }

    /* metodo compare che confronta due
    * oggettiCronometro tra loro */
    public int compare(Cronometro cronometro){
        return this.calculateTime().compareTo(cronometro.calculateTime());
    }

    /* override del metodo toString
    * che riporta lo stato della rilevazione
    * cronometrica */
    public String toString(){
        /* in base allo stato indico
        * la situazione del cronometro */
        if(this.timingStatus()<0)
            return "Auto non partita";
        if(this.timingStatus()==0)
            return "Auto in gara";

        /* altrimenti ritorno lo stato della gara */
        Duration duration = this.calculateTime();
        return String.format("Gara terminata: %s", LocalTime.of(duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart(), duration.toMillisPart()).format(formatter));
    }
}
