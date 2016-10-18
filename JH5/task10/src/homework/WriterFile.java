package homework;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Class WriterFile creates or rewrite file with set by user data nad path
 */
public class WriterFile {

    /**
     * Method WriterFile create (if there no such file) or rewrite html file
     * with current html code
     *
     * @param filePath path to output file
     * @param html     string of html code
     */
    public void writeFile(String filePath, String html) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(html);
        writer.flush();
        writer.close();
    }
}
