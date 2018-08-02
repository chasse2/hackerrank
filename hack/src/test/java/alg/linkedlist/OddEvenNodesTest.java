package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenNodesTest {
    final LinkedListGenerator generator = new LinkedListGenerator();
    final LinkedListPrinter printer = new LinkedListPrinter();
    final OddEvenNodes instance = new OddEvenNodes();

    @Test
    public void testLength1() {
        final ListNode head = generator.generate(1);
        printer.print(instance.oddEvenList(head));
    }

    @Test
    public void testLength2() {
        final ListNode head = generator.generate(2);
        printer.print(instance.oddEvenList(head));
    }

    @Test
    public void testLength3() {
        final ListNode head = generator.generate(3);
        printer.print(instance.oddEvenList(head));
    }

    @Test
    public void testLength4() {
        final ListNode head = generator.generate(4);
        printer.print(instance.oddEvenList(head));
    }

    @Test
    public void testLength5() {
        final ListNode head = generator.generate(5);
        printer.print(instance.oddEvenList(head));
    }
}