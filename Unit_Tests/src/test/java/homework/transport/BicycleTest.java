package homework.transport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleTest {

    Bicycle bicycle;
    Router router;

    @Before
    public void setUp() throws Exception {
        bicycle = new Bicycle(2.0);
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectBicycleSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(-1.4);
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        bicycle.moveToNextCheckpoint(10.0, 0.0);
        assertEquals(5.0, bicycle.getTravelTime(), 0.1);
    }
}