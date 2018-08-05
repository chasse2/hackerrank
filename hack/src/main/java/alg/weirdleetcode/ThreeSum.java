package alg.weirdleetcode;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * Algorithm:
 * Iterate over nums, making each one the "first" num
 * Perform "Two Sum" solution on remaining numbers, with the first as the target sum
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * https://leetcode.com/problems/3sum/description/
 * Beats only 2.84%! :-(
 * Time Complexity is O(n-squared)
 * Space Complexity is O(n)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> uniqueResults = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i];

            Set<Integer> candidates = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int v2 = nums[j];
                int v3 = 0 - v1 - v2;
                if (candidates.contains(v3)) {
                    List<Integer> result = new ArrayList<>(3);
                    result.add(v1);
                    result.add(v2);
                    result.add(v3);
                    uniqueResults.add(result);
                }
                candidates.add(v2);
            }
        }

        List<List<Integer>> results = new LinkedList<>();
        uniqueResults.forEach(x -> results.add(x));

        return results;
    }
}
