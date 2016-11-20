package homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class creates (if it isn't exists) file of log and writes down to it information about execution
 */
public class WriterLogFile {

    /**
     * Method gets file path and list of log data, creates (if it isn't exists) file and writes
     * log data to it.
     *
     * @param data     list of log data
     * @param filePath path to file
     */
    public void writeLog(String filePath, ArrayList<String> data) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (String line : data) {
            writer.write(line + System.getProperty("line.separator"));
        }
        writer.flush();
        writer.close();
    }
}
