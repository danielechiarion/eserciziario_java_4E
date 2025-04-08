package parking;

import vehicle.*;

import java.util.ArrayList;

/**
 * Class that manages the whole
 * parking lot system,
 * including VIP cars and reservations
 */
public class ParkingManager {
    /**
     * Covered part of the parking lot
     */
    protected ParkingCovered parkingCovered;
    /**
     * Uncovered part of the parking lot
     */
    protected ParkingUncovered parkingUncovered;
    /**
     * Counter of the remaining reservations
     * that has to arrive in the parking lot
     */
    protected int remainingReservation;

    /**
     * Constructor of the parking manager that
     * instantiate the covered and uncovered part
     * of the parking lot
     *
     * @param maxPlacesCovered   maximum number of places covered of the parking lot
     * @param maxPlacesUncovered maximum number of places uncovered by the parking lot
     * @throws Exception if the instantiation goes wrong
     */
    public ParkingManager(int maxPlacesCovered, int maxPlacesUncovered) throws Exception {
        this.parkingCovered = new ParkingCovered(maxPlacesCovered);
        this.parkingUncovered = new ParkingUncovered(maxPlacesUncovered);
        this.remainingReservation += 1;
    }

    /**
     * Another version of the constructor that need as
     * parameters all the attributes of the Parking Manager
     *
     * @param parkingCovered       covered parking lot
     * @param parkingUncovered     uncovered parking lot
     * @param remainingReservation number of remaining reservations
     */
    public ParkingManager(ParkingCovered parkingCovered, ParkingUncovered parkingUncovered, int remainingReservation) {
        this.parkingCovered = parkingCovered;
        this.parkingUncovered = parkingUncovered;
        this.remainingReservation = remainingReservation;
    }

    /**
     * Method that returns the covered parking lot
     * @return clone of the covered parking lot
     */
    public ArrayList<Car> getCoveredParkingLot(){
        return this.parkingCovered.getLot();
    }

    /**
     * Method that returns the uncovered parking lot
     * @return clone of the uncovered parking lot
     */
    public ArrayList<Car> getUncoveredParkingLot(){
        return this.parkingUncovered.getLot();
    }

    /* method that checks if there are spaces available
     * for parking and reservation */
    private boolean hasSpacesAvailable() {
        return this.parkingCovered.getSpacesAvailable() + this.parkingUncovered.getSpacesAvailable() - this.remainingReservation > 0;
    }

    /**
     * Method that adds a car into a parking lot,
     * trying to keep the covered parking always full
     *
     * @param car car to be parked
     * @throws Exception if there is no more space available
     */
    public void addCar(Car car) throws Exception {
        if (!this.hasSpacesAvailable()) {
            throw new Exception("Space not available for a new car");
        }

        Car carToMove = this.parkingCovered.addCar(car);
        if (carToMove != null) {
            this.parkingUncovered.addCar(car);
        }

        if (carToMove != null && carToMove.isReserved())
            this.remainingReservation--;
    }

    /**
     * Method that adds a new reservation,
     * checking if there is a space available to do it
     *
     * @throws Exception if there is no more space available
     */
    public void addReservation() throws Exception {
        if (!this.hasSpacesAvailable())
            throw new Exception("Space not available for a new reservation");

        this.remainingReservation++;
    }

    /**
     * Method that removes a car from the parking lot
     *
     * @param car car to be removed
     * @throws Exception if the car is not found
     */
    public void removeCar(Car car) throws Exception {
        boolean removeStatus = true;

        if (!this.parkingCovered.removeCar(car))
            removeStatus = this.parkingUncovered.removeCar(car);

        if (!removeStatus)
            throw new Exception("Car not found");
    }
}
