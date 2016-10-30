package homework.transport;

import java.math.BigDecimal;

/**
 * Class contains data of travelling by car.
 */
public class Car implements Moveable {

    /**
     * Average speed moving by car(km per hour)
     */
    private double averageSpeed = 0.0;

    /**
     * Consumption of fuel (l per km)
     */
    private final double FUEL_CONSUMPTION = 1.0;

    /**
     * Name of the way of travelling
     */
    public static final String NAME = "Car";

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
     * Constructor creates the vehicle, set average speed,
     * fuel price
     *
     * @param averageSpeed average speed of travelling afoot
     * @param fuelPrice    fuel price
     */
    public Car(double averageSpeed, BigDecimal fuelPrice) throws Exception {
        if (averageSpeed > 0 && fuelPrice.doubleValue() > 0) {
            this.averageSpeed = averageSpeed;
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
    public void setStartCoordinates(double x, double y) {
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
    public void moveToNextCheckpoint(double x, double y) {
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
        travelCost += distance * FUEL_CONSUMPTION * fuelPrice.doubleValue();
    }

    /**
     * Method returns current travel time in special format
     *
     * @return line with current time
     */
    @Override
    public String getTravelTime() {
        return (int) (travelTime) + " hours " + Math.round((travelTime - (int) travelTime) * 60) + " minutes";
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