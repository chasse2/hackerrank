package alg.linkedlist;

public class LinkedListToArrayConverter {

    private final LinkedListLengthCalculator lengthCalculator = new LinkedListLengthCalculator();

    final int[] convert(final ListNode head) {
        int[] values = new int[lengthCalculator.calculateLength(head)];

        if (head == null) {
            return values;
        }

        int index = 0;

        for (ListNode node = head; node != null; node = node.next) {
            values[index++] = node.val;
        }

        return values;
    }
}
