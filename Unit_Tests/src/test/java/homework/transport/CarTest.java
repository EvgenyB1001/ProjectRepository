package homework.transport;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CarTest {
    Car car;
    Router router;

    @Before
    public void setUp() throws Exception {
        car = new Car(2.0, new BigDecimal("1.0"));
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test
    public void tstPositiveCarCreation() throws Exception {
        Car car = new Car(1.4, new BigDecimal("2.1"));
        assertNotNull(car);
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectCarSpeed() throws Exception {
        Car car = new Car(-1.4, new BigDecimal("2.1"));
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectFuelPrice() throws Exception {
        Car car = new Car(1.4, new BigDecimal("0.0"));
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        setUp();
        car.moveToNextCheckpoint(10.0, 0.0);
        assertTrue(car.getTravelTime().equals("5 hours 0 minutes"));
    }

    @Test
    public void tstPositiveAddTravelTime() throws Exception {
        setUp();
        car.addAnotherTravelTime(10.0);
        assertEquals(5.0, car.travelTime, 0.1);
    }

    @Test
    public void tstPositiveAddTravelCost() throws Exception {
        setUp();
        car.addAnotherTravelCost(10.0);
        assertEquals(10.0, car.travelCost, 0.1);
    }
}