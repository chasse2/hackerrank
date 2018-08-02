package alg.linkedlist;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * LeetCode: https://leetcode.com/problems/middle-of-the-linked-list/description/
 * Beats 99.91% of submissions.
 */
public class MiddleNode {
     public ListNode middleNode(ListNode head) {
         if (head == null) {
             return null;
         }

         ListNode tortoise = head;
         ListNode hare = head;

         while (hare != null && hare.next != null) {
             tortoise = tortoise.next;
             hare = hare.next.next;
         }

         return tortoise;
    }
}
