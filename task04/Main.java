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
     * that discriminant isn't negative. The method returns array
     * of equation roots
     * @param params array of the parameters of quadratic equation
     * @return array of equation roots
     */
    public static double[] calculateEquation (double[] params) {
        double[] result = new double[2];
        // Calculates discriminant of the quadratic equation
        double discriminant = params[1] * params[1] - 4 * params[0] * params[2];
        //Verifies and performs actions in case of negative and null discriminant
        if (Double.compare(discriminant, 0) < 0) {
            System.out.println("Negative discriminant. Program calculates only real roots");
            return result;
        } else if (Double.compare(discriminant, 0) == 0) {
            result[0] = - params[1] / (2 * params[0]);
            result[1] = result[0];
            return result;
        }
        // Calculates square root of the discriminant
        double radicalDiscriminant = Math.sqrt(discriminant);
        // Calculates roots of the quadratic equation
        result[0] = (- params[1] + radicalDiscriminant) / (2 * params[0]);
        result[1] = (- params[1] - radicalDiscriminant) / (2 * params[0]);
        return result;
    }

    /**
     * Method verifySpecialCases checks, isn't the equation quadratic and if it is
     * returns true. Also it verifies is there the special zero result of equation
     * and, if it is, shows info and returns true
     * @param params array of parameters to check
     * @return compare boolean value: false - if equation is quadratic and has no special result
     */
    public static boolean verifySpecialCases(double [] params) {
        boolean compare = false;
        // Checks, if there are special results
        if (Double.compare(params[1], 0) == 0 && Double.compare(params[2], 0) == 0) {
            System.out.println("The root is 0");
            compare = true;
            return compare;
        }
        // Verify, if the equation isn't quadratic
        if (Double.compare(params[0], 0) == 0) {
            System.out.println("Equation isn't quadratic. Set parameters of quadratic equation");
            compare = true;
            return compare;
        }
        return compare;
    }

   /**
     * Method main gets parameters of the quadratic equation from the keyboard,
     * send them to the method calculateEquation. It gets array of roots and outputs
     * them in command line
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
        // Verifies, is the equation quadratic and is there a special result
        if (verifySpecialCases(parameters)) {
            return;
        }
        double [] result = calculateEquation(parameters);
        // Outputs roots of the equation
        if (Double.compare(result[0], 0) == 0 && Double.compare(result[1], 0) == 0) {
           System.out.println("There is no roots");
        } else {
           for (int i = 0; i < result.length; i++) {
               System.out.println("Result x" + (i + 1) + " = " + result[i]);
           }
        }
   }
}
