package vehicle;

import java.io.StringWriter;
import java.util.Objects;

public class Car implements Cloneable, Comparable<Car> {
    /**
     * Constant for the conversion from KW to HP
     */
    protected final double HPCONVERSION = 1.35962;

    /* ATTRIBUTES */
    /**
     * Flag to indicate if it's VIP
     */
    boolean vip;
    /**
     * Flag to indicate if it has a GPL engine
     */
    boolean gpl;
    /**
     * Value of the car in $
     */
    double value;
    /**
     * Power of the car express in KW
     */
    double power;
    /**
     * Flag to indicate if the car has a reservation
     */
    boolean reserved;

    /* METHODS */

    /**
     * Constructor that instantiate a Car with all the
     * attributes needed
     *
     * @param vip      flag to indicate if it's a VIP car
     * @param gpl      flag to indicate if the car has a GPL engine
     * @param value    money value of the car
     * @param power    power of the engine expressed in KW
     * @param reserved flag to indicate if the car has a reserved space in the parking lot
     * @throws Exception if some of the attributes are not set correctly
     */
    public Car(boolean vip, boolean gpl, double value, double power, boolean reserved) throws Exception {
        this.setVip(vip);
        this.setGpl(gpl);
        this.setValue(value);
        this.setPower(power);
        this.setReserved(reserved);
    }

    /**
     * Constructor that instantiate a Car and sets the
     * reserved flag to FALSE automatically
     *
     * @param vip   flag to indicate if it's a VIP car
     * @param gpl   flag to indicate if the car has a GPL engine
     * @param value flag to indicate if the car has a GPL engine
     * @param power power of the engine expressed in KW
     * @throws Exception if some of the attributes are not set correctly
     */
    public Car(boolean vip, boolean gpl, double value, double power) throws Exception {
        this.setVip(vip);
        this.setGpl(gpl);
        this.setValue(value);
        this.setPower(power);
        this.setReserved(false);
    }

    /* GETTER AND SETTER */

    /**
     * Return if the car is of a VIP
     *
     * @return value of the VIP flag
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * Set the VIP flag
     *
     * @param vip new value of the flag
     */
    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     * Return if the car has a GPL engine
     *
     * @return value of the gpl flag
     */
    public boolean isGpl() {
        return gpl;
    }

    /**
     * Set the gpl flag
     *
     * @param gpl new value of the gpl flag
     */
    public void setGpl(boolean gpl) {
        this.gpl = gpl;
    }

    /**
     * Return the money value of the car
     *
     * @return value of the car in $
     */
    public double getValue() {
        return value;
    }

    /**
     * Set the new value of the car
     *
     * @param value new value of the car
     * @throws Exception if the new value in not valid (negative or 0)
     */
    public void setValue(double value) throws Exception {
        if (value <= 0)
            throw new Exception("Car value can't be negative or 0");
        this.value = value;
    }

    /**
     * Return the power of the car in KW
     *
     * @return power of the car
     */
    public double getPowerKW() {
        return power;
    }

    /**
     * Return the power of the car in HP
     *
     * @return power of the car
     */
    public double getPowerHP() {
        return this.power * HPCONVERSION;
    }

    /**
     * Sets the new power of the car
     *
     * @param power new power of the car
     * @throws Exception if the new value is not valid (negative)
     */
    public void setPower(double power) throws Exception {
        if (power < 0)
            throw new Exception("Engine power can't be less than 0");
        this.power = power;
    }

    /**
     * Returns if the parking is reserved
     *
     * @return flag of the reservation
     */
    public boolean isReserved() {
        return reserved;
    }

    /**
     * Sets the flag of the reservation
     *
     * @param reserved new status of the reservation
     */
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    /* OTHER METHODS */
    public Car clone() {
        try {
            return new Car(this.vip, this.gpl, this.value, this.power, this.reserved);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Method that compares two cars based on:
     * - VIP status
     * - value of the car
     * - power of the car
     * The comparison happens following the attributes
     * in this order
     *
     * @param another the object to be compared.
     * @return -1 if this object comes before the first, 0 if they are equal, 1 if this object comes after the other one
     */
    public int compareTo(Car another) {
        if (this.vip != another.vip && this.vip)
            return 1;
        else if (this.vip != another.vip)
            return -1;

        if (this.value != another.value)
            return Double.compare(this.value, another.value);

        return Double.compare(this.power, another.power);
    }

    /**
     * toString of the car
     *
     * @return formatted string with the attributes of the car
     */
    @Override
    public String toString() {
        return String.format("Value: %.2f€\tPower: %.0fKW/%.0fHP\tVIP: %b\tReserved: %b\tGPL: %b",
                this.value, this.getPowerKW(), this.getPowerHP(), this.vip, this.reserved, this.gpl);
    }

    /**
     * Returns if the two cars are equal
     *
     * @param object object to be compared
     * @return TRUE if the two cars are equal
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Car car)) return false;
        return vip == car.vip && gpl == car.gpl && Double.compare(value, car.value) == 0 && Double.compare(power, car.power) == 0 && reserved == car.reserved;
    }
}
