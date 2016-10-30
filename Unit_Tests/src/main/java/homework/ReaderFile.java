package homework;

import java.io.*;
import java.util.*;

/**
 * Class reads data from definite file and return list of checkpoints
 */
public class ReaderFile {

    /**
     * Method reads data from file, validates it and returns list of checkpoints
     *
     * @param path path to working file
     * @return list of coordinates of checkpoints
     */
    public ArrayList<String[]> read(String path) throws Exception {
        ArrayList<String[]> checkpoints = new ArrayList<>();
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String[] curCoordinates;
        Validation validator = new Validation();
        do {
            curCoordinates = reader.readLine().split(" ");
            validator.validationCountOfCoordinates(curCoordinates);
            checkpoints.add(curCoordinates);
        } while ((reader.readLine()) != null);
        // Validate start and finish checkpoints
        validator.validationStartFinishPoints(checkpoints);
        return checkpoints;
    }
}