package homework.verification;

/**
 * Class VerifyWords has only one method isWordsBelong, that verify the line
 * to have words from the dictionary.
 */
public class VerifyWords {

    /**
     * Array dictionary has words to compare with words from the input line.
     */
    private static String[] dictionary = {"Zhenya", "Borbut", "Homework"};

    /**
     * Method isWordsBelong gets array of words from the line and verifies that there
     * are words from dictionary.
     *
     * @param words array of words from the line.
     * @return boolean value: true - if there are words from dictionary
     */
    public static boolean isWordsBelong(String[] words) {
        for (String s : words) {
            for (int i = 0; i < dictionary.length; i++) {
                if (s.equals(dictionary[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
