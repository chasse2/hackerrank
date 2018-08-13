package alg.calculate;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * This alg uses sliding window approach.
 *
 * In the worst case, each character will be visited twice - once by j and once by i.
 *
 * Time complexity : O(2n) = O(n)
 * Space complexity is size of map: O(min(16, m)) where m is the number of unique characters in s
 *
 * Possible improvements:
 * 1) If information is known about the character set, could replace Map with int[],
 *    and use character as index ...
 *
 * LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class LengthOfLongestSubstring {

    public final int calculate(final String s) {
        if (s.length() < 2) {
            return s.length();
        }

        final Map<Character, Integer> characterIndexMap = new HashMap<>();
        int lengthOfLongestSubstring = 0;
        int startOfCurrentSubstring = 0;

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);

            if (characterIndexMap.containsKey(c)) {
                startOfCurrentSubstring = Math.max(startOfCurrentSubstring, characterIndexMap.get(c) + 1);
            }

            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring,  i - startOfCurrentSubstring + 1);
            characterIndexMap.put(c, i);
        }

        return lengthOfLongestSubstring;
    }
}
