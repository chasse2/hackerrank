package alg.calculate;

import java.util.*;

public class LengthOfLongestSubstringWithoutRepeatingCharacters {

    public final int calculate(final String s) {
        int lengthOfLongest = 0;

        final Map<Integer, Character> indexToLetterMap = new HashMap<>();
        final Map<Character, Integer> letterToIndexMap = new HashMap<>();
        int startOfCurrent = 0;

        for (int i = 0; i < s.length(); ++i) {
            final char letter = s.charAt(i);

            if (letterToIndexMap.containsKey(letter)) {
                int indexOfPreviousOccurrence = letterToIndexMap.get(letter);

                for (int j = startOfCurrent; j <= indexOfPreviousOccurrence; ++j) {
                    final Character characterToRemove = indexToLetterMap.get(j);
                    letterToIndexMap.remove(characterToRemove);
                    indexToLetterMap.remove(j);
                }

                startOfCurrent = indexOfPreviousOccurrence + 1;
            }

            indexToLetterMap.put(i, letter);
            letterToIndexMap.put(letter, i);

            int lengthOfCurrent = i - startOfCurrent + 1;

            if (lengthOfCurrent > lengthOfLongest) {
                lengthOfLongest = lengthOfCurrent;
            }
        }

        return lengthOfLongest;
    }
}
