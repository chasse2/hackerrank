package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {

    private final Reverse reverser = new Reverse();
    private final LinkedListGenerator generator = new LinkedListGenerator();
    private final LinkedListToArrayConverter converter = new LinkedListToArrayConverter();

    @Test
    public void testReverseNull() {
        assertNull(reverser.reverse(null));
    }

    @Test
    public void testReverse() {
        final ListNode head = generator.generate(new int[]{ 1, 2, 3, 4, 5});

        final int[] expected = new int[]{ 5, 4, 3, 2, 1 };

        assertArrayEquals(expected, converter.convert(reverser.reverse(head)));
    }
}