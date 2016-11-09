package homework.transport;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BusTest {
    Bus bus;
    Router router;

    @Before
    public void setUp() throws Exception {
        bus = new Bus(2.0, 10, new BigDecimal("1.0"));
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectBusSpeed() throws Exception {
        Bus bus = new Bus(-1.4, 10, new BigDecimal("2.1"));
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectFuelPrice() throws Exception {
        Bus bus = new Bus(1.4, 10, new BigDecimal("0.0"));
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectPeopleCount() throws Exception {
        Bus bus = new Bus(1.4, -10, new BigDecimal("10.0"));
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        bus.moveToNextCheckpoint(10.0, 0.0);
        assertEquals(5.0, bus.getTravelTime(), 0.1);
    }

    @Test
    public void tstPositiveGetTravelCost() throws Exception {
        bus.moveToNextCheckpoint(10.0, 0.0);
        assertEquals(0.4, bus.getTravelCost(), 0.1);
    }
}