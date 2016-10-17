package homework;

/**
 * Class Ping emulates request of ip addresses and returns random time of requests
 */
public class Ping {

    /**
     * Method getPing returns request time
     *
     * @return int request time
     */
    public int getPing(String address) {
        return ((int) (Math.random() * 490) + 10);
    }
}