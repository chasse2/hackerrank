package alg.weirdleetcode;

import alg.linkedlist.LinkedListGenerator;
import alg.linkedlist.LinkedListPrinter;
import alg.linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {
    final LinkedListGenerator generator = new LinkedListGenerator();
    final LinkedListPrinter printer = new LinkedListPrinter();
    final AddTwoNumbers instance = new AddTwoNumbers();

    @Test
    public void addTwoNumbers() {
        final ListNode l1 = generator.generate(new int[]{ 2, 4, 3 });
        final ListNode l2 = generator.generate(new int[]{ 5, 6, 4 });
        final ListNode actual = instance.addTwoNumbers(l1, l2);
        final ListNode expected = generator.generate(new int[]{ 7, 0, 8 });
        printer.print(expected);
        printer.print(actual);
    }

    @Test
    public void addTwoNumbers2() {
        final ListNode l1 = generator.generate(new int[]{ 9, 9 });
        final ListNode l2 = generator.generate(new int[]{ 1 });
        final ListNode actual = instance.addTwoNumbers(l1, l2);
        final ListNode expected = generator.generate(new int[]{ 0, 0, 1 });
        printer.print(expected);
        printer.print(actual);
    }

    @Test
    public void addTwoNumbers3() {
        final ListNode l1 = generator.generate(new int[]{ 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 });
        final ListNode l2 = generator.generate(new int[]{ 1 });
        final ListNode actual = instance.addTwoNumbers(l1, l2);
        final ListNode expected = generator.generate(new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 });
        printer.print(expected);
        printer.print(actual);
    }
}