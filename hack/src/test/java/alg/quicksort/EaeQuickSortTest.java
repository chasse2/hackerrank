package alg.quicksort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EaeQuickSortTest {
    final EaeQuickSort quickSort = new EaeQuickSort();

    @Test
    public void test0() {
        final int[] arr = new int[]{};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test1() {
        final int[] arr = new int[]{5};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        final int[] arr = new int[]{1, 2, 3};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        final int[] arr = new int[]{3, 2, 1};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        final int[] arr = new int[]{3, 2, 1, 1, 0, 4, 5, 2};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}