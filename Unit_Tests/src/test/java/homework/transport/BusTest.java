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

    @Test
    public void tstPositiveBusCreation() throws Exception {
        Bus bus = new Bus(1.4, 10, new BigDecimal("2.1"));
        assertNotNull(bus);
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
        setUp();
        bus.moveToNextCheckpoint(10.0, 0.0);
        assertTrue(bus.getTravelTime().equals("5 hours 0 minutes"));
    }

    @Test
    public void tstPositiveAddTravelTime() throws Exception {
        setUp();
        bus.addAnotherTravelTime(10.0);
        assertEquals(5.0, bus.travelTime, 0.1);
    }

    @Test
    public void tstPositiveAddTravelCost() throws Exception {
        setUp();
        bus.addAnotherTravelCost(10.0);
        assertEquals(0.4, bus.travelCost, 0.1);
    }
}