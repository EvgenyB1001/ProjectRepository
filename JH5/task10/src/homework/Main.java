package homework;

import java.io.*;
import java.util.HashMap;

/**
 * Class main has entry point to the program. Program create html-table,
 * that shows time (ms) of request ip addresses.
 */

public class Main {

    /**
     * Address of working directory
     */
    public static final String ADDRESS = "C:\\Users\\777\\IdeaProjects\\task10\\src\\homework\\";

    /**
     * Name of html file
     */
    public static final String OUTPUT_FILE_NAME = "table.html";

    /**
     * Name of file with ip addresses
     */
    public static final String INPUT_FILE_NAME = "ip_addresses.txt";

    /**
     * Method main gets ip addresses as parameters from command line, send them to object, that
     * create an html code and write html file with that html code. If there are no parameters
     * from command line, program gets parameter from definite file
     *
     * @param args array of values of ip addresses
     */
    public static void main(String[] args) {
        // Verifies, if there parameters from command line
        try {
            // If there are no parameters from command line, program gets parameters from definite file
            if (args.length == 0) {
                ReaderFile readerFile = new ReaderFile(ADDRESS + INPUT_FILE_NAME);
                HtmlCreator creator = new HtmlCreator(new Ping(readerFile.getIpAddresses()).getPing());
                WriterFile(creator.getHtml());
            } else {
                // If there are parameters, create html code with this parameters
                HtmlCreator creator = new HtmlCreator(new Ping(convertToMapAddresses(args)).getPing());
                WriterFile(creator.getHtml());
            }
        } catch (IOException e) {
            System.out.println("Output exception");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method convertToMapAddresses convert array of ip addresses to HashMap, and returns
     * it.
     *
     * @param args array of values of ip addresses
     * @return ip addresses in format HashMap
     */
    private static HashMap<String, Integer> convertToMapAddresses(String[] args) {
        HashMap<String, Integer> addresses = new HashMap<>();
        for (String s : args) {
            addresses.put(s, 0);
        }
        return addresses;
    }

    /**
     * Method WriterFile create (if there no such file) or rewrite html file
     * with current html code
     *
     * @param html string of html code
     */
    private static void WriterFile(String html) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(ADDRESS + OUTPUT_FILE_NAME));
        writer.write(html);
        writer.flush();
        writer.close();
    }
}