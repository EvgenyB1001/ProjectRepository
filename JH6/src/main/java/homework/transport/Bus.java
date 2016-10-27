package homework.transport;

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
     * Current coordinates
     */
    private double x = 0.0, y = 0.0;

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
     * Constructor creates the vehicle, set average speed, count of people,
     * fuel price
     *
     * @param averageSpeed average speed of travelling afoot
     * @param countPeople  count of people
     * @param fuelPrice    fuel price
     */
    public Bus(double averageSpeed, int countPeople, BigDecimal fuelPrice) throws Exception {
        if (averageSpeed > 0 && fuelPrice.doubleValue() > 0 && countPeople > 0) {
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
    public void setStartCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method emulates moving to the next point, which coordinates got as
     * parameters. It calculates current travel time and cost (cost depends on count of people
     * with coefficient 0.25)
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    @Override
    public void moveToNextCheckpoint(double x, double y) {
        double coordX = Math.abs(x - this.x);
        double coordY = Math.abs(y - this.y);
        this.x = x;
        this.y = y;
        travelTime += Math.sqrt(coordX * coordX + coordY * coordY) / averageSpeed;
        travelCost += Math.sqrt(coordX * coordX + coordY * coordY) * FUEL_CONSUMPTION * fuelPrice.doubleValue()
                / (0.25 * countPeople);
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
