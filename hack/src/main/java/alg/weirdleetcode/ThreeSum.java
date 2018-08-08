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
 * Algorithm (not best - best seems to involve some kind of binary search):
 * Iterate over nums, making each one the "first" num
 * Perform "Two Sum" solution on remaining numbers, with the first as the target sum
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * https://leetcode.com/problems/3sum/description/
 * Beats only 4.34%! :-(                            ========== MAY REVISIT =========
 * Time Complexity is O(n-squared)
 * Space Complexity is O(n)
 *
 *  Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 *  Best algorithm (not best - best seems to involve some kind of binary search):
 *  [
 *     [-1, 0, 1],
 *     [-1, -1, 2]
 *   ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // if (nums[i] > 0) break;
            twosum(nums, i+1, -nums[i], result);
        }
        return result;
    }

    private void twosum(int[] nums, int start, int target, List<List<Integer>> result) {
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] == target) {
                result.add(Arrays.asList(-target, nums[lo], nums[hi]));
                lo++;
                hi--;
                while (lo < hi && nums[lo] == nums[lo-1]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == nums[hi+1]) {
                    hi--;
                }
            } else if (nums[lo] + nums[hi] > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }

    /*
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
                    uniqueResults.add(Arrays.asList(v1, v2, v3));
                }
                candidates.add(v2);
            }
        }

        List<List<Integer>> results = new LinkedList<>();
        uniqueResults.forEach(x -> results.add(x));

        return results;
    }
    */
}
