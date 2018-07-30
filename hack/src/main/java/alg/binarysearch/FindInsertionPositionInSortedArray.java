package alg.binarysearch;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Leetcode: https://leetcode.com/problems/search-insert-position/description/
 * Beats 100% of Java submissions
 */
public class FindInsertionPositionInSortedArray {
    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                if (mid == 0) {
                    return 0;
                }
                if (target > nums[mid - 1]) {
                    return mid;
                }

                high = mid - 1;
            } else {
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                low = mid + 1;
            }
        }

        return -1;
    }
}
