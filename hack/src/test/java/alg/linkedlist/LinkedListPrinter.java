package alg.linkedlist;

import java.io.PrintStream;

public class LinkedListPrinter {

    final PrintStream stream;

    public LinkedListPrinter() {
        this.stream = System.out;
    }

    public LinkedListPrinter(final PrintStream stream) {
        this.stream = stream;
    }

    public void print(final ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            if (node.next == null) {
                stream.println(node.val);
            }
            else {
                stream.println(node.val + " ");
            }
        }
    }
}
