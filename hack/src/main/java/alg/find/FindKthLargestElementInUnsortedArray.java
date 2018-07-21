package alg.find;

/**
 * Find Kth largest element in unsorted array.
 *
 * Implement in-place quicksort, then index into sorted array.
 *
 * Run-time:
 */
public class FindKthLargestElementInUnsortedArray {

    public final int find(int[] values, int k) {
        quickSortInPlace(values);
        return values[values.length - k];
    }

    public final void quickSortInPlace(final int[] values) {
        quickSortInPlace(values, 0, values.length - 1);
    }

    public final void quickSortInPlace(final int[] values, final int left, final int right) {
        final int pivot = values[(left + right) / 2];

        int i = left;
        int j = right;

        while (i < j) {
            // Find left-most value > pivot
            while (values[i] < pivot) i++;

            // Find right-most value < pivot
            while (values[j] > pivot) j--;

            // If the values are swappable, swap them
            if (i <= j) {
                this.swap(values, i, j);
                i++;
                j--;
            }
        }

        // Apply the algorithms to the partitions we made, if any
        if (left < j) {
            quickSortInPlace(values, left, j);
        }

        if (i < right) {
            quickSortInPlace(values, i, right);
        }
    }

    private void swap(int[] values, int i, int j) {
        final int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
