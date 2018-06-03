package alg.reverse;

/**
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInSentence {

    public final String reverse(final String sentence) {
        final int length = sentence.length();
        final char[] reversed = new char[sentence.length()];

        for (int i = 0, j = length - 1; i < length; ++i, --j) {
            reversed[j] = sentence.charAt(i);
        }

        int startIndex = 0;
        int endIndex = 0;

        while (endIndex <= length) {
            if (endIndex == length || reversed[endIndex] == ' ') {
                for (int i = startIndex, j = endIndex - 1; i < j; ++i, --j) {
                    final char tmp = reversed[i];
                    reversed[i] = reversed[j];
                    reversed[j] = tmp;
                }

                startIndex = endIndex + 1;
            }

            endIndex++;
        }

        return new String(reversed).trim().replaceAll("\\s+", " ");
    }
}
