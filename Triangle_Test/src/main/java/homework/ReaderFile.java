package homework;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Class gets data from user and return array of data
 */
public class ReaderFile {

    public BigDecimal[] read() throws Exception {
        BigDecimal[] parameters = new BigDecimal[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parameters.length; i++) {
            System.out.println("Set " + (i + 1) + " side of triangle");
            parameters[i] = scanner.nextBigDecimal();
        }
        return parameters;
    }
}