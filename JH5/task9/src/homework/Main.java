package homework;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class Main has entry point to the program
 */
public class Main {

    /**
     * Contains name of html file
     */
    public static final String FILE_NAME = "table.html";

    /**
     * Method Main creates objects to write the file and to create html-table
     */
    public static void main(String[] args) {
        try {
            String address = System.getProperty("user.dir");
            // Object that write a file of html-table
            FileWriter writer = new FileWriter(address + "\\" + FILE_NAME, false);
            // Creates object that create html-table
            HtmlCreator creator = new HtmlCreator(address);
            writer.write(creator.getHtml());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Output exception");
        } catch (Exception e) {
            System.out.println("Error in program");
        }
    }
}
