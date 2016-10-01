//This program does 4 math operations (+, -, *, /). Each operation has there own method.
public class Calculate {
    //Method returns sum of parameters
    private static double sum(double param1, double param2) {
        return param1 + param2;
    }

    //Method returns difference of parameters
    private static double difference(double param1, double param2) {
        return param1 - param2;
    }

    //Method multiplies parameters and return result
    private static double multiply(double param1, double param2) {
        return param1 * param2;
    }

    //Method verifies parameters and return quotient
    private static double quotient(double param1, double param2) {
        if (param2 == 0) {
            System.out.println("Division by zero is not accepted. Return the first parameter");
            return param1;
        }
        return param1 / param2;
    }

    public static void main(String[] args) {
        double[] numbers = new double[args.length];
        //It provides correct format of parameters and verifies that this is possible
       try {
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Double.parseDouble(args[i]);
            }
            }
       catch(NumberFormatException e) {
            System.out.println("Required number, not line");
           return;
        }
       if (numbers.length >= 3) {
           System.out.println("Unnecessary parameters are ignored");
       }
       // //More than 2 parameters in unnecessary
        if (numbers.length==0) {
                System.out.println("No parameter to calculate");
                return;
            } else if (numbers.length == 1) {
                System.out.println("a = "+ numbers[0] + ", b = 0");
                System.out.println("a + b = " + sum(numbers[0], 0));
                System.out.println("a * b = " + multiply(numbers[0], 0));
                System.out.println("a - b = " + difference(numbers[0], 0));
                System.out.println("Result is infinity");
            } else {
            System.out.println("a = "+ numbers[0] + ", b = "+numbers[1]);
            System.out.println("a + b = " + sum(numbers[0], numbers[1]));
            System.out.println("a * b = " + multiply(numbers[0],numbers[1]));
            System.out.println("a - b = " + difference(numbers[0], numbers[1]));
            System.out.println("a / b = " + quotient(numbers[0], numbers[1]));
        }
    }
}


