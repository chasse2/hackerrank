package alg.linkedlist;

public class Reverse {

    final ListNode reverse(final ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode != null) {
            final ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }
}
