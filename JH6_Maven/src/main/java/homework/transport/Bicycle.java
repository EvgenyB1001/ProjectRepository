package homework.transport;

/**
 * Class contains data of travelling by bicycle.
 */
public class Bicycle implements Moveable {

    /**
     * Average speed moving by bicycle(km per hour)
     */
    private double averageSpeed = 0.0;

    /**
     * Name of the way of travelling
     */
    public static final String NAME = "Bicycle";

    /**
     * Current travel time (hours)
     */
    public double travelTime = 0.0;

    /**
     * Object, that calculate distance
     */
    private Router router = new Router();

    /**
     * Constructor creates the vehicle, set average speed
     *
     * @param averageSpeed average speed of travelling afoot
     */
    public Bicycle(double averageSpeed) throws Exception {
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
        router.setStartCoordinates(x, y);
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
        addAnotherTravelTime(router.getDistance(x, y));
    }

    /**
     * Method adds travel time
     *
     * @param distance another distance
     */
    public void addAnotherTravelTime(double distance) {
        travelTime += distance / averageSpeed;
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
     * Method returns cost of travel. Travelling by bicycle doesn't waste any resources, so method returns zero
     *
     * @return zero
     */
    @Override
    public double getTravelCost() {
        return 0;
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
