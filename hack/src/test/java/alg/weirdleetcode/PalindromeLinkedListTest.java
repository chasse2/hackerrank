package alg.weirdleetcode;

import alg.linkedlist.LinkedListGenerator;
import alg.linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeLinkedListTest {
    final LinkedListGenerator generator = new LinkedListGenerator();
    final PalindromeLinkedList instance = new PalindromeLinkedList();

    @Test
    public void isPalindrome() {
        final ListNode head = generator.generate(new int[]{ 1, 2, 3, 2, 1 });
        assertTrue(instance.isPalindrome(head));
    }

    @Test
    public void isPalindrome2() {
        final ListNode head = generator.generate(new int[]{ 1, 2, 2, 1 });
        assertTrue(instance.isPalindrome(head));
    }

    @Test
    public void isPalindrome3() {
        final ListNode head = generator.generate(new int[]{ 1, 1, 2, 1 });
        assertFalse(instance.isPalindrome(head));
    }
}