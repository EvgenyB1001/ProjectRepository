package homework.verification;

/**
 * Class VerifyNoNumbers has only one method isNoNumbers, that verify the line
 * to have no numbers.
 */
public class VerifyNoNumbers {

    /**
     * Method isNotNumbers gets array of words from the line an checks every
     * word to have no numbers.
     *
     * @param words array of words from the line
     * @return boolean value: true - if there are no numbers
     */
    public static boolean isNotNumbers(String[] words) throws Exception {
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }
}
