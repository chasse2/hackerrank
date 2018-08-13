package alg.weirdleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Find length of longest unique substring.
 *
 * Algorithm:
 * Set lengthOfLongestSubstring and startOfCurrentSubstring to 0.
 * Iterate over string.
 * For each character:
 *   If it has already been seen (is in map), then
 *     update startOfCurrentSubstring to max(startOfCurrentSubstring, indexOfLastOccurrence + 1)
 *   Update lengthOfLongestSubstring to max(lengthOfLongestSubstring, i - startOfCurrentSubstring + 1
 *   Add character and index to map
 * Return lengthOfLongestSubstring
 *
 * Leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 * This is the most efficient one in the descriptions
 *
 * Time complexity: O(n)
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
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
