package com.homework;
import java.io.*;
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
     * @return verify boolean value: if true - values of sides are correct
     */
    public static boolean verifySides(double [] params) {
        boolean verify = false;
        // Verifies values of sides
        for (int i = 0; i < params.length; i++) {
            if (Double.compare(params[i], 0) <= 0) {
                System.out.println("Incorrect side value of triangle");
                return verify;
            }
        }
        // Checks that the triangle exists
        if (params[0] < params[1] + params[2] && params[0] > Math.abs(params[1] - params[2])) {
            verify = true;
        } else {
            System.out.println("Triangle doesn't exist with such values of sides");
            verify = false;
            return verify;
        }
        return verify;
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < parameters.length; i++) {
                System.out.println("Set " + (i + 1) + " side of triangle");
                parameters[i] = Double.parseDouble(reader.readLine());
            }
            // Catches exceptions if there are not valid input data
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input data. Expected double input format");
            return;
        } catch (Exception e2) {
            System.out.println("Input exception");
            return;
        }
        // Calls methods to verify values and to determine the type of triangle
        if (verifySides(parameters) == true) {
            detectTriangle(parameters);
        }
    }
}
