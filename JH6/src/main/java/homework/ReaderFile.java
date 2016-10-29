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
            if (curCoordinates.length != 2) {
                System.out.println("Incorrect count of coordinates");
                continue;
            }
            checkpoints.add(curCoordinates);
        } while ((reader.readLine()) != null);
        // Validate start and finish checkpoints
        if (!validation(checkpoints)) {
            throw new Exception("Start and finish coordinates can not be equal");
        }
        return checkpoints;
    }

    /**
     * Method validates start and finish checkpoint
     *
     * @param checkpoints list of coordinates of checkpoints
     * @return boolean value: true - if start and finish coordinates are not equal
     */
    private boolean validation(ArrayList<String[]> checkpoints) {
        return (Double.parseDouble(checkpoints.get(0)[0]) != Double.parseDouble(checkpoints.get(checkpoints.size() - 1)[1]));
    }
}