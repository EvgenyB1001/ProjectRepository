package homework;

import homework.transport.Moveable;

import java.util.Map;

/**
 * Class outputs statistics of travel of definite vehicle
 */
public class Statistic {

    /**
     * Method outputs information of time and cost of travel of definite vehicle
     *
     * @param vehicle list of vehicles
     */
    public void showStatistic(Map.Entry<String, Moveable> vehicle) {
        System.out.println("Vehicle \"" + vehicle.getKey() + "\":");
        System.out.printf("time (h) = " + "%.2f"
                + "\n", vehicle.getValue().getTravelTime());
        System.out.printf("cost (USD) = " + "%.2f"
                + "\n", vehicle.getValue().getTravelCost());
        System.out.println("");
    }
}
