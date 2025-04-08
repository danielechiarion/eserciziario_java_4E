package frontend;

import parking.*;
import vehicle.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * All the frontScreen methods used
 * in the main class
 */
public class FrontScreen {
    /**
     * Method that returns a new ParkingManager
     * by the data given by the user
     * @param scanner for the input
     * @return new ParkingManager with the covered and uncovered parts
     * @throws Exception if the attributes are not valid
     */
    public static ParkingManager createParking(Scanner scanner)throws Exception{
        int maxPlacesCovered, maxPlacesUncovered;

        maxPlacesCovered = Input.safeIntInput("Inserisci il numero massimo di posti coperti: ", scanner, true);
        maxPlacesUncovered = Input.safeIntInput("Inserisci il numero massimo di posti scoperti: ", scanner, true);

        return new ParkingManager(maxPlacesCovered, maxPlacesUncovered);
    }

    /**
     * Method to add a new car to the list
     * @param carList list of cars
     * @param scanner for the input of the user
     * @throws Exception if the car already exists or if it's not possible to instantiate it
     */
    public static void addCartoList(ArrayList<Car> carList, ParkingManager parkingManager, Scanner scanner)throws Exception{
        Car inputCar = Input.readCar(scanner, true);
        if(inputCar.isReserved())
            parkingManager.addReservation();

        if(carList.contains(inputCar))
            throw new Exception("La macchina è già stata inserita");

        carList.add(inputCar);
    }

    /**
     * Method to park a car from the list givem
     * @param carList list of cars
     * @param parkingManager parking lots available
     * @param scanner for the input of the user
     * @throws Exception if the car isn't found or there's an error when the car is instantiated
     */
    public static void parkCarfromList(ArrayList<Car> carList, ParkingManager parkingManager, Scanner scanner)throws Exception{
        Car inputCar = Input.readCar(scanner, true);
        /* check if the car exists */
        if(!carList.contains(inputCar))
            throw new Exception("Macchina non trovata");

        parkingManager.addCar(carList.get(carList.indexOf(inputCar)));
        carList.remove(inputCar);
    }

    /**
     * Method that removes a car from the parking
     * @param parkingManager parking lots available
     * @param scanner for the input
     * @throws Exception if the car isn't found or there's a problem when the program tries to instantiate it
     */
    public static void removeCarFromParking(ParkingManager parkingManager, Scanner scanner)throws Exception{
        Car inputCar = Input.readCar(scanner, true);
        parkingManager.removeCar(inputCar);
    }

    /**
     * Method that displays the situation
     * of covered and uncovered parking lots
     * @param parkingManager object that contains the lots
     * @param scanner for the waiting input
     */
    public static void viewParking(ParkingManager parkingManager, Scanner scanner){
        if(!parkingManager.getCoveredParkingLot().isEmpty()){
            System.out.println("PARCHEGGIO COPERTO");
            parkingManager.getCoveredParkingLot().forEach(x -> System.out.println(x.toString()));
        }

        if(!parkingManager.getUncoveredParkingLot().isEmpty()){
            System.out.println("PARCHEGGIO SCOPERTO");
            parkingManager.getUncoveredParkingLot().forEach(x -> System.out.println(x.toString()));
        }

        Input.waitingInput(scanner);
    }

    /**
     * Method that displays the list
     * of cars yet to park
     * @param carList list of cars yet to park
     * @param scanner for the waiting input
     */
    public static void viewCarList(ArrayList<Car> carList, Scanner scanner){
        System.out.println("AUTO NON PARCHEGGIATE");
        carList.forEach(x -> System.out.println(x.toString()));

        Input.waitingInput(scanner);
    }
}
