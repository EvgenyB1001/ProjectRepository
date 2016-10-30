package homework;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class ReaderFileTest {

    @Test
    public void tstPositiveReaderFileCreation() throws Exception {
        ReaderFile readerFile = new ReaderFile();
        assertNotNull(readerFile);
    }
}