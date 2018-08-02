package alg.weirdleetcode;

import alg.linkedlist.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Could you do it in O(n) time and O(1) space?
 *
 * Algorithm:
 * Reverse 2nd half, then compare the two
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * Beats 97.72% of submissions
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode tortoise = head;
        ListNode hare = head;
        int counter = 0;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            counter++;
        }

        // If hare == null, even # of items in list, and tortoise is at first item of 2nd half
        // Else odd number of items, and tortoise is on middle item
        // In either case, reverse from tortoise to end, then compare the two halves up to counter # of items

        ListNode currentNode = tortoise;
        ListNode previousNode = null;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        ListNode headOfSecondHalf = previousNode;

        for (int i = 0; i < counter; i++) {
            if (head.val != headOfSecondHalf.val) {
                return false;
            }

            head = head.next;
            headOfSecondHalf = headOfSecondHalf.next;
        }

        return true;
    }
}
