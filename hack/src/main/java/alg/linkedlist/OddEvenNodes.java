package alg.linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Algorithm:
 * Put the odd nodes in a linked list and the even nodes in another.
 *
 * Then link the evenList to the tail of the oddList.
 * LeetCode: https://leetcode.com/problems/odd-even-linked-list/description/
 * Beats 100% of submissions.
 */
public class OddEvenNodes {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        ListNode current = head.next;

        boolean isOdd = true;

        if (current == null) {
            return oddHead;
        }

        while (current.next != null) {
            current = current.next;

            if (isOdd) {
                oddTail.next = current;
                oddTail = current;
                isOdd = false;
            } else {
                evenTail.next = current;
                evenTail = current;
                isOdd = true;
            }
        }

        evenTail.next = null;
        oddTail.next = evenHead;

        return oddHead;
    }
}
