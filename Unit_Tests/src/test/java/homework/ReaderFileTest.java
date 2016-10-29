package homework;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class ReaderFileTest {

    ReaderFile readerFile;
    ArrayList<String[]> checkpoints;

    @Before
    public void setUp() throws Exception {
        readerFile = new ReaderFile();
        checkpoints = new ArrayList<>();
        String[] elements1 = {"12.2", "32.1"};
        String[] elements2 = {"12.2", "32.1"};
        checkpoints.add(elements1);
        checkpoints.add(elements2);
    }

    @Test (expected = Exception.class)
    public void tstNegativeCountOfCoordinates() throws Exception {
        String[] incorrectCount = {"12.4", "32.2", "234.4"};
        readerFile.validationCountOfCoordinates(incorrectCount);
    }

    @Test (expected = Exception.class)
    public void tstNegativeValidation() throws Exception {
        setUp();
        readerFile.validationStartFinishPoints(checkpoints);
    }

    @Test
    public void tstPositiveReaderFileCreation() throws Exception {
        ReaderFile readerFile = new ReaderFile();
        assertNotNull(readerFile);
    }
}