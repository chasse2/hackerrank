package alg.find;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    final LongestCommonPrefix finder = new LongestCommonPrefix();

    @Test
    public void testFind() {
        assertEquals("a", finder.find(new String[]{ "a", "a"}));
        assertEquals("a", finder.find(new String[]{ "aa", "a"}));
        assertEquals("", finder.find(new String[]{ "", ""}));
        assertEquals("", finder.find(new String[]{ "", "b"}));
        assertEquals("flo", finder.find(new String[]{ "flower", "flow", "flouride"}));
        assertEquals("", finder.find(new String[]{ "flower", "flow", "flouride", "abc"}));
    }
}