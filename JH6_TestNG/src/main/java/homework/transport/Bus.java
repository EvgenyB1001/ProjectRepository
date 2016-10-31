package homework.transport;

import homework.Validation;

import java.math.BigDecimal;

/**
 * Class contains data of travelling by bus.
 */
public class Bus implements Moveable {

    /**
     * Average speed moving by bus(km per hour)
     */
    private double averageSpeed = 0.0;

    /**
     * Consumption of fuel (l per km)
     */
    private final double FUEL_CONSUMPTION = 0.1;

    /**
     * Name of the way of travelling
     */
    public static final String NAME = "Bus";

    /**
     * Count of people in bus
     */
    private int countPeople = 0;

    /**
     * Price of fuel in USD
     */
    private BigDecimal fuelPrice = new BigDecimal(0.0);

    /**
     * Current travel time (hours)
     */
    private double travelTime = 0.0;

    /**
     * Current cost of travel (USD)
     */
    private double travelCost = 0.0;

    /**
     * Object, that calculate distance
     */
    private Router router = new Router();

    /**
     * Object, that validates parameters
     */
    private Validation validation = new Validation();

    /**
     * Constructor creates the vehicle, set average speed, count of people,
     * fuel price
     *
     * @param averageSpeed average speed of travelling afoot
     * @param countPeople  count of people
     * @param fuelPrice    fuel price
     */
    public Bus(double averageSpeed, int countPeople, BigDecimal fuelPrice) throws Exception {
        if (averageSpeed > 0 && averageSpeed < Double.POSITIVE_INFINITY && fuelPrice.doubleValue() > 0
                && fuelPrice.doubleValue() < Double.POSITIVE_INFINITY && countPeople > 0) {
            this.averageSpeed = averageSpeed;
            this.countPeople = countPeople;
            this.fuelPrice = fuelPrice;
        } else {
            throw new Exception("Incorrect parameters");
        }
    }

    /**
     * Method sets start coordinates of travelling
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    @Override
    public void setStartCoordinates(double x, double y) throws Exception {
        validation.validationCoordinates(x,y);
        router.setStartCoordinates(x, y);
    }

    /**
     * Method emulates moving to the next point, which coordinates got as
     * parameters. It calculates current travel time and cost (cost depends on count of people
     * with coefficient 0.5)
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    @Override
    public void moveToNextCheckpoint(double x, double y) throws Exception {
        validation.validationCoordinates(x, y);
        double distance = router.getDistance(x, y);
        addAnotherTravelCost(distance);
        addAnotherTravelTime(distance);
    }
    /**
     * Method adds travel time
     *
     * @param distance another distance
     */
    private void addAnotherTravelTime(double distance) {
        travelTime += distance / averageSpeed;
    }

    /**
     * Method adds travel cost
     *
     * @param distance another distance
     */
    private void addAnotherTravelCost(double distance) {
        travelCost += distance * FUEL_CONSUMPTION * fuelPrice.doubleValue()
                / (0.25 * countPeople);
    }

    /**
     * Method returns current travel time
     *
     * @return current time
     */
    @Override
    public double getTravelTime() {
        return travelTime;
    }

    /**
     * Method returns current cost of travel
     *
     * @return cost of travel
     */
    @Override
    public double getTravelCost() {
        return travelCost;
    }

    /**
     * Method returns name of vehicle
     *
     * @return name of vehicle
     */
    public static String getName() {
        return NAME;
    }
}