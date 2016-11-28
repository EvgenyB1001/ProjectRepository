package homework;

import java.math.BigDecimal;

/**
 * Class that provides method for checking triangle type.
 */
public class TriangleTypeDetector {

    private final String EQUILATERAL = "Triangle is equilateral";
    private final String ISOSCELES = "Triangle is isosceles";
    private final String NORMAL = "Triangle is normal";

    /**
     * Method detectTriangle determines what type of triangle is
     *
     * @param firstSide value of first side
     * @param secondSide value of second side
     * @param thirdSide value of third side
     */
    public String detectTriangle(BigDecimal firstSide, BigDecimal secondSide, BigDecimal thirdSide) throws Exception {
        validatesSides(firstSide, secondSide, thirdSide);
        validateTriangle(firstSide, secondSide, thirdSide);
        // Determines the type of triangle depending on the number of equal sides
        if (firstSide.compareTo(secondSide) == 0 && firstSide.compareTo(thirdSide) == 0
                && secondSide.compareTo(thirdSide) == 0) {
            return EQUILATERAL;
        }
        if (firstSide.compareTo(secondSide) == 0 || firstSide.compareTo(thirdSide) == 0
                || secondSide.compareTo(thirdSide) == 0) {
            return ISOSCELES;
        }
        return NORMAL;
    }

    /**
     * Method validatesSides gets values of sides and verify that values are correct.
     * If it isn't, it throws exception
     *
     * @param side1 value of the first side
     * @param side2 value of the second side
     * @param side3 value of the third side
     */
    private void validatesSides(BigDecimal side1, BigDecimal side2, BigDecimal side3) throws Exception {
        BigDecimal[] params = {side1, side2, side3};
        // Validates values of sides
        for (BigDecimal sides : params) {
            if (sides.compareTo(BigDecimal.valueOf(0.0)) <= 0) {
                throw new Exception("Incorrect side value");
            }
        }
    }

    /**
     * Method validateTriangle gets values of sides and verify that the triangle with this sides exists.
     * If it isn't, it throws exception
     *
     * @param side1 value of the first side
     * @param side2 value of the second side
     * @param side3 value of the third side
     */
    private void validateTriangle(BigDecimal side1, BigDecimal side2, BigDecimal side3) throws Exception {
        // Verifies that the triangle exists
        if (side1.compareTo(side2.add(side3)) >= 0
                || side1.compareTo(side2.subtract(side3).abs()) <= 0) {
            throw new Exception("Triangle doesn't exist with such values of sides");
        }
    }
}