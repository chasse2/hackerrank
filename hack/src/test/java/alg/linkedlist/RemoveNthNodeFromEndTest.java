package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndTest {

    private final RemoveNthNodeFromEnd remover = new RemoveNthNodeFromEnd();

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
        final ListNode head = generateLinkedList(1);
        assertNull(remover.remove(head, 1));
    }

    @Test
    public final void testRemoveTwoAndLengthIsOne() {
        final ListNode head = generateLinkedList(1);
        final ListNode actualNewHead = remover.remove(head, 2);
        assertSame(head, actualNewHead);
        assertEquals(1, calculateLength(actualNewHead));
    }

    @Test
    public final void testHeadRemoveTwoAndLengthIsTwo() {
        final ListNode head = generateLinkedList(2);
        final ListNode expectedNewHead = head.next;
        final ListNode actualNewHead = remover.remove(head, 2);
        assertSame(expectedNewHead, actualNewHead);
        assertEquals(1, calculateLength(actualNewHead));
    }

    @Test
    public final void testHeadRemoveOneAndLengthIsTwo() {
        final ListNode head = generateLinkedList(2);
        final ListNode actualNewHead = remover.remove(head, 1);
        assertSame(head, actualNewHead);
        assertEquals(1, calculateLength(actualNewHead));
    }

    @Test
    public final void testHeadRemoveTwoAndLengthIsThree() {
        final ListNode head = generateLinkedList(3);
        final ListNode actualNewHead = remover.remove(head, 2);
        assertSame(head, actualNewHead);
        assertEquals(2, calculateLength(actualNewHead));
        assertEquals(3, actualNewHead.next.val);
    }

    private ListNode generateLinkedList(final int length) {
        if (length < 1) {
            return null;
        }

        ListNode head = new ListNode(1);
        ListNode previousNode = head;

        for (int i = 1; i < length; ++i) {
            ListNode node = new ListNode(i + 1);
            previousNode.next = node;
            previousNode = previousNode.next;
        }

        return head;
    }

    private final int calculateLength(final ListNode head) {
        ListNode currentNode = head;
        int count = 0;

        while (currentNode != null) {
            ++count;
            currentNode = currentNode.next;
        }

        return count;
    }
}