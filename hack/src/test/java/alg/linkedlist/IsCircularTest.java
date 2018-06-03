package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsCircularTest {

    final IsCircular detector = new IsCircular();
    private final LinkedListGenerator generator = new LinkedListGenerator();
    private final LinkedListToArrayConverter converter = new LinkedListToArrayConverter();

    @Test
    public void testDetect() {
        assertFalse(detector.detect(null));
    }

    @Test
    public void testIsCircular() {
        final ListNode listNode0 = new ListNode(0);
        final ListNode listNode1 = new ListNode(1);

        listNode0.next = listNode1;
        listNode1.next = listNode0;

        assertTrue(detector.detect(listNode0));
    }

    @Test
    public void testIsNotCircular() {
        assertFalse(detector.detect(generator.generate(new int[]{ 1, 2, 3, 4, 5})));
    }
}