package alg.linkedlist;

public class LinkedListGenerator {

    public ListNode generate(final int length) {
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

    public ListNode generate(final int[] values) {
        if (values.length <= 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode previousNode = head;

        for (int i = 1; i < values.length; ++i) {
            ListNode node = new ListNode(values[i]);
            previousNode.next = node;
            previousNode = node;
        }

        return head;
    }
}
