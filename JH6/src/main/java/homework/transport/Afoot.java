package homework.transport;

/**
 * Class contains data of travelling afoot.
 */
public class Afoot implements Moveable {

    /**
     * Average speed moving afoot(km per hour)
     */
    private double averageSpeed = 0.0;

    /**
     * Name of the way of travelling
     */
    public static final String NAME = "Afoot";

    /**
     * Current coordinates
     */
    private double x = 0.0, y = 0.0;

    /**
     * Current travel time (hours)
     */
    private double travelTime = 0.0;

    /**
     * Constructor creates the vehicle, set average speed
     *
     * @param averageSpeed average speed of travelling afoot
     */
    public Afoot(double averageSpeed) throws Exception {
        if (averageSpeed > 0) {
            this.averageSpeed = averageSpeed;
        } else {
            throw new Exception("Incorrect speed \"" + averageSpeed + "\"");
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
     * parameters. It calculates current travel time
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
        travelTime += (Math.sqrt(coordX * coordX + coordY * coordY) / averageSpeed);
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
     * Method returns cost of travel. Travelling afoot doesn't waste any resources, so method returns zero
     *
     * @return zero
     */
    @Override
    public double getTravelCost() {
        return 0.0;
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