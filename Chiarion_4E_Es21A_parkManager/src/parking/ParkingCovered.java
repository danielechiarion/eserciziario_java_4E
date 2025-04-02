package parking;

import vehicle.*;

public class ParkingCovered {
    /**
     * Covered parking lot
     */
    protected Car[] lot;
    protected int indexLot;

    /**
     * Constructor that neeed the number
     * of spaces available
     * @param spaces number of spaces
     * @throws Exception if the space value is not valid
     */
    public ParkingCovered(int spaces)throws Exception{
        if(spaces<=0)
            throw new Exception("Spaces can't be less than 1");
        this.lot = new Car[spaces];
        this.indexLot = 0;
    }

    /**
     * Method that returns the car
     * by the index given
     * @param index index of the array
     * @return clone of the car
     * @throws Exception if the index is not valid
     */
    public Car getCar(int index) throws Exception{
        if(index<0 || index>=this.lot.length)
            throw new Exception("Index can't be <0 or more than than the maximum spaces available");

        return this.lot[index].clone();
    }

    /**
     * Method that returns if the car is available
     * based on his characteristics.
     * @param car car to add in the covered parking
     * @return TRUE if the car has a space available
     */
    public boolean hasCarSpaceAvailable(Car car){
        if(car.isGpl())
            return false;

        for(Car currentCar : this.lot){
            if(car.compareTo(currentCar)>0)
                return true;
        }

        return false;
    }

    /**
     * Returns the numbers of spaces available
     * @return numbers of spaces
     */
    public int getSpacesAvailable(){
        return this.lot.length-indexLot-1;
    }
}
