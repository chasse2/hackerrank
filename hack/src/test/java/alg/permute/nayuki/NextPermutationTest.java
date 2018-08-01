package alg.permute.nayuki;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextPermutationTest {
    final NextPermutation instance = new NextPermutation();

    @Test
    public void test() {
        final char[] actual = new char[]{ '0', '1', '2', '5', '3', '3', '0' };
        final char[] expected = new char[]{ '0', '1', '3', '0', '2', '3', '5' };
        instance.nextPermutation(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPermutationIsLast() {
        final char[] actual = new char[]{ '5', '3', '3', '2', '1', '0' };
        final char[] expected = new char[]{ '0', '1', '2', '3', '3', '5' };
        instance.nextPermutation(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test0() {
        final char[] actual = new char[]{ '1', '5', '1' };
        final char[] expected = new char[]{ '5', '1', '1' };
        instance.nextPermutation(actual);
        assertArrayEquals(expected, actual);
    }
}