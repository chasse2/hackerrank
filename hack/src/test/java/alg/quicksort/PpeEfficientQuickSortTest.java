package alg.quicksort;

import org.junit.Test;

import java.util.Arrays;

public class PpeEfficientQuickSortTest {

    @Test
    public final void test() {
        final int[] data1 = new int[]{7, 2, 1, 8, 6, 3, 5, 4};

        new PpeEfficientQuickSort().quicksortSwapping(data1);

        System.out.println(Arrays.toString(data1));
    }
}