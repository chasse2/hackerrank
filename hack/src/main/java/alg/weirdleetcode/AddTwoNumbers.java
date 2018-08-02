package alg.weirdleetcode;

import alg.linkedlist.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Algorithm:
 * The head node will always contain the least-significant digit ...
 * Iterate over each list, keeping track of carry-over.
 * Create result along the way.
 * Note: create initial head with value 0, then return head.next - avoids extra code.
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 * Beats 85.18% of Java submissions
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        int carryOver = 0;

        while (l1 != null || l2 != null) {
            int val = carryOver;

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(val % 10);
            carryOver = val / 10;

            current = current.next;
        }

        if (carryOver > 0) {
            current.next = new ListNode(carryOver % 10);
        }

        return head.next;
    }
}
