package alg.calculate;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLongestSubstringTest {

    final LengthOfLongestSubstring calculator = new LengthOfLongestSubstring();

    @Test
    public void testCalculateCase0() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    public void testCalculateCase1() {
        assertEquals(1, calculator.calculate("A"));
    }

    @Test
    public void testCalculateCase2() {
        assertEquals(1, calculator.calculate("AA"));
    }

    @Test
    public void testCalculateCase3() {
        assertEquals(3, calculator.calculate("AABC"));
    }

    @Test
    public void testCalculateCase4() {
        assertEquals(2, calculator.calculate("abba"));
    }
}