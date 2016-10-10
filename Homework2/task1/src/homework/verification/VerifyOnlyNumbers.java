package homework.verification;

/**
 * Class VerifyOnlyNumbers has only one method isOnlyNumbers, that verify the line
 * to have only numbers.
 */
public class VerifyOnlyNumbers {

    /**
     * Method isOnlyNumbers gets array of words from the line an checks
     * if there are only numbers and outputs result of check.
     *
     * @param words array of words from the line
     * @return boolean value: true - if there are only numbers
     */
    public static boolean isOnlyNumbers(String[] words) {
        // if length is 1, then in line there are only symbols and no whitespaces and commas
        if (words.length == 1) {
            for (int i = 0; i < words[0].length(); i++) {
                if (!(Character.isDigit(words[0].charAt(i)))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        System.out.println("The line has only numbers");
        return true;
    }
}
