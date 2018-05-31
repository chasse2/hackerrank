package alg.linkedlist;

public class LinkedListLengthCalculator {

    public final int calculateLength(final ListNode head) {
        ListNode currentNode = head;
        int count = 0;

        while (currentNode != null) {
            ++count;
            currentNode = currentNode.next;
        }

        return count;
    }
}
