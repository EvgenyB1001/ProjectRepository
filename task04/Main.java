package com.homework;
import java.lang.*;
import java.util.*;

/**
 * The program calculates real roots of quadratic equation. Parameters of
 * quadratic equation got from the keyboard and shows to the command line
 */
public class Main {
    /**
     * Method calculateEquation gets array of parameters, verifies
     * that discriminant isn't negative. The method shows outputs result
     * of calculation to the command line.
     * @param params array of the parameters of quadratic equation
     */
    public static void calculateEquation (double[] params) {
        double[] result = new double[2];
        // Calculates discriminant of the quadratic equation
        double discriminant = params[1] * params[1] - 4 * params[0] * params[2];
        //Verifies and performs actions in case of negative and null discriminant
        if (Double.compare(discriminant, 0) < 0) {
            System.out.println("Negative discriminant. Program calculates only real roots");
            return;
        } else if (Double.compare(discriminant, 0) == 0) {
            result[0] = - params[1] / (2 * params[0]);
            result[1] = result[0];
            System.out.println("Result: x1 = " + result[0] + ", x2 = " + result[1]);
            return;
        }
        // Calculates roots of the quadratic equation
        result[0] = (- params[1] + Math.sqrt(discriminant)) / (2 * params[0]);
        result[1] = (- params[1] - Math.sqrt(discriminant)) / (2 * params[0]);
        System.out.println("Result: x1 = " + result[0] + ", x2 = " + result[1]);
    }

    /**
     * Method verifySpecialCases checks, isn't the equation quadratic and if it is
     * returns true.
     * @param params array of parameters to check
     * @return compare boolean value: false - if equation is quadratic
     */
    public static boolean verifyNotQuadratic(double [] params) {
        // Verify, if the equation isn't quadratic
        if (Double.compare(params[0], 0) == 0) {
            System.out.println("Equation isn't quadratic. Set parameters of quadratic equation");
            return true;
        }
        return false;
    }

   /**
     * Method main gets parameters of the quadratic equation from the keyboard,
     * send them to the method calculateEquation.
     * */
   public static void main(String[] args) {
        double [] parameters = new double[3];
        Scanner scanner = new Scanner(System.in);
        // Verifies that input parameters are numbers
        try {
            for (int i = 0; i < parameters.length; i++) {
                System.out.println("Set " + ( i + 1) + " parameter");
                parameters[i] = scanner.nextDouble();
            }
        } catch (InputMismatchException e1) {
            System.out.println("Incorrect input values. Expected double format");
            return;
        }
        // Verifies, is the equation quadratic
        if (!(verifyNotQuadratic(parameters))) {
            calculateEquation(parameters);
        }
   }
}
