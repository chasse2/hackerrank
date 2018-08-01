package alg.weirdleetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenthesisTest {

    final LongestValidParenthesis instance = new LongestValidParenthesis();

    @Test
    public void longestValidParentheses() {
        assertEquals(2, instance.longestValidParentheses("(()"));
        assertEquals(4, instance.longestValidParentheses(")()())"));
        assertEquals(2, instance.longestValidParentheses("()(()"));
    }
}