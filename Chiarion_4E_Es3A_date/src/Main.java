import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate dataLocale = LocalDate.now(); //classe dove all'interno dove sono definiti metodi statici

        System.out.println("Data: "+dataLocale);
        //---------------------------------------------------------------------------------------------------------------
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd.MM.yyyy"); //imposto il formatter della stringa della data
        System.out.println(dataLocale.format(dt)); //stampa con il formato stabilito
        System.out.printf("Data: %s"+"\n", dataLocale.format(DateTimeFormatter.ofPattern("dd!MM!!yyyy")));
        //---------------------------------------------------------------------------------------------------------------
        String dataString = dataLocale.format(dt);
        dataLocale=LocalDate.parse(dataString,dt); //torna al formato stringa originale
        System.out.println(dataLocale);
        //---------------------------------------------------------------------------------------------------------------
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Inserisci la data (gg/mm/aaaa)");
        String input = keyboard.nextLine();
        dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNew = LocalDate.parse(input,dt);
        System.out.println(dataNew);
        //---------------------------------------------------------------------------------------------------------------
        String timeString = "10:32:11";
        LocalTime ora = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(ora);
        //---------------------------------------------------------------------------------------------------------------
        dataLocale = LocalDate.of(2024,8,12);
        System.out.println(dataLocale);

        int anno, mese, giorno;
        anno = dataLocale.getYear();
        mese = dataLocale.getMonthValue();
        giorno = dataLocale.getDayOfMonth();
        System.out.printf("Data gg/mm/aaaa: %d/%d/%d\nGiorni mese: %d\n",
                anno, mese, giorno, dataLocale.lengthOfMonth());

        if(dataLocale.isLeapYear())
            System.out.println("Anno bisestile");
        else
            System.out.println("Anno non bisestile");

        //---------------------------------------------------------------------------------------------------------------
        LocalDate data2 = LocalDate.of(2024,8,10);
        if(data2.equals(dataLocale))
            System.out.println("Date uguali");
        else
            System.out.println("Date non uguali");
    }
}
