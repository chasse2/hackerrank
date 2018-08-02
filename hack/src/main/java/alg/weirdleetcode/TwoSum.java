package alg.weirdleetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Best Algorithm is One-Pass hash table:
 * Can do it one pass using hash map.
 * While iterating and inserting into the map, check to see if complement has already been inserted.
 * Ensure first index and second indices are returned in proper order.
 * This also handles case of duplicate values properly.
 *
 * https://leetcode.com/problems/two-sum/description/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Beats 97.41% of Java submissions
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            final int complement = target - nums[i];
            if (values.containsKey(complement)) {
                return new int[]{ values.get(complement), i };
            }

            values.put(nums[i], i);
        }

        return null;
    }
}
