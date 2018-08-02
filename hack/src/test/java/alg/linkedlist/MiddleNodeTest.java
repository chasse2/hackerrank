package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class MiddleNodeTest {
    final LinkedListGenerator generator = new LinkedListGenerator();
    final MiddleNode instance = new MiddleNode();

    @Test
    public void middleNodeForLength0() {
        assertNull(instance.middleNode(null));
    }

    @Test
    public void middleNodeForLength1() {
        final ListNode head = generator.generate(1);
        assertEquals(head, instance.middleNode(head));
    }

    @Test
    public void middleNodeForLength2() {
        final ListNode head = generator.generate(2);
        assertEquals(head.next, instance.middleNode(head));
    }

    @Test
    public void middleNodeForLength3() {
        final ListNode head = generator.generate(3);
        assertEquals(head.next, instance.middleNode(head));
    }

    @Test
    public void middleNodeForLength4() {
        final ListNode head = generator.generate(4);
        assertEquals(head.next.next, instance.middleNode(head));
    }

    @Test
    public void middleNodeForLength5() {
        final ListNode head = generator.generate(5);
        assertEquals(head.next.next, instance.middleNode(head));
    }
}