package com.homework;
import java.io.*;
import java.lang.*;

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
        double discriminant;
        double radicalDiscriminant;
        // Calculates discriminant of the quadratic equation
        discriminant = params[1] * params[1] - 4 * params[0] * params[2];
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
        radicalDiscriminant = Math.sqrt(discriminant);
        // Calculates roots of the quadratic equation
        result[0] = (- params[1] + radicalDiscriminant) / (2 * params[0]);
        result[1] = (- params[1] - radicalDiscriminant) / (2 * params[0]);
        return result;
    }

   /**
     * Method main gets parameters of the quadratic equation from the keyboard,
     * send them to the method calculateEquation. It gets array of roots and outputs
     * them in command line
     * */
   public static void main(String[] args) {
        double [] parameters = new double[3];
        double [] result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Verifies that input parameters are numbers
        try {
            for (int i = 0; i < parameters.length; i++) {
                System.out.println("Set " + (i + 1) + " parameter");
                parameters[i] = Double.parseDouble(reader.readLine());
            }
        } catch (NumberFormatException e){
            System.out.println("Incorrect input data. Expected double format");
            return;
        } catch (Exception e1) {
            System.out.println("Input exception");
            return;
        }
        // Checks special cases of input parameters
        if (Double.compare(parameters[0], 0) == 0) {
            System.out.println("Equation isn't quadratic. Set parameters of quadratic equation");
            return;
        } else if (Double.compare(parameters[1], 0) == 0 && Double.compare(parameters[2], 0) == 0) {
            System.out.println("The root is 0");
            return;
        }
        result = calculateEquation(parameters);
        // Checks, if there are no roots, program shows info
        if (Double.compare(result[0], 0) == 0 && Double.compare(result[1], 0) == 0) {
            System.out.println("There is no roots");
            return;
        }
        //Checks, if roots are equal and outputs in there own way
        if (Double.compare(result[0], result[1]) == 0) {
            System.out.println("The only root is " + result[1]);
            return;
        }
        // Outputs roots of the equation
        for (int i = 0; i < result.length; i++) {
            System.out.println("Result x" + (i + 1) + " = " + result[i]);
        }
    }
}
