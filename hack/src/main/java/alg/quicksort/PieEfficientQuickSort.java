package alg.quicksort;

/**
 * In-place quick sort that swaps pivot to end of array
 */
public class PieEfficientQuickSort {

    public void quicksortSwapping(int[] data) {
        quicksortSwapping(data, 0, data.length - 1);
    }

    private void quicksortSwapping(int[] data, int start, int len) {
        if (len < 2 ) {
            return;
        }

        int pivotIndex = start + len / 2;
        int pivotValue = data[pivotIndex];
        int end = start + len;
        int curr = start;

        swap(data, pivotIndex, --end);

        while (curr < end) {
            if (data[curr] < pivotValue) {
                ++curr;
            } else {
                swap(data, curr, --end);
            }
        }

        swap(data, end, start + len - 1);

        int llen = end - start;
        int rlen = len - llen - 1;

        if (llen > 1) {
            quicksortSwapping(data, start, llen);
        }

        if (rlen > 1) {
            quicksortSwapping(data, end + 1, rlen);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
