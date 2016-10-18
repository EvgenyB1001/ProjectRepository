package homework;

import java.io.*;
import java.util.*;

/**
 * Class FilePerformer reads definite file and return array of ip addresses
 */
public class ReaderFile {

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
}