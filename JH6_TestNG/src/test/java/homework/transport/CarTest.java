package homework.transport;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.math.BigDecimal;

public class CarTest {
    Car car;
    Router router;

    @BeforeMethod
    public void setUp() throws Exception {
        car = new Car(2.0, new BigDecimal("1.0"));
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectCarSpeed() throws Exception {
        Car car = new Car(-1.4, new BigDecimal("2.1"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectFuelPrice() throws Exception {
        Car car = new Car(1.4, new BigDecimal("0.0"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNullPrice() throws Exception {
        Car car = new Car(1.4, null);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNegInfinityCarSpeed() throws Exception {
        Car car = new Car(Double.NEGATIVE_INFINITY, new BigDecimal("2.1"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetPosInfinityCarSpeed() throws Exception {
        Car car = new Car(Double.POSITIVE_INFINITY, new BigDecimal("2.1"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNaNCarSpeed() throws Exception {
        Car car = new Car(Double.NaN, new BigDecimal("2.1"));
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        car.moveToNextCheckpoint(10.0, 0.0);
        Assert.assertEquals(car.getTravelTime(), 5.0, 0.1);
    }

    @Test
    public void tstPositiveGetTravelCost() throws Exception {
        car.moveToNextCheckpoint(10.0, 0.0);
        Assert.assertEquals(car.getTravelCost(), 10.0, 0.1);
    }
}