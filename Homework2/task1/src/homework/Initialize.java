package homework;

import java.util.Scanner;

/**
 * Class Initialize has methods setLine that input line from keyboard,
 * validate them and returns an array of words form the line.
 */
public class Initialize {

    /**
     * Method setLine input the line from keyboard, splits the words
     * (delimiters are whitespace and comma). It returns an array of words.
     * Also method verify that line isn't empty.
     *
     * @return array of words from the input line
     */
    public  String[] setLine() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set line");
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            throw new Exception("The line is empty");
        }
        // Words are split and set to an array
        String[] array = line.split("\\s|\\,");
        return array;
    }
}