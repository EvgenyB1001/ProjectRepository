package homework;

import java.util.*;

/**
 * Class Ping emulates request of ip addresses and write down random time of requests
 * to the collection of ip addresses
 */
public class Ping {

    /**
     * Collection of ip addresses
     */
    private HashMap<String, Integer> pingAddresses = new HashMap<>();

    /**
     * Regular expression to verify correct ip address
     */
    private String regExIpV4 = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    /**
     * Constructor Ping gets collection of ip addresses and complements it
     * with random time of emulating request
     *
     * @param ipAddresses collection of ip addresses
     */
    public Ping(HashMap<String, Integer> ipAddresses) throws Exception {
        for (Map.Entry<String, Integer> ip: ipAddresses.entrySet()) {
            // Verify correct ip address
            if (validateIp(ip.getKey())) {
                ipAddresses.replace(ip.getKey(), ((int) (Math.random() * 490) + 10));
            } else {
                throw new Exception("Incorrect ip address");
            }
            pingAddresses = ipAddresses;
        }
    }

    /**
     * Method getPing return complemented collection of ip addresses and
     * their request time
     *
     * @return pingAddresses collection of ip addresses an request time
     */
    public HashMap<String, Integer> getPing() {
        return pingAddresses;
    }

    /**
     * Method validateIp gets ip address and validate it.
     *
     * @param ip ip address
     * @return boolean value: true - ip address is correct
     */
    private boolean validateIp(String ip) {
        return (ip.matches(regExIpV4));
    }
}