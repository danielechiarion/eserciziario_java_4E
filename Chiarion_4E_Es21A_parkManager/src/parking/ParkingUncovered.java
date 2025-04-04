package parking;

import vehicle.Car;

import java.util.ArrayList;

public class ParkingUncovered {
    /**
     * Maximum number of spaces available
     */
    protected int maxSpaces;
    /**
     * List of cars parked
     */
    protected ArrayList<Car> lot;

    /**
     * Constructor of the covered parking that needs
     * the number of maximum spaces
     *
     * @param maxSpaces maximum spaces
     * @throws Exception if some of the attributes are not valid
     */
    public ParkingUncovered(int maxSpaces) throws Exception {
        this.setMaxSpaces(maxSpaces);
        this.lot = new ArrayList();
    }

    /**
     * Return the number of maximum spaces
     *
     * @return maximum spaces available
     */
    public int getMaxSpaces() {
        return maxSpaces;
    }

    /**
     * Method that sets the number of maximum spaces
     *
     * @param maxSpaces new value to set
     * @throws Exception if the new value is not valid (negative or 0)
     */
    public void setMaxSpaces(int maxSpaces) throws Exception {
        if (maxSpaces < 0)
            throw new Exception("Maximum spaces can't be less than 0");
        this.maxSpaces = maxSpaces;
    }

    /**
     * Returns the number of spaces available
     *
     * @return number of spaces available
     */
    public int getSpacesAvailable() {
        return this.maxSpaces - this.lot.size();
    }

    /**
     * Method that adds a car into the lot
     *
     * @param car new car to add
     * @throws Exception if the spaces are not available
     */
    public void addCar(Car car) throws Exception {
        if (this.getSpacesAvailable() <= 0)
            throw new Exception("Spaces are not available");
        this.lot.add(car);
        this.sort();
    }

    /**
     * Method that removes the car from the lot
     *
     * @param car car to add
     * @return return value of the remove method for arraylist
     */
    public boolean removeCar(Car car) {
        return this.lot.remove(car);
    }

    /* method that sorts the lot of cars */
    private void sort() {
        this.lot.sort(Car::compareTo);
    }
}
