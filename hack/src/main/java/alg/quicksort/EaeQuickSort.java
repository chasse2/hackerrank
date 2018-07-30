package alg.quicksort;

public class EaeQuickSort {
    public final void sort(final int[] arr) {
        if (arr.length <= 0) { return; }
        this.sort(arr, 0, arr.length - 1);
    }

    private final void sort(final int[] data, final int left, final int right) {
        final int pivotValue = data[left + (right - left) / 2];

        int i = left;
        int j = right;

        while (i <= j) {
            // Find left-most value greater than or equal to pivot
            while (data[i] < pivotValue) {
                i++;
            }

            // Find right-most value less than or equal to pivot
            while (data[j] > pivotValue) {
                j--;
            }

            // If values are in the wrong order, swap them
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        // Apply the algorithm to the resulting partitions, if any ...

        if (j > left) {
            sort(data, left, j);
        }

        if (right > i) {
            sort(data, i, right);
        }
    }

    private final void swap(final int[] arr, final int i1, final int i2) {
        final int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
