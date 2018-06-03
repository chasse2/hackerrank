package alg.reverse;

/**
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * <strong>NOTE: In Java, the length of an array is immutable! Thus, adding null character does not alter length.</strong>
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

        // Remove any double spaces

        int effectiveEndIndex = endIndex = startIndex + 1;

        for (int i = 0; i < effectiveEndIndex - 1; ++i) {
            if (sentence[i] == ' ' && sentence[i + 1] == ' ') {
                int startOfNextWord = i + 1;

                while (sentence[startOfNextWord] == ' ') {
                    startOfNextWord++;
                }


            }
        }
        //todo

        // Reverse all chars

//        for (int i = 0, j = length - 1; i < length; ++i, --j) {
//            final char tmp = sentence[i];
//            sentence[i] = sentence[j];
//            sentence[j] = tmp;
//        }
//
//        // Reverse words
//
//        int startIndex = 0;
//        int endIndex = 0;
//
//        while (endIndex <= length) {
//            if (endIndex == length || sentence[endIndex] == ' ') {
//                for (int i = startIndex, j = endIndex - 1; i < j; ++i, --j) {
//                    final char tmp = sentence[i];
//                    sentence[i] = sentence[j];
//                    sentence[j] = tmp;
//                }
//
//                startIndex = endIndex + 1;
//            }
//
//            endIndex++;
//        }

        // Remove leading, trailing, and double spaces ...

//        int insertionIndex = 0;
//        int startOfNextWordIndex = 0;
//
//        while (true) {
//            while (startOfNextWordIndex < length && sentence[startOfNextWordIndex] == ' ') {
//                startOfNextWordIndex++;
//            }
//
//            if (startOfNextWordIndex == length) {
//                sentence[insertionIndex] = '\0';
//                break;
//            }
//
//            int endOfNextWordIndex = startOfNextWordIndex;
//
//            while (endOfNextWordIndex < length && endOfNextWordIndex != ' ') {
//                endOfNextWordIndex++;
//            }
//
//            while (endIndex < length && sentence[endIndex] == ' ') {
//                endIndex++;
//            }
//
//            for (int i = startOfNextWordIndex; i < endOfNextWordIndex; ++i) {
//                sentence[insertionIndex++] = sentence[i];
//            }
//
//            startOfNextWordIndex = endOfNextWordIndex;
//        }

        return sentence;
    }
}
