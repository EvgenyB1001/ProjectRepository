package homework.transport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouterTest {
    Router router;

    @Before
    public void setUp() {
        router = new Router();
        router.setStartCoordinates(1.0, 1.0);
    }

    @Test
    public void tstPositiveGetDistance() throws Exception {
        assertEquals(5.0, router.getDistance(1.0, 6.0), 0.1);
    }
}