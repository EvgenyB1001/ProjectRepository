package homework.verification;

/**
 * Class VerifyFiveWords has only one method isFiveWords, that verify the line
 * to have five or more words.
 */
public class VerifyFiveWords {

    /**
     * Method isFiveWords gets array of words from the line and verifies that
     * there are five or more words.
     *
     * @param words array of words from the line.
     * @return boolean value: true - if there are more than five words.
     */
    public static boolean isFiveWords(String[] words) {
        int count = 0;
        for (String s : words) {
            if (!(s.equals(""))) {
                count++;
            }
        }
        return (count >= 5);
    }
}
