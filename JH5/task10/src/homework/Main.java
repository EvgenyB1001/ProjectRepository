package homework;

import java.io.*;
import java.util.Map;

/**
 * Class main has entry point to the program. Program create html-table,
 * that shows time (ms) of request ip addresses.
 */

public class Main {

    /**
     * Path to working directory
     */
    public static final String DIR_PATH = "C:\\Users\\777\\IdeaProjects\\task10\\src\\homework\\";

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
        try {
            FilePerformer performer = new FilePerformer();
            // If there are no parameters from command line, program gets parameters from definite file
            if (args.length == 0) {
                setAndCreateHtml(performer.readFile(DIR_PATH + INPUT_FILE_NAME), performer);
            } else {
                setAndCreateHtml(args, performer);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method gets array of ip addresses and object of FilePerformer, send them to definite
     * objects, that emulate ping and create html table
     *
     * @param data      array of ip addresses
     * @param performer object, that works with files
     */
    public static void setAndCreateHtml(String[] data, FilePerformer performer) throws Exception {
        HtmlCreator creator = new HtmlCreator();
        Ping ping = new Ping();
        DataKeeper keeper = new DataKeeper();
        for (String address : data) {
            keeper.setNewData(address, ping.getPing(address));
        }
        int max = keeper.getMaxTime();
        int count = 1;
        for (Map.Entry<String, Integer> address : keeper.getIpCollection().entrySet()) {
            creator.addAddress(address.getKey(), address.getValue(), max, count);
            count++;
        }
        performer.writeFile(DIR_PATH + OUTPUT_FILE_NAME, creator.getHtml());
    }
}