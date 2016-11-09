package homework;

import java.math.BigDecimal;
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
            ReaderFile readerFile = new ReaderFile();
            TriangleTypeDetector detector = new TriangleTypeDetector();
            BigDecimal[] sides = readerFile.read();
            System.out.println(detector.detectTriangle(sides[0], sides[1], sides[2]));
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input data");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}