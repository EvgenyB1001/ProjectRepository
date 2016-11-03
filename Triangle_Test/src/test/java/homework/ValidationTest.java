package homework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidationTest {

    Validation validation;

    @BeforeTest
    public void setUp() {
        validation = new Validation();
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

    @DataProvider(name = "legal values")
    public Object[][] getLegalValues() {
        return new Object[][]{
                {3.0, 4.0, 5.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MIN_NORMAL, Double.MIN_NORMAL, Double.MIN_NORMAL}
        };
    }

    @Test(dataProvider = "illegal values", expectedExceptions = Exception.class)
    public void testNegativeValidatesSides(double a, double b, double c) throws Exception {
        validation.validatesSides(a, b, c);
    }

    @Test(dataProvider = "legal values")
    public void testPositiveValidatesSides(double a, double b, double c) throws Exception {
        validation.validatesSides(a, b, c);
    }
}