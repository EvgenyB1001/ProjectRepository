/** This program does 4 math operations (+, -, *, /). Each operation has there own method. */
public class Calculate {
    /** Method returns sum of parameters
     * @param param1 the first parameter of calculation
     * @param param2 the second parameter of calculation
     * @return the sum of two input parameters
     */
    private static double sum(double param1, double param2) {
        return param1 + param2;
    }

    /** Method returns difference of parameters
     * @param param1 the first parameter of calculation
     * @param param2 the second parameter of calculation
     * @return the difference of two input parameters
     */
    private static double difference(double param1, double param2) {
        return param1 - param2;
    }

    /** Method multiplies parameters and return result
     * @param param1 the first parameter of calculation
     * @param param2 the second parameter of calculation
     * @return te result of multiplication of two input parameters
     */
    private static double multiply(double param1, double param2) {
        return param1 * param2;
    }

    /** Method returns the result of the division
     * @param param1 the first parameter of calculation
     * @param param2 the second parameter of calculation
     * @return te result of division of two input parameters
     */
    private static double quotient(double param1, double param2) {
        return param1 / param2;
    }
    /** Method main gets parameters from command line, verifies parameteres and
     * outputs results of calculate operations
     */
    public static void main(String[] args) {
        double[] numbers = new double[args.length];
        /** It provides correct format of parameters and verifies that this is possible */
        try {
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Double.parseDouble(args[i]);
            }
        } catch(NumberFormatException e) {
            System.out.println("Required number, not line");
           return;
        }
        if (numbers.length >= 3) {
           System.out.println("Unnecessary parameters are ignored");
        }
       /** Verifies that there are not missed parameters */
        if (numbers.length <= 1) {
                System.out.println("Missed parameters. Expected two parameters");
                return;
            } else {
            System.out.println("a = "+ numbers[0] + ", b = "+numbers[1]);
            System.out.println("a + b = " + sum(numbers[0], numbers[1]));
            System.out.println("a * b = " + multiply(numbers[0],numbers[1]));
            System.out.println("a - b = " + difference(numbers[0], numbers[1]));
            /** If there are division by zero, it returns error. Otherwise, it returns result
             * of the calculation
             */
            if (Double.compare(numbers[1], 0) == 0) {
                System.out.println("Division by zero isn't accepted");
            } else {
                System.out.println("a / b = " + quotient(numbers[0], numbers[1]));
            }
        }
    }
}


