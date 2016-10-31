package homework.transport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouterTest {
    Router router;

    @Before
    public void setUp() {
        router = new Router();
    }

    @Test
    public void tstPositiveGetDistance() throws Exception {
        router.setStartCoordinates(1.0, 1.0);
        assertEquals(5.0, router.getDistance(1.0, 6.0), 0.1);
    }

    @Test (expected = Exception.class)
    public void tstNegativeAddNaNCoordinates() throws Exception {
        router.setStartCoordinates(1.0, 1.0);
        router.getDistance(Double.NaN, Double.NaN);
    }

    @Test (expected = Exception.class)
    public void tstNegativeSetStartNaNCoordinates() throws Exception {
        router.setStartCoordinates(Double.NaN, Double.NaN);
    }

    @Test (expected = Exception.class)
    public void tstNegativeSetStartPosInfinityCoordinates() throws Exception {
        router.setStartCoordinates(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test (expected = Exception.class)
    public void tstNegativeSetStartNegInfinityCoordinates() throws Exception {
        router.setStartCoordinates(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
}
