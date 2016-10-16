package homework;

import java.io.*;
import java.util.*;

/**
 * Class ReaderFile reads definite file and returns collection of ip addresses
 * from this file.
 */
public class ReaderFile {

    /**
     * Collection of ip addreses
     */
    private HashMap<String, Integer> ipAddresses = new HashMap<>();

    /**
     * Constructor get address of file, reads them and creates collection of
     * ip addresses.
     *
     * @param address address of file with ip addresses
     */
    public ReaderFile(String address) throws Exception {
        File file = new File(address);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        do {
            ipAddresses.put(reader.readLine(), 0);
        } while ((reader.readLine()) != null);
    }

    /**
     * Method getIpAddresses returns collection of ip addresses
     *
     * @return ipAddresses collection of ip addresses.
     */
    public HashMap<String, Integer> getIpAddresses() {
        return ipAddresses;
    }
}

