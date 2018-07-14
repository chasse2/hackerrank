package alg.reverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringUsingRecursionTest {
    final ReverseStringUsingRecursion reverser = new ReverseStringUsingRecursion();

    @Test
    public void reverse() {
        final char[] s1 = new char[]{};
        reverser.reverse(s1);
        assertArrayEquals(new char[]{}, s1);

        final char[] s2 = new char[]{ 'a' };
        reverser.reverse(s2);
        assertArrayEquals(new char[]{ 'a' }, s2);

        final char[] s3 = new char[]{ 'a', 'b' };
        reverser.reverse(s3);
        assertArrayEquals(new char[]{ 'b', 'a' }, s3);

        final char[] s4 = new char[]{ 'a', 'b', 'c' };
        reverser.reverse(s4);
        assertArrayEquals(new char[]{ 'c', 'b', 'a' }, s4);

    }
}