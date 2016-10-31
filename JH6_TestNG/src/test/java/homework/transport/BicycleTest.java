package homework.transport;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BicycleTest {

    Bicycle bicycle;
    Router router;

    @BeforeMethod
    public void setUp() throws Exception {
        bicycle = new Bicycle(2.0);
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectBicycleSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(-1.4);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNaNBicycleSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(Double.NaN);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNegInfinityBicycleSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(Double.NEGATIVE_INFINITY);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetPosInfinityBicycleSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(Double.POSITIVE_INFINITY);
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        bicycle.moveToNextCheckpoint(10.0, 0.0);
        Assert.assertEquals(bicycle.getTravelTime(), 5.0, 0.1);
    }
}