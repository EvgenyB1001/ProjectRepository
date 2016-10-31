package homework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ValidationTest {
    Validation validation;
    ArrayList<String[]> checkpoints;

    @BeforeMethod
    public void setUp() throws Exception {
        validation = new Validation();
        checkpoints = new ArrayList<>();
    }

    @AfterMethod
    public void tearDown() {
        checkpoints.clear();
    }

    @Test (expectedExceptions = Exception.class)
    public void tstNegativeValidationStartFinishPoints() throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        checkpoints.add(new String[] {"2.2", "0.0"});
        checkpoints.add(new String[] {"2.2", "0.0"});
        validation.validationStartFinishPoints(checkpoints);
    }

    @Test
    public void tstPositiveValidationStartFinishPoints() throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        checkpoints.add(new String[] {"2.2", "0.0"});
        checkpoints.add(new String[] {"2.3", "0.0"});
        validation.validationStartFinishPoints(checkpoints);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstValidationNullStartFinishPoints() throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        validation.validationStartFinishPoints(null);
    }

    @Test(expectedExceptions = Exception.class)
    public void tstValidationStartFinishPointsEmpty() throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        validation.validationStartFinishPoints(checkpoints);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstValidationCountOfCoordinates() throws Exception {
        validation.validationCountOfCoordinates(new String[] {"2.3", "23.3", "32.4"});
    }

    @Test (expectedExceptions = Exception.class)
    public void tstValidationNullCountOfCoordinates() throws Exception {
        validation.validationCountOfCoordinates(null);
    }

    @Test
    public void tstPositiveValidationCountOfCoordinates() throws Exception {
        validation.validationCountOfCoordinates(new String[] {"2.3", "23.3"});
    }

    @Test (expectedExceptions = Exception.class)
    public void tstValidationPosInfinityCoordinates() throws Exception {
        validation.validationCoordinates(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void tstPositiveValidationCoordinates() throws Exception {
        validation.validationCoordinates(2.1, 3.2);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstValidationNegInfinityCoordinates() throws Exception {
        validation.validationCoordinates(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test (expectedExceptions = Exception.class)
    public void tstValidationNaNCoordinates() throws Exception {
        validation.validationCoordinates(Double.NaN, Double.NaN);
    }
}