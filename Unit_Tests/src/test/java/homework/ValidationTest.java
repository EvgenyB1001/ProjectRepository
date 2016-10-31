package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ValidationTest {
    Validation validation;
    ArrayList<String[]> checkpoints;

    @Before
    public void setUp() throws Exception {
        validation = new Validation();
        checkpoints = new ArrayList<>();
    }

    @After
    public void tearDown() {
        checkpoints.clear();
    }

    @Test (expected = Exception.class)
    public void tstValidationStartFinishPoints() throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        checkpoints.add(new String[] {"2.2", "0.0"});
        checkpoints.add(new String[] {"2.2", "0.0"});
        validation.validationStartFinishPoints(checkpoints);
    }

    @Test (expected = Exception.class)
    public void validationCountOfCoordinates() throws Exception {
        validation.validationCountOfCoordinates(new String[] {"2.3", "23.3", "32.4"});
    }
}