package homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Object of this class keeps ip addresses and their request time
 */
public class DataKeeper {

    /**
     * Regular expression to verify correct ip address
     */
    private static final String REG_EX_IPV4 = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    /**
     * Collection of ip addresses and their request time
     */
    private HashMap<String, Integer> data = new HashMap<>();

    /**
     * Method adds new time to collection
     *
     * @param ip   ip address
     * @param time request time
     */
    public void setNewData(String ip, int time) {
        if (validateIp(ip)) {
            data.put(ip, time);
        } else {
            System.out.println("Incorrect ip address " + ip);
        }
    }

    /**
     * Method finds maximal request time in collection
     *
     * @return max maximal request time
     */
    public int getMaxTime() {
        int max = 0;
        for (Map.Entry<String, Integer> ip : data.entrySet()) {
            if (ip.getValue() > max) {
                max = ip.getValue();
            }
        }
        return max;
    }

    /**
     * Method returns collection of ip addresses and their request time
     *
     * @return data collection of ip addresses and their request time
     */
    public HashMap<String, Integer> getIpCollection() {
        return data;
    }

    /**
     * Method validateIp gets ip address and validate it.
     *
     * @param ip ip address
     * @return boolean value: true - ip address is correct
     */
    public boolean validateIp(String ip) {
        return (ip.matches(REG_EX_IPV4));
    }
}
