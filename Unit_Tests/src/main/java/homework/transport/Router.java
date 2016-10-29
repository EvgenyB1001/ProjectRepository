package homework.transport;

/**
 * Class that make a route step-by-step by coordinates
 */
public class Router {

    /**
     * Current coordinates
     */
    private double x = 0.0, y = 0.0;

    /**
     * Method sets start coordinates of travelling
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public void setStartCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method calculates distance between two checkpoints with coordinates, got as parameters
     *
     * @param x x coordinate of next point
     * @param y y coordinate of next point
     * @return distance between two points
     */
    public double getDistance(double x, double y) {
        double coordX = Math.abs(this.x - x);
        double coordY = Math.abs(this.y - y);
        this.x = x;
        this.y = y;
        return Math.sqrt(coordX * coordX + coordY * coordY);
    }
}
