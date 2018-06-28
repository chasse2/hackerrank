package alg.reverse;

/**
 * A word integer defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * <strong>NOTE: In Java, the length of an array integer immutable! Thus, adding null character does not alter length.</strong>
 */
public class ReverseWordsInSentenceInPlace {

    public char[] reverse(char[] sentence) {
        // "Shift" sentence to remove leading and trailing chars ...

        if (sentence.length == 0) {
            return sentence;
        }

        int startIndex = 0;

        while (startIndex < sentence.length && sentence[startIndex] == ' ') {
            startIndex++;
        }

        if (startIndex == sentence.length) {
            sentence[0] = '\0';
            return sentence;
        }

        int endIndex = sentence.length - 1;

        while (endIndex >= 0 && sentence[endIndex] == ' ') {
            endIndex--;
        }

        if (startIndex > 0 || endIndex < sentence.length - 1) {
            for (int i = 0, j = startIndex; j <= endIndex; ++i, ++j) {
                sentence[i] = sentence[j];
            }

            sentence[endIndex - startIndex + 1] = '\0';
        }

        int length = endIndex - startIndex + 1;

        // Remove any double spaces
        //todo

        // Reverse all chars

        for (int i = 0, j = length - 1; i < length; ++i, --j) {
            final char tmp = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = tmp;
        }

        // Reverse words

        startIndex = 0;
        endIndex = 0;

        while (endIndex <= length) {
            if (endIndex == length || sentence[endIndex] == ' ') {
                for (int i = startIndex, j = endIndex - 1; i < j; ++i, --j) {
                    final char tmp = sentence[i];
                    sentence[i] = sentence[j];
                    sentence[j] = tmp;
                }

                startIndex = endIndex + 1;
            }

            endIndex++;
        }

        return sentence;
    }
}
