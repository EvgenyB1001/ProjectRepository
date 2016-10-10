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
            String[] words = Initialize.setLine();
            // Set list of boolean values - results of checking rules.
            ArrayList<Boolean> array = new ArrayList<>();
            array.add(VerifyNoNumbers.isNotNumbers(words));
            array.add(VerifyOnlyNumbers.isOnlyNumbers(words));
            array.add(VerifyFiveWords.isFiveWords(words));
            array.add(VerifyWords.isWordsBelong(words));
            notAnyRule(array);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }
}
