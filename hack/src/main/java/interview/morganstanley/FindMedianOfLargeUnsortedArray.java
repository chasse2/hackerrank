package interview.morganstanley;

/**
 * Find median of an unsorted array of integers about which the following is known:
 * 1) The array may be huge, e.g. a million values
 * 2) Values range from 0 to 100
 *
 * Do so without allocating another _large_ array or sorting (e.g. in-place quicksort)
 *
 * Time complexity is O(n)
 * Preferred in-place quicksort solution would have been O(nlog(n))
 */

public class FindMedianOfLargeUnsortedArray {
    public final double findMedian(final int[] values) {
        if (values.length == 0) {
            return -1;

        }
        if (values.length == 1) {
            return values[0];
        }

        final int[] bucketCount = new int[101];

        for (int value : values) {
            bucketCount[value] += 1;
        }

        final int medianOrHighMedianIndex = values.length / 2;

        int currentValue = -1;
        int previousValue = -1;
        int nominalIndex = -1;
        final double median;

        for (int bucketIndex = 0; bucketIndex < bucketCount.length; bucketIndex++) {
            int currentBucketCount = bucketCount[bucketIndex];
            for (int i = 1; i <= currentBucketCount; i++) {
                nominalIndex += 1;
                previousValue = currentValue;
                currentValue = bucketIndex;

                if (nominalIndex == medianOrHighMedianIndex) {
                    // Compute median
                    if (values.length % 2 == 0) {
                        median = (currentValue + previousValue) / 2.0;
                    } else {
                        median = currentValue;
                    }

                    return median;
                }
            }
        }

        return -1;
    }
}
