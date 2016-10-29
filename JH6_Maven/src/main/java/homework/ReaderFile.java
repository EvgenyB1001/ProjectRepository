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
        do {
            curCoordinates = reader.readLine().split(" ");
            validationCountOfCoordinates(curCoordinates);
            checkpoints.add(curCoordinates);
        } while ((reader.readLine()) != null);
        // Validate start and finish checkpoints
        validationStartFinishPoints(checkpoints);
        return checkpoints;
    }

    /**
     * Method validates start and finish checkpoint. If start anf finish checkpoints are equal, it throws an exception
     *
     * @param checkpoints list of coordinates of checkpoints
     */
    public void validationStartFinishPoints(ArrayList<String[]> checkpoints) throws Exception {
        if (Double.parseDouble(checkpoints.get(0)[0]) == Double.parseDouble(checkpoints.get(checkpoints.size() - 1)[0])
                && Double.parseDouble(checkpoints.get(0)[1]) == Double.parseDouble(checkpoints.get(checkpoints.size() - 1)[1])) {
            throw new Exception("Start and finish coordinates can not be equal");
        }
    }

    /**
     * Method validates count of coordinates of checkpoint. If count is incorrect, it throws exception
     *
     * @param coordinates list of coordinates of checkpoints
     */
    public void validationCountOfCoordinates(String[] coordinates) throws Exception {
        if (coordinates.length != 2) {
            throw new Exception("Incorrect count of coordinates");
        }
    }
}