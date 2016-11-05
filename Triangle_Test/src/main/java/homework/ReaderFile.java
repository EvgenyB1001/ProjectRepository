package homework;

import java.util.Scanner;

/**
 * Class gets data from user and return array of data
 */
public class ReaderFile {

    public double[] read() throws Exception {
        double[] parameters = new double[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parameters.length; i++) {
            System.out.println("Set " + (i + 1) + " side of triangle");
            parameters[i] = scanner.nextDouble();
        }
        return parameters;
    }
}