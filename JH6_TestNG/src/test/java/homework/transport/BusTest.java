package homework.transport;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BusTest {
    Bus bus;
    Router router;

    @BeforeMethod
    public void setUp() throws Exception {
        bus = new Bus(2.0, 10, new BigDecimal("1.0"));
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectBusSpeed() throws Exception {
        Bus bus = new Bus(-1.4, 10, new BigDecimal("2.1"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectBusSpeedNullPrice() throws Exception {
        Bus bus = new Bus(1.4, 10, null);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNegInfinityBusSpeed() throws Exception {
        Bus bus = new Bus(Double.NEGATIVE_INFINITY, 10, new BigDecimal("2.1"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetPosInfinityBusSpeed() throws Exception {
        Bus bus = new Bus(Double.POSITIVE_INFINITY, 10, new BigDecimal("2.1"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNaNBusSpeed() throws Exception {
        Bus bus = new Bus(Double.NaN, 10, new BigDecimal("2.1"));
    }


    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectFuelPrice() throws Exception {
        Bus bus = new Bus(1.4, 10, new BigDecimal("0.0"));
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectPeopleCount() throws Exception {
        Bus bus = new Bus(1.4, -10, new BigDecimal("10.0"));
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        bus.moveToNextCheckpoint(10.0, 0.0);
        Assert.assertEquals(bus.getTravelTime(), 5.0, 0.1);
    }

    @Test
    public void tstPositiveGetTravelCost() throws Exception {
        bus.moveToNextCheckpoint(10.0, 0.0);
        Assert.assertEquals(bus.getTravelCost(), 0.4, 0.1);
    }
}