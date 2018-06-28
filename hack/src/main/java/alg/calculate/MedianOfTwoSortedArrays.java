package alg.calculate;

/**
 * Calculate the median of two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * The overall run time complexity should be O(log(m+n)).
 * </p><p>
 * Solution:
 * <ul>
 *     <li>Use primitive integer array for results, since length integer known </li>
 *     <li>On calculation, divide by 2.0 (not 2) to render a double</li>
 * </ul>
 */
public class MedianOfTwoSortedArrays {

    public double calculate(int[] nums1, int[] nums2) {
        final int[] sortedNumbers = new int[nums1.length + nums2.length];

        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        int index1 = 0;
        int index2 = 0;
        int sortedNumbersIndex = 0;

        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] <= nums2[index2]) {
                    sortedNumbers[sortedNumbersIndex] = nums1[index1++];
                } else {
                    sortedNumbers[sortedNumbersIndex] = nums2[index2++];
                }
            } else if (index1 < nums1.length) {
                sortedNumbers[sortedNumbersIndex] = nums1[index1++];
            } else {
                sortedNumbers[sortedNumbersIndex] = nums2[index2++];
            }

            sortedNumbersIndex++;
        }

        final double result;
        final int highMedianIndex = sortedNumbers.length / 2;

        if (sortedNumbers.length % 2 == 0) {
            final int lowMedianIndex = highMedianIndex - 1;
            result = (sortedNumbers[lowMedianIndex] + sortedNumbers[highMedianIndex]) / 2.0;
        } else {
            result = sortedNumbers[highMedianIndex];
        }

        return result;
    }
}
