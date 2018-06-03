package alg.permute;

import java.util.Arrays;

/**
 * Print n! combinations, including duplicates
 */
public class PrintAllPermutationsOfCharArray {

    public final void print(final char[] str) {
        if (str.length == 0) {
            return;
        }

        permute(str, 0, str.length - 1);
    }

    private void permute(char[] str, int left, int right) {
        if (left == right) {
            System.out.println(Arrays.toString(str));
            return;
        }

        for (int i = left; i <= right; ++i) {
            str = swap(str, left, i);
            permute(str, left + 1, right);
            str = swap(str, left, i);               // Backtrack
        }
    }

    private char[] swap(final char[] str, int i, int j) {
        final char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;

        return str;
    }
}
