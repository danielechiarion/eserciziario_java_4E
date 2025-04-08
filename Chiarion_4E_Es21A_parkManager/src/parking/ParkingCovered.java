package parking;

import vehicle.*;

/**
 * Class that manages a covered parking
 * for the most important cars of the group
 */
public class ParkingCovered {
    /**
     * Covered parking lot
     */
    protected Car[] lot;
    protected int indexLot;

    /**
     * Constructor that neeed the number
     * of spaces available
     *
     * @param spaces number of spaces
     * @throws Exception if the space value is not valid
     */
    public ParkingCovered(int spaces) throws Exception {
        if (spaces <= 0)
            throw new Exception("Spaces can't be less than 1");
        this.lot = new Car[spaces];
        this.indexLot = 0;
    }

    /**
     * Method that returns the car
     * by the index given
     *
     * @param index index of the array
     * @return clone of the car
     * @throws Exception if the index is not valid
     */
    public Car getCar(int index) throws Exception {
        if (index < 0 || index >= this.lot.length)
            throw new Exception("Index can't be <0 or more than than the maximum spaces available");

        return this.lot[index].clone();
    }

    /**
     * Method that returns if the car is available
     * based on his characteristics.
     *
     * @param car car to add in the covered parking
     * @return TRUE if the car has a space available
     */
    public boolean hasCarSpaceAvailable(Car car) {
        if (car.isGpl())
            return false;

        for (Car currentCar : this.lot) {
            if (car.compareTo(currentCar) > 0)
                return true;
        }

        return false;
    }

    /**
     * Returns the numbers of spaces available
     *
     * @return numbers of spaces
     */
    public int getSpacesAvailable() {
        return this.lot.length - indexLot - 1;
    }

    /* return if the parking lot has empty spaces
     * to fill */
    private boolean hasEmptySpaces() {
        return this.lot.length > this.indexLot;
    }

    /**
     * Method that finds a car into the covered parking
     *
     * @param car car to be found
     * @return index of the array of the parking lot, -1 if the car is not found
     */
    public int findCar(Car car) {
        for (int i = 0; i < this.indexLot; i++) {
            if (this.lot[i].equals(car))
                return i;
        }

        return -1;
    }

    /* method that sorts an element of the array
     * positioned on the top or on the bottom of it
     *
     * If the parameter startPosition is:
     * - TRUE the sorting starts from the top
     * - FALSE the sorting starts from the bottom */
    private void sort(boolean startPosition) {
        Car tempCar;

        if (!startPosition) {
            for (int i = this.indexLot - 1; i > 0; i--) {
                /* the program check if it's possible to order from
                 * the top or from the bottom of the array*/
                if (this.lot[i].compareTo(this.lot[i - 1]) < 0) {
                    tempCar = this.lot[i];
                    this.lot[i] = this.lot[i - 1];
                    this.lot[i - 1] = tempCar;
                } else //if it's not possible to change the position of the new car it means that the sorting is finished
                    break;
            }
        } else {
            for (int i = 0; i < this.indexLot - 1; i++) {
                if (this.lot[i].compareTo(this.lot[i + 1]) > 0) {
                    tempCar = this.lot[i];
                    this.lot[i] = this.lot[i + 1];
                    this.lot[i + 1] = tempCar;
                } else //if it's not possible to change the position of the new car it means that the sorting is finished
                    break;
            }
        }

    }

    /**
     * Method that tries to add a car in the covered parking.
     * It returns a car to place in the uncovered parking when the
     * lot is full.
     * The method could return also the car put as a parameter if it's less
     * important than all the car placed in the covered parking lot.
     *
     * @param car car to be added
     * @return car to place in the uncovered parking, NULL if no car has to be parked
     */
    public Car addCar(Car car) {
        /* if car hasn't spaces avaible it means
         * that cannot stay on the covered park,
         * so is the car returned as the car to move into the covered parking */
        if (!this.hasCarSpaceAvailable(car))
            return car;

        Car cartoMove; //variable for the car to move

        /* that happens if the parking lot has empty spaces */
        if (this.hasEmptySpaces()) {
            this.lot[this.indexLot] = car;
            this.indexLot++;
            this.sort(false);
            cartoMove = null;
        } else {
            cartoMove = this.lot[0];
            this.lot[0] = car; //if the car has spaces avaible it must be better than the first car
            this.sort(true);
        }

        return cartoMove;
    }

    /**
     * Method that removes a car from the covered parking.
     * The method returns also if the car was found or not.
     *
     * @param car car to be removed
     * @return TRUE if the car was found, false if it wasn't
     */
    public boolean removeCar(Car car) {
        int index = this.findCar(car);
        if (index < 0)
            return false;

        for (int i = index + 1; i < this.indexLot; i++)
            this.lot[i - 1] = this.lot[i];

        this.indexLot--;
        this.lot[this.indexLot] = null;

        return true;
    }
}
