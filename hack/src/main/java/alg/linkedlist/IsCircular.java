package alg.linkedlist;

public class IsCircular {

    final boolean detect(final ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode hare = head.next;
        ListNode tortoise = head;

        while (hare != null && hare.next != null) {
            if (hare == tortoise) {
                return true;
            }

            tortoise = tortoise.next;

            hare = hare.next.next;
        }

        return false;
    }
}
