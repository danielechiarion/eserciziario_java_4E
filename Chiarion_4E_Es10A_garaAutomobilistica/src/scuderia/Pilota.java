package scuderia;

import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Pilota {
    /* dichiaro il formato della data */
    public static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* inserimento attributi */
    private String nome;
    private String cognome;
    private String nazionalita;
    private LocalDate dataNascita;

    /* metodi get/set */
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCognome(){
        return this.cognome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public String getNazionalita(){
        return this.nazionalita;
    }
    public void setNazionalita(String nazionalita){
        this.nazionalita = nazionalita;
    }
    public LocalDate getDataNascita() {
        return this.dataNascita;
    }
    public void setDataNascita(LocalDate dataNascita){
        this.dataNascita = dataNascita;
    }

    /* metodo costruttore */
    public Pilota(String nome, String cognome, String nazionalita, LocalDate dataNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.dataNascita = dataNascita;
    }

    /* metodo che calcola l'età in base alla data di nascita fornita */
    public int calcolaEta(){
        return (int)ChronoUnit.YEARS.between(this.dataNascita, LocalDate.now());
    }

    /* override del metodo toString */
    @Override
    public String toString(){
        return String.format("Nome: %s\tCognome: %s\tNazionalità: %s\t%d anni", this.nome, this.cognome, this.nazionalita, this.calcolaEta());
    }

    /* override del metodo equals */
    @Override
    public boolean equals(Object obj){
        /* controllo prima che l'oggetto sia un'istanza della
        * classe pilota, altrimenti vuol dire che non sono uguali */
        if(!(obj instanceof Pilota))
            return false;

        Pilota pilotaConfronto = (Pilota) obj; //faccio il cast dell'oggetto

        /* ritorno il risultato del confronto */
        return this.nome.equalsIgnoreCase(pilotaConfronto.nome) && this.cognome.equalsIgnoreCase(pilotaConfronto.cognome) && this.dataNascita.isEqual(pilotaConfronto.dataNascita);
    }
}
