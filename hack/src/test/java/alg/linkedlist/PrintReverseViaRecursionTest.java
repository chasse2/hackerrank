package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintReverseViaRecursionTest {
    private final PrintReverseViaRecursion printer = new PrintReverseViaRecursion();
    private final LinkedListGenerator generator = new LinkedListGenerator();

    @Test
    public final void testPrintReverse() {
        final ListNode list = generator.generate(new int[]{ 1, 2, 3, 4, 5 });

        printer.printReverse(list);
        // Nothing to assert
    }
}