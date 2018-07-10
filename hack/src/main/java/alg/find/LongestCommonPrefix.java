package alg.find;

import javax.print.DocFlavor;
import java.util.*;

/**
 * Find the longest common prefix amongst given array of strings.
 *
 * Runtime is O(S), where S is the sum of all characters in all strings.
 */
public class LongestCommonPrefix {
    public final String find(final String[] items) {
        if (items.length == 0) {
            return "";
        }

        String longestPrefix = items[0];

        for (int i = 1; i < items.length; i++) {
            longestPrefix = this.longestPrefix(longestPrefix, items[i]);
        }

        return longestPrefix;
    }

    private final String longestPrefix(final String s1, final String s2) {
        final int shortestStringLength = Math.min(s1.length(), s2.length());
        StringBuffer longestPrefix = new StringBuffer("");

        for (int i =  0; i < shortestStringLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }

            longestPrefix.append(s1.charAt(i));
        }

        return longestPrefix.toString();
    }
}
