package alg.linkedlist;

/**
 * Run time is O(n)
 */
public class RemoveNthNodeFromEnd {

     public ListNode remove(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode currentNode = head;
        int lagCount = 0;

        while (lagCount < n && currentNode != null) {
            currentNode = currentNode.next;
            lagCount++;
        }

        if (currentNode == null) {
            if (lagCount < n) {
                return head;
            }

            return head.next;
        }

        ListNode lagNode = head;
        ListNode previousLagNode = null;

        while (currentNode != null) {
            previousLagNode = lagNode;
            lagNode = lagNode.next;
            currentNode = currentNode.next;
        }

        previousLagNode.next = lagNode.next;

        return head;
    }
}
