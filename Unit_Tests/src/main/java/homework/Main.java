package homework;

import homework.transport.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Class has entry point to the program
 */
public class Main {

    /**
     * Name of working file
     */
    private static final String FILE_NAME = "checkpoints.txt";

    /**
     * Count of passengers in bus
     */
    private static final int COUNT_BUS_PASSENGERS = 15;

    /**
     * Average speed of car
     */
    private static final double CAR_SPEED = 80;

    /**
     * Average speed of bus
     */
    private static final double BUS_SPEED = 60;

    /**
     * Average speed of bicycle
     */
    private static final double BICYCLE_SPEED = 30;

    /**
     * Average speed of walk
     */
    private static final double AFOOT_SPEED = 5;

    /**
     * Price of fuel
     */
    private static final BigDecimal FUEL_PRICE = new BigDecimal("1.32");

    /**
     * Method creates object, that read file, emulate movement of vehicles
     * and show statistics
     */
    public static void main(String[] args) {
        // write your code here
        try {
            // Path to working directory
            String dirPath = System.getProperty("user.dir");
            ReaderFile readerFile = new ReaderFile();
            // List of checkpoints
            ArrayList<String[]> checkpoints = readerFile.read(dirPath + "\\" + FILE_NAME);
            // List of vehicles
            HashMap<String, Moveable> moveables = new HashMap<>();
            moveables.put(Afoot.getName(), new Afoot(AFOOT_SPEED));
            moveables.put(Car.getName(), new Car(CAR_SPEED, FUEL_PRICE));
            moveables.put(Bicycle.getName(), new Bicycle(BICYCLE_SPEED));
            moveables.put(Bus.getName(), new Bus(BUS_SPEED, COUNT_BUS_PASSENGERS, FUEL_PRICE));
            Statistic statistic = new Statistic();
            for (Map.Entry<String, Moveable> vehicle : moveables.entrySet()) {
                moveVehicles(vehicle, checkpoints);
                statistic.showStatistic(vehicle);
            }
        } catch (NumberFormatException e) {
            System.err.println("Incorrect input. " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method emulates movement of vehicles from list, got as parameter, by all checkpoints also
     * got as parameter
     *
     * @param vehicle     list of vehicle
     * @param checkpoints list of checkpoints
     */
    public static void moveVehicles(Map.Entry<String, Moveable> vehicle,
                                    ArrayList<String[]> checkpoints) throws Exception {
        double[] coordinates = new double[2];
        coordinates[0] = Double.parseDouble(checkpoints.get(0)[0]);
        coordinates[1] = Double.parseDouble(checkpoints.get(0)[1]);
        vehicle.getValue().setStartCoordinates(coordinates[0], coordinates[1]);
        for (String[] coordinate : checkpoints) {
            // Emulates movement current vehicle by checkpoints
            vehicle.getValue().moveToNextCheckpoint(Double.parseDouble(coordinate[0]), Double.parseDouble(coordinate[1]));
        }
    }
}
