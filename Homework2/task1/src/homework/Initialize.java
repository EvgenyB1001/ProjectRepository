package homework;

import java.util.Scanner;

/**
 * Class Initialize has methods setLine and validation, that input line from keyboard,
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
    public static String[] setLine() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set line");
        String line = scanner.nextLine();
        scanner.close();
        // If the line is empty, method throws exception
        if (line.isEmpty()) {
            throw new Exception("Empty line");
        }
        // All commas are replaced by whitespace to facilitate split words
        line = line.replace(',', ' ');
        // Words are split and set to an array
        String[] array = line.split(" ");
        validation(array);
        return array;
    }

    /**
     * Method validation verifies the line to have some words. If there are no words,
     * it throws exception.
     *
     * @param array array of words.
     */
    public static void validation(String[] array) throws Exception {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                count++;
            }
        }
        // If there are no words, method throws exception
        if (count == array.length) {
            throw new Exception("There are no words");
        }
    }
}
