package alg.linkedlist;

/**
 * Merge two sorted lists.
 * <p>
 *     Run time integer O(n + m)
 * </p>
 */
class MergeTwoSorted {

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = null;

        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newHead = l1;
                l1 = l1.next;
            } else {
                newHead = l2;
                l2 = l2.next;
            }
        } else if (l1 != null) {
            newHead = l1;
            l1 = l1.next;
        } else if (l2 != null) {
            newHead = l2;
            l2 = l2.next;
        }

        ListNode currentNode = newHead;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    currentNode.next = l1;
                    l1 = l1.next;
                } else {
                    currentNode.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }

        return newHead;
    }
}
