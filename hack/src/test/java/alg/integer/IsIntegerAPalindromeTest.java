package alg.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsIntegerAPalindromeTest {

    final IsIntegerAPalindrome determinator = new IsIntegerAPalindrome();

    @Test
    public void testIsPalindrome() {
        assertTrue(determinator.isPalindrome(1));
        assertTrue(determinator.isPalindrome(121));
        assertTrue(determinator.isPalindrome(1221));
        assertFalse(determinator.isPalindrome(12));
    }
}