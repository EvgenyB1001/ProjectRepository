package homework;

import java.util.*;

/**
 * Main class of application. Contains an entry point.
 */
public class Main {

    /**
     * Method main creates objects that initialize triangle and determine the type of triangle
     */
    public static void main(String[] args) {
        try {
            Initializer initializer = new Initializer();
            TriangleTypeDetector detector = new TriangleTypeDetector();
            double[] sides = initializer.initialize();
            System.out.println(detector.detectTriangle(sides[0], sides[1], sides[2]));
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input data. Expected double input format");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}