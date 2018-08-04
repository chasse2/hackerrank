package alg.weirdleetcode;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * https://leetcode.com/problems/permutations-ii/description/
 * Beats 73.34% of Java submissions
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        final int numPermutations = this.numberOfUniquePermutations(nums);

        final List<List<Integer>> results = new ArrayList<>(numPermutations);
        results.add(toList(nums));

        for (int i = 1; i < numPermutations; i++) {
            nextPermutation(nums);
            results.add(toList(nums));
        }

        return results;
    }

    final private List<Integer> toList(final int[] nums) {
        final List<Integer> list = new ArrayList<>(nums.length);

        for (int num : nums) {
            list.add(num);
        }

        return list;
    }

    private int numberOfPermutationsIncludingDuplicates(final int[] arr) {
        int numPermutations = 1;

        for (int i = 1; i <= arr.length; i++) {
            numPermutations *= i;
        }

        return numPermutations;
    }

    private int numberOfUniquePermutations(final int[] nums) {
        final Map<Integer, Integer> characterCounts = new HashMap<>();
        for (int v : nums) {
            if (characterCounts.containsKey(v)) {
                int count = characterCounts.get(v);
                characterCounts.put(v, ++count);
            } else {
                characterCounts.put(v, 1);
            }
        }

        int numerator = numberOfPermutationsIncludingDuplicates(nums);
        int denominator = 1;

        for (Integer v : characterCounts.values()) {
            denominator *= factorial(v);
        }

        return numerator / denominator;
    }

    private void nextPermutation(final int[] nums) {
        int headOfSuffix = nums.length - 1;

        while (headOfSuffix > 0 && nums[headOfSuffix - 1] >= nums[headOfSuffix]) {
            headOfSuffix--;
        }

        if (headOfSuffix == 0) {
            reverse(nums, 0);          // Last permutation - simply reverse string and return
            return;
        }

        final int pivotIndex = headOfSuffix - 1;

        int suffixValueToSwap = nums.length - 1;
        while (nums[suffixValueToSwap] <= nums[pivotIndex]) {
            suffixValueToSwap--;
        }

        swap(nums, pivotIndex, suffixValueToSwap);
        reverse(nums, headOfSuffix);
    }

    private int factorial(final int v) {
        int result = 1;
        for (int i = v; i > 1; i--) {
            result *= i;
        }

        return result;
    }

    private void reverse(final int[] arr, int i) {
        int j = arr.length - 1;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(final int[] arr, int i, int j) {
        final int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
