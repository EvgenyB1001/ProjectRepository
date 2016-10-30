package homework;

import java.util.ArrayList;

/**
 * Class validates values of variables
 */
public class Validation {

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
