package homework;

/**
 * Class validates sides of triangle
 */
public class Validation {

    /**
     * Method validatesSides gets values of sides and verify that values are correct
     * and the triangle with this sides exists. If it isn't, it throws exception
     *
     * @param side1 value of the first side
     * @param side2 value of the second side
     * @param side3 value of the third side
     */
    public void validatesSides(double side1, double side2, double side3) throws Exception {
        double[] params = {side1, side2, side3};
        // Validates values of sides
        for (double sides : params) {
            if (Double.compare(sides, 0) <= 0 || Double.compare(sides, Double.NaN) == 0
                    || Double.compare(sides, Double.POSITIVE_INFINITY) == 0
                    || Double.compare(sides, Double.NEGATIVE_INFINITY) == 0) {
                throw new Exception("Incorrect side value");
            }
        }
        // Checks that the triangle exists
        if (params[0] >= params[1] + params[2] || params[0] <= Math.abs(params[1] - params[2])) {
            throw new Exception("Triangle doesn't exist with such values of sides");
        }
    }
}
