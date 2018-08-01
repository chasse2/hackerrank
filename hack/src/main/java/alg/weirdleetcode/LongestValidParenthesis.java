package alg.weirdleetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int longestRunning = 0;
        final Deque<Integer> stack = new LinkedList<>();

        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            stack.pop();

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                longestRunning = Math.max(longestRunning, i - stack.peek());
            }
        }

        return longestRunning;
    }
}
