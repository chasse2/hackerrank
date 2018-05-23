package alg.quicksort;

public class CtciQuickSort {
    public void sort(int[] arr) {
           sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1) {
            sort(arr, left, index - 1);
        }

        if (index < right) {
            sort(arr, index, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                ++left;
            }

            while (arr[right] > pivot) {
                --right;
            }

            if (left <= right) {
                swap(arr, left, right);
                ++left;
                --right;
            }
        }

        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
