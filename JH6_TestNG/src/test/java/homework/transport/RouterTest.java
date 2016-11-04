package homework.transport;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RouterTest {
    Router router;

    @BeforeMethod
    public void setUp() throws Exception {
        router = new Router();
        router.setStartCoordinates(1.0, 1.0);
    }

    @DataProvider (name = "moveCoordinates")
    public Object[][] moveByCoordinates() {
        return new Object[][]{
                {0, 1.0, 1.0},
                {2.0, 1.0, -1.0},
                {2.8, -1.0, -1.0},
                {1.4, 0.0, 0.0},
        };
    }

    @Test (dataProvider = "moveByCoordinates")
    public void tstPositiveGetDistance(double result, double x, double y) throws Exception {
        Assert.assertEquals(router.getDistance(x, y), result, 0.1);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeAddNaNCoordinates() throws Exception {
        router.getDistance(Double.NaN, Double.NaN);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeAddPosInfinityCoordinates() throws Exception {
        router.getDistance(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeAddNegInfinityCoordinates() throws Exception {
        router.getDistance(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeSetStartNaNCoordinates() throws Exception {
        router.setStartCoordinates(Double.NaN, Double.NaN);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeSetStartPosInfinityCoordinates() throws Exception {
        router.setStartCoordinates(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeSetStartNegInfinityCoordinates() throws Exception {
        router.setStartCoordinates(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
}
