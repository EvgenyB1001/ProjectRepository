package homework;

import java.io.*;
import java.util.*;

/**
 * Class FilePerformer works with files: reads file, verifies and return list of ip addresses,
 * writes definite file.
 */
public class FilePerformer {

    /**
     * Method ReadFile reads definite file with path, got as parameter, and returns
     * array of ip addresses.
     *
     * @param address path to file with ip addresses
     * @return ipAddresses array of ip addresses
     */
    public String[] readFile(String address) throws Exception {
        ArrayList<String> currIpAddresses = new ArrayList<>();
        File file = new File(address);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        do {
            currIpAddresses.add(reader.readLine());
        } while ((reader.readLine()) != null);
        String[] ipAddresses = new String[currIpAddresses.size()];
        for (int i = 0; i < currIpAddresses.size(); i++) {
            ipAddresses[i] = currIpAddresses.get(i);
        }
        return ipAddresses;
    }

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