package com.homework;
import java.util.*;
import java.lang.*;

/**
 * Program gets values of sides of triangle and
 * outputs the type of triangle
 */
public class Main {
    /**
     * Method verifySides gets values of sides and verify that values are correct
     * and the triangle with this sides exists.
     * @param params array of values of sides
     * @return boolean value: true - values of sides are correct
     */
    public static boolean verifySides(double [] params) {
        // Verifies values of sides
        for (int i = 0; i < params.length; i++) {
            if (Double.compare(params[i], 0) <= 0) {
                System.out.println("Incorrect side value of triangle");
                return false;
            }
        }
        // Checks that the triangle exists
        if (params[0] >= params[1] + params[2] || params[0] <= Math.abs(params[1] - params[2])) {
            System.out.println("Triangle doesn't exist with such values of sides");
            return false;
        }
        return true;
    }

    /**
     * Method detectTriangle determines what type of triangle is
     * @param params array of values of sides
     */
    public static void detectTriangle(double [] params) {
        int count = 0;
        // Counts number of equal sides
        for (int i = 0; i < params.length; i++) {
            for (int j = i + 1; j < params.length; j++) {
                if (params[i] == params[j]) {
                    count++;
                }
            }
        }
        // Determines the type of triangle depending on the number of equal sides
        switch (count) {
            case 0:
                System.out.println("Triangle is normal");
                return;
            case 1:
                System.out.println("Triangle is isosceles");
                return;
            case 3:
                System.out.println("Triangle is equilateral");
                return;
            default:
        }
    }

    /**
     * Method main gets values of sides from the keyboard and calls methods
     * to verify values of sides and to determine the type of triangle
     */
    public static void main(String[] args) {
        double[] parameters = new double[3];
        Scanner scanner = new Scanner(System.in);
        // Catches exceptions if there are not valid input data
        try {
            for (int i = 0; i < parameters.length; i++) {
                System.out.println("Set " + (i + 1) + " side of triangle");
                parameters[i] = scanner.nextDouble();
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input data. Expected double input format");
            return;
        }
        // Calls methods to verify values and to determine the type of triangle
        if (verifySides(parameters) == true) {
            detectTriangle(parameters);
        }
    }
}
