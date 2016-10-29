package homework.transport;

/**
 * Interface Moveable points methods, that belongs to objects,
 * that can travel
 */
public interface Moveable {

    /**
     * Method will be implemented by inherits
     */
    void setStartCoordinates(double x, double y);

    /**
     * Method will be implemented by inherits
     */
    void moveToNextCheckpoint(double x, double y);

    /**
     * Method will be implemented by inherits
     */
    String getTravelTime();

    /**
     * Method will be implemented by inherits
     */
    double getTravelCost();
}