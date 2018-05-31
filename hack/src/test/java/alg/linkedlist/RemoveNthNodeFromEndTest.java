package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndTest {

    private final RemoveNthNodeFromEnd remover = new RemoveNthNodeFromEnd();
    private final LinkedListGenerator generator = new LinkedListGenerator();
    private final LinkedListLengthCalculator lengthCalculator = new LinkedListLengthCalculator();

    @Test
    public final void testRemoveZeroAndLengthIsZero() {
        final ListNode head = null;
        assertNull(remover.remove(head, 0));
    }

    @Test
    public final void testRemoveOneAndLengthIsZero() {
        final ListNode head = null;
        assertNull(remover.remove(head, 1));
    }

    @Test
    public final void testRemoveOneAndLengthIsOne() {
        final ListNode head = generator.generate(1);
        assertNull(remover.remove(head, 1));
    }

    @Test
    public final void testRemoveTwoAndLengthIsOne() {
        final ListNode head = generator.generate(1);
        final ListNode actualNewHead = remover.remove(head, 2);
        assertSame(head, actualNewHead);
        assertEquals(1, lengthCalculator.calculateLength(actualNewHead));
    }

    @Test
    public final void testHeadRemoveTwoAndLengthIsTwo() {
        final ListNode head = generator.generate(2);
        final ListNode expectedNewHead = head.next;
        final ListNode actualNewHead = remover.remove(head, 2);
        assertSame(expectedNewHead, actualNewHead);
        assertEquals(1, lengthCalculator.calculateLength(actualNewHead));
    }

    @Test
    public final void testHeadRemoveOneAndLengthIsTwo() {
        final ListNode head = generator.generate(2);
        final ListNode actualNewHead = remover.remove(head, 1);
        assertSame(head, actualNewHead);
        assertEquals(1, lengthCalculator.calculateLength(actualNewHead));
    }

    @Test
    public final void testHeadRemoveTwoAndLengthIsThree() {
        final ListNode head = generator.generate(3);
        final ListNode actualNewHead = remover.remove(head, 2);
        assertSame(head, actualNewHead);
        assertEquals(2, lengthCalculator.calculateLength(actualNewHead));
        assertEquals(3, actualNewHead.next.val);
    }
}