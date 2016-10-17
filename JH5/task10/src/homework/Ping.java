package homework;

/**
 * Class Ping emulates request of ip addresses and returns random time of requests
 */
public class Ping {

    /**
     * Method getPing gets ip address and returns random integer value (10 - 500)
     * as request time
     *
     * @param address ip address
     * @return int request time
     */
    public int getPing(String address) {
        return ((int) (Math.random() * 490) + 10);
    }
}