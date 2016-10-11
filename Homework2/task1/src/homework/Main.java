package homework;

import homework.verification.*;

import java.util.ArrayList;

/**
 * Class Main has entry point to program.
 * It has two methods: main and notAnyRule.
 */
public class Main {

    /**
     * Method noAnyRule gets array of boolean parameters and depending on values of the parameters
     * output information, doesn't the line comply to any rule .
     *
     * @param list list of boolean values.
     */
    public static void notAnyRule(ArrayList<Boolean> list) {
        int count = 0;
        for (Boolean b : list) {
            if (!b) {
                count++;
            }
        }
        if (count == list.size()) {
            System.out.println("Line doesn't comply any rule");
        }
    }

    /**
     * Method main calls methods Initialize.setLine and showInfo to input the line from
     * keyboard and detect, to what rule does the line comply.
     */
    public static void main(String[] args) {
        try {
            // Initialize the line.
            Initialize initializer = new Initialize();
            String[] words = initializer.setLine();
            // Creates object, that verifies the line
            VerifyNoNumbers noNumbers = new VerifyNoNumbers();
            VerifyOnlyNumbers onlyNumbers = new VerifyOnlyNumbers();
            VerifyFiveWords fiveWords = new VerifyFiveWords();
            VerifyWords dictWords = new VerifyWords();
            // Set list of boolean values - results of checking rules.
            ArrayList<Boolean> array = new ArrayList<>();
            array.add(noNumbers.isNotNumbers(words));
            array.add(onlyNumbers.isOnlyNumbers(words));
            array.add(fiveWords.isFiveWords(words));
            array.add(dictWords.isWordsBelong(words));
            notAnyRule(array);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }
}