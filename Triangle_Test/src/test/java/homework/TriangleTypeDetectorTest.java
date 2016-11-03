package homework;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTypeDetectorTest {

    TriangleTypeDetector detector;

    @BeforeTest
    public void setUp() {
        detector = new TriangleTypeDetector();
    }

    @DataProvider(name = "legal values")
    public Object[][] getLegalValues() {
        return new Object[][]{
                {3.0, 4.0, 5.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MIN_NORMAL, Double.MIN_NORMAL, Double.MIN_NORMAL}
        };
    }

    @DataProvider(name = "illegal values")
    public Object[][] getIllegalValues() {
        return new Object[][]{
                {1.6, 3.1, 5.3},
                {-1.6, 3.1, 5.3},
                {0.0, 8.7, 7.3},
                {2.2, Double.POSITIVE_INFINITY, 2.2},
                {2.2, Double.NEGATIVE_INFINITY, 2.2},
                {3.2, Double.NaN, 3.7},
                {2.2, Double.MIN_VALUE, 2.2},
        };
    }

    @Test(dataProvider = "illegal values", expectedExceptions = Exception.class)
    public void testNegativeSetIllegalSides(double a, double b, double c) throws Exception {
        detector.detectTriangle(a, b, c);
    }

    @Test(dataProvider = "legal values")
    public void testPositiveSetLegalSides(double a, double b, double c) throws Exception {
        detector.detectTriangle(a, b, c);
    }

    @Test
    public void testPositiveDetectIsoscelesTriangle() throws Exception {
        Assert.assertEquals(detector.detectTriangle(12.2, 12.2, 10.0), "Triangle is isosceles");
    }

    @Test
    public void testPositiveDetectEquilateralTriangle() throws Exception {
        Assert.assertEquals(detector.detectTriangle(12.2, 12.2, 12.2), "Triangle is equilateral");
    }

    @Test
    public void testPositiveDetectNormalTriangle() throws Exception {
        Assert.assertEquals(detector.detectTriangle(11.3, 12.2, 10.0), "Triangle is normal");
    }
}