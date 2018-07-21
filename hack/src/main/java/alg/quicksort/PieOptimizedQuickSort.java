package alg.quicksort;

/**
 * According to "Programming Interviews Exposed":
 * "This is about as good as quicksort can get!
 * The only other optimization that might be worth considering is to replace the recursive call
 * with something like insertion sort after the partition size falls below a certain threshold."
 *
 * Time complexity on average is O(N Log(N))
 * Space complexity is O(log(N)) for in-place version for recursive stack frames
 */
public class PieOptimizedQuickSort {

    public void quicksortOptimized(int[] data) {
        quicksortOptimized(data, 0, data.length - 1);
    }

    private void quicksortOptimized(int[] data, int left, int right) {
        int pivotValue = data[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {

            // Find leftmost value greater than or equal to the pivot
            while (data[i] < pivotValue) {
                ++i;
            }

            // Find rightmost value less than or equal to the pivot
            while (data[j] > pivotValue) {
                --j;
            }

            // If the values are in the wrong order, swap them
            if (i <= j) {
                swap(data, i, j);
                ++i;
                --j;
            }
        }

        // Apply the algorithm to the partitions we made, if any (NOTE: j < i )

        if (left < j) {
            quicksortOptimized(data, left, j);
        }

        if (i < right) {
            quicksortOptimized(data, i, right);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
