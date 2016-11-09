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
                {1.0, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
                {Double.MIN_NORMAL, Double.MIN_NORMAL, Double.MIN_NORMAL},
                {1.0, 1.0, Double.MIN_NORMAL},
                { Double.MIN_NORMAL, 1.0,  1.0},
                {1.0,  Double.MIN_NORMAL, 1.0},
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
                {1.0, 1.0, Double.MIN_VALUE},
                { Double.MIN_VALUE, 1.0,  1.0},
                {1.0,  Double.MIN_VALUE, 1.0},
        };
    }

    @DataProvider(name = "illegal values")
    public Object[][] getIllegalValues() {
        return new Object[][]{
                {1.6, 3.1, 5.3},
                {-3, -4, -5},
                {-3, 4, 5},
                {3, -4, 5},
                {3, 4, -5},
                {0.0, 0.0, 0.0},
                {0.0, 8.7, 7.3},
                {8.7, 0.0, 7.3},
                {7.3, 8.7, 0.0},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                {2.2, Double.POSITIVE_INFINITY, 2.2},
                {Double.POSITIVE_INFINITY, 2.2, 2.2},
                {2.2, 2.2, Double.POSITIVE_INFINITY},
                {Double.NaN, Double.NaN, Double.NaN},
                {3.2, Double.NaN, 3.7},
                {Double.NaN, 3.2, 3.7},
                {3.2, 3.7, Double.NaN},
                {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {2.2, Double.NEGATIVE_INFINITY, 2.2},
                {Double.NEGATIVE_INFINITY, 2.2, 2.2},
                {2.2, 2.2, Double.NEGATIVE_INFINITY},
                {-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE},
                {-Double.MAX_VALUE, 1.0, 1.0},
                {1.0, -Double.MAX_VALUE, 1.0},
                {1.0, 1.0, -Double.MAX_VALUE},
                {-Double.MIN_NORMAL, -Double.MIN_NORMAL, -Double.MIN_NORMAL},
                {-Double.MIN_NORMAL, 1.0, 1.0},
                {1.0, -Double.MIN_NORMAL, 1.0},
                {1.0, 1.0, -Double.MIN_NORMAL},
                {-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE,},
                {-Double.MIN_VALUE, 1.0, 1.0},
                {1.0, -Double.MIN_VALUE, 1.0},
                {1.0, 1.0, -Double.MIN_VALUE}

        };
    }

    @DataProvider(name = "isosceles triangle values")
    public Object[][] getIsoscelesTriangleValues() {
        return new Object[][]{
                {2.0, 2.0, 3.3},
                {1.0, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
                {1.0, 1.0, Double.MIN_VALUE},
                { Double.MIN_VALUE, 1.0,  1.0},
                {1.0,  Double.MIN_VALUE, 1.0},
                {1.0, 1.0, Double.MIN_NORMAL},
                { Double.MIN_NORMAL, 1.0,  1.0},
                {1.0,  Double.MIN_NORMAL, 1.0}
        };
    }

    @DataProvider(name = "equilateral triangle values")
    public Object[][] getEquilateralTriangleValues() {
        return new Object[][]{
                {2.0, 2.0, 2.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
                {Double.MIN_NORMAL, Double.MIN_NORMAL, Double.MIN_NORMAL},
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

    @Test(dataProvider = "isosceles triangle values")
    public void testPositiveDetectIsoscelesTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is isosceles");
    }

    @Test(dataProvider ="equilateral triangle values")
    public void testPositiveDetectEquilateralTriangle(double a, double b, double c) throws Exception {
        Assert.assertEquals(detector.detectTriangle(a, b, c), "Triangle is equilateral");
    }

    @Test
    public void testPositiveDetectNormalTriangle() throws Exception {
        Assert.assertEquals(detector.detectTriangle(3.0, 4.0, 5.0), "Triangle is normal");
    }
}