package homework.verification;

/**
 * Class VerifyOnlyNumbers has only one method isOnlyNumbers, that verify the line
 * to have only numbers.
 */
public class VerifyOnlyNumbers {

    /**
     * Method isOnlyNumbers gets array of words from the line an checks every
     * word to have only numbers.
     *
     * @param words array of words from the line
     * @return boolean value: true - if there are only numbers
     */
    public static boolean isOnlyNumbers(String[] words) throws Exception {
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (!(Character.isDigit(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
