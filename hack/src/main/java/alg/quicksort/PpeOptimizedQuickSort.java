package alg.quicksort;

public class PpeOptimizedQuickSort {

    public void quicksortOptimized(int[] data) {
        quicksortOptimized(data, 0, data.length - 1);
    }

    private void quicksortOptimized(int[] data, int left, int right) {
        int pivotValue = data[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {

            // Find leftmost value great than or equal to the pivot
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

        // Apply the algorithm to the partitions we made, if any

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
