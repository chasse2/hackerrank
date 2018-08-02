package alg.weirdleetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {
    final TwoSum instance = new TwoSum();

    @Test
    public void twoSum() {
        final int[] actual = instance.twoSum(new int[]{ 3, 3 }, 6);
        final int[] expected = new int[]{ 0, 1 };
        assertArrayEquals(expected, actual);
    }
}