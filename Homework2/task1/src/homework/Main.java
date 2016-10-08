package homework;

import homework.verification.*;

/**
 * Class Main has entry point to program.
 * It has two methods: main and showInfo.
 */
public class Main {

    /**
     * Method showInfo gets boolean parameters and depending on values of the parameters
     * output information, does the line complies to rules.
     *
     * @param noNumbers   boolean value: true - if there are no numbers in line.
     * @param onlyNumbers boolean value: true - if there are only numbers in line.
     * @param fiveWords   boolean value: true - if there are five or more words in line.
     * @param dictWords   boolean value: true - if there are one or more words from dictionary in line.
     */
    public static void showInfo(boolean noNumbers, boolean onlyNumbers, boolean fiveWords, boolean dictWords) {
        if (noNumbers) {
            System.out.println("The line has no numbers");
        }
        if (onlyNumbers) {
            System.out.println("The line has only numbers");
        }
        if (fiveWords) {
            System.out.println("The line has five or more words");
        }
        if (dictWords) {
            System.out.println("The line has word(s) from dictionary");
        }
    }

    /**
     * Method main calls methods Initialize.setLine and showInfo to input the line from
     * keyboard and detect, to what rule does the line comply.
     */
    public static void main(String[] args) {
        try {
            // Initialize the line.
            String[] words = Initialize.setLine();
            // Show, to what rule does the line comply.
            showInfo(VerifyNoNumbers.isNotNumbers(words), VerifyOnlyNumbers.isOnlyNumbers(words),
                    VerifyFiveWords.isFiveWords(words), VerifyWords.isWordsBelong(words));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }
}
