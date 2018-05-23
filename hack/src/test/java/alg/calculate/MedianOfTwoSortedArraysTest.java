package alg.calculate;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {
    final MedianOfTwoSortedArrays calculator = new MedianOfTwoSortedArrays();


    @Test
    public final void testZeroElements() {
        final int[] array1 = new int[]{};
        final int[] array2 = new int[]{};

        assertEquals(0.0, calculator.calculate(array1, array2), 0);
    }


    @Test
    public final void testOneElementInFirstArray() {
        final int[] array1 = new int[]{ 5 };
        final int[] array2 = new int[]{};

        assertEquals(5.0, calculator.calculate(array1, array2), 0);
    }

    @Test
    public final void testOneElementInSecondArray() {
        final int[] array1 = new int[]{};
        final int[] array2 = new int[]{ 5 };

        assertEquals(5.0, calculator.calculate(array1, array2), 0);
    }


    @Test
    public final void testOddNumberOfSortedElements() {
        final int[] array1 = new int[]{ 1, 3 };
        final int[] array2 = new int[]{ 2};

        assertEquals(2.0, calculator.calculate(array1, array2), 0);
    }

    @Test
    public final void testEvenNumberOfSortedElements() {
        final int[] array1 = new int[]{ 1, 4 };
        final int[] array2 = new int[]{ 2, 3 };

        assertEquals(2.5, calculator.calculate(array1, array2), 0);
    }

    @Test
    public final void testDuplicates() {
        final int[] array1 = new int[]{ 1, 2 };
        final int[] array2 = new int[]{ 1, 1 };

        assertEquals(1.0, calculator.calculate(array1, array2), 0);
    }
}