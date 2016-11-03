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
        new Validation().validatesSides(firstSide, secondSide, thirdSide);
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
}