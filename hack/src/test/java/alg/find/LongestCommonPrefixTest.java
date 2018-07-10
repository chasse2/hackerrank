package alg.find;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    final LongestCommonPrefix finder = new LongestCommonPrefix();

    @Test
    public void testFind() {
        assertEquals("flo", finder.find(new String[]{ "flower", "flow", "flouride"}));
        assertEquals("", finder.find(new String[]{ "flower", "flow", "flouride", "abc"}));
    }
}