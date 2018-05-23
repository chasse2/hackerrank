package alg.find;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicStringTest {

    final LongestPalindromicString finder = new LongestPalindromicString();

    @Test
    public final void testEmptyString() {
        assertEquals("", finder.find(""));
    }

    @Test
    public final void testSingleCharacterString() {
        assertEquals("A", finder.find("A"));
    }

    @Test
    public final void testTwoCharacterString() {
        assertEquals("AA", finder.find("AA"));
    }

    @Test
    public final void testPalindromeAtStart() {
        assertEquals("ABA", finder.find("ABADEF"));
    }

    @Test
    public final void testPalindromAtEnd() {
        assertEquals("EFEFE", finder.find("ABCDEFEFE"));
    }

    @Test
    public final void testPalindromInMiddle() {
        assertEquals("DEFED", finder.find("ABCDEFEDYZ"));
    }

    @Test
    public final void testThatDualSolutionReturnsFirstString() {
        assertEquals("BCB", finder.find("ABCBDEFEG"));
    }
}