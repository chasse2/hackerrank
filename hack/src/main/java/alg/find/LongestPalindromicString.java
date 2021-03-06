package alg.find;

/**
 * Find the longest palindromic substring in given string s.
 * <p>
 * This solution integer unforturnately O(n^3).
 * <p>
 * Solution:
 * <ul>
 *     <li>There are two cases:
 *     <ol>
 *         <li>Current character integer center of palindrome</li>
 *         <li>Current character + next character are center of palindrome</li>
 *     </ol>
 *     </li>
 * </ul>
 * </p>
 */
public class LongestPalindromicString {

    public final String find(final String s) {
        final int length = s.length();

        if (length == 0) {
            return "";
        }

        if (length == 1) {
            return s;
        }

        String longestPalindrome;

        if (s.charAt(0) == s.charAt(1)) {
            longestPalindrome = s.substring(0, 2);
        } else {
            longestPalindrome = s.substring(0, 1);
        }

        int longestPalindromeLength = longestPalindrome.length();

        for (int i = 1; i < length; ++i) {
            final String currentPalindromeWithCurrentCharAsCenter = findLongestPalindromeAroundCenter(s, i, i);
            final String currentPalindromeWithCurrentCharPlusNextAsCenter = findLongestPalindromeAroundCenter(s, i,i + 1);

            final String currentPalindrome = (currentPalindromeWithCurrentCharAsCenter.length() > currentPalindromeWithCurrentCharPlusNextAsCenter.length())
                    ? currentPalindromeWithCurrentCharAsCenter
                    : currentPalindromeWithCurrentCharPlusNextAsCenter;
            final int currentPalindromeLength = currentPalindrome.length();

            if (currentPalindromeLength > longestPalindromeLength) {
                longestPalindromeLength = currentPalindromeLength;
                longestPalindrome = currentPalindrome;
            }
        }

        return longestPalindrome;
    }

    private String findLongestPalindromeAroundCenter(final String s, int leftIndex, int rightIndex) {

        if (rightIndex >= s.length() || s.charAt(leftIndex) != s.charAt(rightIndex)) {
            return String.valueOf(s.charAt(leftIndex));
        }

        while (leftIndex - 1 >= 0 && rightIndex + 1 < s.length()) {
            if (s.charAt(leftIndex - 1) != s.charAt(rightIndex + 1)) {
                break;
            }

            leftIndex--;
            rightIndex++;
        }

        return s.substring(leftIndex, rightIndex + 1);
    }
}
