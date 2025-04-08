import frontend.*;
import static frontend.Tools.*;
import parking.*;
import vehicle.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* options available */
        String[] options = {
                "PARCHEGGIO",
                "Aggiungi auto",
                "Parcheggia auto",
                "Rimuovi auto parcheggio",
                "Visualizza lista auto",
                "Visualizza parcheggio",
                "Esci"
        };
        /* objects instantiation */
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> carList = new ArrayList<>();
        ParkingManager parkingManager = null;
        /* variable declaration */
        boolean check = false;

        do{
            try{
                parkingManager = FrontScreen.createParking(scanner); //method for the creation of the parking
            }catch(Exception e){
                System.out.println(e.getMessage());
                check = true;
            }
        }while(check);

        clrScr();
        check = false;
        do{
            try{
                switch (Menu(options, scanner)){
                    case 1 -> FrontScreen.addCartoList(carList, parkingManager, scanner);
                    case 2 -> FrontScreen.parkCarfromList(carList, parkingManager, scanner);
                    case 3 -> FrontScreen.removeCarFromParking(parkingManager, scanner);
                    case 4 -> FrontScreen.viewCarList(carList, scanner);
                    case 5 -> FrontScreen.viewParking(parkingManager, scanner);
                    default -> check = true;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                Wait(3);
                clrScr();
            }
        }while(!check);
    }
}
