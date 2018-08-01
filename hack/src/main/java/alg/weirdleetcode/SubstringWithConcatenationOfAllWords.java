package alg.weirdleetcode;

import java.util.*;

/**
 * You are given a string, s,
 * and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 *
 * NOTE: As of 2018-08-01, there is an error in the test cases whereby not all words
 * are of the same length
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> result = new LinkedList<>();

        if (words.length == 0) {
            return result;
        }

        final int wordLength = words[0].length();

        final Set<String> unusedWords = new HashSet<>();
        for (String word : words) {
            unusedWords.add(word);
        }

        final Set<String> usedWords = new HashSet<>();

        int currentStartIndex = 0;

        for (int i = 0; i < s.length(); i+= wordLength) {
            final String substr = s.substring(i, i + wordLength);

            if (!unusedWords.contains(substr)) {
                unusedWords.addAll(usedWords);
                usedWords.clear();
                currentStartIndex = i + wordLength;
                continue;
            }

            if (unusedWords.size() == 1) {
                result.add(currentStartIndex);
                unusedWords.addAll(usedWords);
                usedWords.clear();
                currentStartIndex = i + wordLength;
                continue;
            }

            usedWords.add(substr);
            unusedWords.remove(substr);
        }

        return result;
    }
}
