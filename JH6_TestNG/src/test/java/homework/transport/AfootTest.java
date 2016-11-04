package homework.transport;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AfootTest {
    Afoot afoot;
    Router router;

    @BeforeMethod
    public void setUp() throws Exception {
        afoot = new Afoot(2.0);
        router = new Router();
        router.setStartCoordinates(0.0, 0.0);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetIncorrectAfootSpeed() throws Exception {
        Afoot afoot = new Afoot(-1.4);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNaNAfootSpeed() throws Exception {
        Afoot afoot = new Afoot(Double.NaN);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetNegInfinityAfootSpeed() throws Exception {
        Afoot afoot= new Afoot(Double.NEGATIVE_INFINITY);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstNegativeSetPosInfinityAfootSpeed() throws Exception {
        Afoot afoot = new Afoot(Double.POSITIVE_INFINITY);
    }

    @Test
    public void tstPositiveGetTravelTime() throws Exception {
        afoot.moveToNextCheckpoint(10.0, 0.0);
        Assert.assertEquals(afoot.getTravelTime(), 5.0, 0.1);
    }
}