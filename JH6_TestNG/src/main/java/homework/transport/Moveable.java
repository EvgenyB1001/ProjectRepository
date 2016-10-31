package homework.transport;

/**
 * Interface Moveable points methods, that belongs to objects,
 * that can travel
 */
public interface Moveable {

    /**
     * Method sets start coordinates
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    void setStartCoordinates(double x, double y) throws Exception;

    /**
     * Method emulates move object to the next point
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    void moveToNextCheckpoint(double x, double y) throws Exception;

    /**
     * Method returns travel time
     *
     * @return travel time
     */
    double getTravelTime();

    /**
     * Method returns travel cost
     *
     * @return travel cost
     */
    double getTravelCost();
}