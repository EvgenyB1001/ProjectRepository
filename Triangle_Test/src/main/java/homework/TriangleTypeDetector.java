package homework;

/**
 * Class that provides method for checking triangle type.
 */
public class TriangleTypeDetector {

    /**
     * Method detectTriangle determines what type of triangle is
     *
     * @param firstSide value of first side
     * @param secondSide value of second side
     * @param thirdSide value of third side
     */
    public String detectTriangle(double firstSide, double secondSide, double thirdSide) throws Exception {
        validatesSides(firstSide, secondSide, thirdSide);
        // Determines the type of triangle depending on the number of equal sides
        if (Double.compare(firstSide, secondSide) == 0 && Double.compare(firstSide, thirdSide) == 0
                && Double.compare(secondSide, thirdSide) == 0) {
            return "Triangle is equilateral";
        }
        if (Double.compare(firstSide, secondSide) == 0 || Double.compare(firstSide, thirdSide) == 0
                || Double.compare(secondSide, thirdSide) == 0) {
            return "Triangle is isosceles";
        }
        return "Triangle is normal";
    }

    /**
     * Method validatesSides gets values of sides and verify that values are correct
     * and the triangle with this sides exists. If it isn't, it throws exception
     *
     * @param side1 value of the first side
     * @param side2 value of the second side
     * @param side3 value of the third side
     */
    private void validatesSides(double side1, double side2, double side3) throws Exception {
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