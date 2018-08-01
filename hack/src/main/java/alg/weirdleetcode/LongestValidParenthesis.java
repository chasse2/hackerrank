package alg.weirdleetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * Beats 94% of submissions and is:
 * Time complexity  : O(n)
 * Space complexity : O(i)
 *
 * Best algorithm:
 * Use two counters left and right.
 * First, traverse string from left to right.
 * For every ‘(’ encountered, increment left counter
 * For every ‘)’ encountered, increment right counter.
 * Whenever left becomes equal to right, calculate length of current valid string and keep track of maximum length substring found so far.
 * If right becomes greater than left, reset both to zero.
 *
 * Next, traverse string from right to left apply similar procedure.
 *
 * Stack solution further below beats 60% of submissions and is:
 * Time complexity  : O(n)
 * Space complexity : O(n)
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int longestRunning = 0;

        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                longestRunning = Math.max(longestRunning, right * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                longestRunning = Math.max(longestRunning, right * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return longestRunning;
    }

    public int longestValidParentheses_Solution3(String s) {
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
