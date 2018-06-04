package alg.calculate;

import java.util.*;

public class LengthOfLongestSubstringWithoutRepeatingCharacters {

    public final int calculate(final String s) {
        int lengthOfLongest = 0;

        final Map<Character, Integer> letterToIndexMap = new HashMap<>();
        int startOfCurrent = 0;

        for (int i = 0; i < s.length(); ++i) {
            final char letter = s.charAt(i);

            if (letterToIndexMap.containsKey(letter)) {
                int indexOfPreviousOccurrence = letterToIndexMap.get(letter);

                if (indexOfPreviousOccurrence >= startOfCurrent) {
                    startOfCurrent = indexOfPreviousOccurrence + 1;
                }
            }

            letterToIndexMap.put(letter, i);

            int lengthOfCurrent = i - startOfCurrent + 1;

            if (lengthOfCurrent > lengthOfLongest) {
                lengthOfLongest = lengthOfCurrent;
            }
        }

        return lengthOfLongest;
    }
}
