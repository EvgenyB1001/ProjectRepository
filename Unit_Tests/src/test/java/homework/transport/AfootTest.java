package homework.transport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AfootTest {
    Afoot afoot;
    Router router;

    @Before
    public void setUp() throws Exception {
        afoot = new Afoot(2.0);
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expected = Exception.class)
    public void tstNegativeSetIncorrectAfootSpeed() throws Exception {
        Afoot afoot = new Afoot(-1.4);
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        setUp();
        afoot.moveToNextCheckpoint(10.0, 0.0);
        assertTrue(afoot.getTravelTime().equals("5 hours 0 minutes"));
    }

    @Test
    public void tstPositiveAddTravelTime() throws Exception {
        setUp();
        afoot.addAnotherTravelTime(10.0);
        assertEquals(5.0, afoot.travelTime, 0.1);
    }

    @Test
    public void tstPositiveAfootCreation() throws Exception {
        Afoot afoot = new Afoot(1.4);
        assertNotNull(afoot);
    }
}