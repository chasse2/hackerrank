package alg.calculate;

import java.util.*;

/**
 * Uses sliding window approach.
 *
 * In the worst case, each character will be visited twice - once by j and once by i.
 *
 * Time complexity : O(2n) = O(n)
 * Space complexity is size of map: O(min(16, m)) where m is the number of unique characters in s
 */
public class LengthOfLongestSubstringWithoutRepeatingCharacters {

    public final int calculate(final String s) {
        int answer = 0;
        final Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); ++j) {
            final Character c = s.charAt(j);

            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }

            answer = Math.max(answer, j - i + 1);
            map.put(c, j);
        }

        return answer;
    }
}
