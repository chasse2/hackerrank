package alg.weirdleetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLongestSubstringTest {
    final LengthOfLongestSubstring instance = new LengthOfLongestSubstring();

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(0, instance.lengthOfLongestSubstring(""));
        assertEquals(1, instance.lengthOfLongestSubstring("a"));
        assertEquals(1, instance.lengthOfLongestSubstring("aa"));
        assertEquals(2, instance.lengthOfLongestSubstring("ab"));
        assertEquals(3, instance.lengthOfLongestSubstring("abca"));
        assertEquals(4, instance.lengthOfLongestSubstring("aabcd"));
        assertEquals(4, instance.lengthOfLongestSubstring("abcdd"));
    }
}