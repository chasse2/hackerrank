package alg.permute.nayuki;

/**
 * Compute all permutations of given string by repeatly
 * finding next lexicographical permutation.
 *
 * Time Complexity: O(n*n) = O(n-squared)
 * Space Complexity: O(1)
 *
 * Reference: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 *
 * 1) Find longest weakly decreasing (i.e. non-increasing) suffix
 *    If it is the length of the string, we are at the last permutation
 *    This suffix will have a minimum length of 1
 *    Can find in O(n) time scanning from right to left
 * 2) Consider the value to the immediate left of the suffix to be the "pivot" O(1)
 * 3) Find the lowest element in the suffix that is greater than the pivot O(n)
 *    If there are duplicates of this value, use the right-most
 *    Swap the pivot with this value O(1)
 * 4) Sort the suffix into weaking increasing (i.e. non-decreasing) order by reversing it O(n)
 *    Voila! O(3n) = O(n)
 */
public class AllPermutations {
    final public void allPermuations(final char[] s) {
        if (s.length == 0) {
            return;
        }

        int numPermutations = 1;

        for (int i = 1; i <= s.length; i++) {
            numPermutations *= i;
        }

        System.out.println(s);

        for (int i = 1; i < numPermutations; i++) {
            nextPermutation(s);
            System.out.println(s);
        }
    }

    private void nextPermutation(final char[] s) {
        int headOfSuffix = s.length - 1;

        while (headOfSuffix > 0 && s[headOfSuffix - 1] >= s[headOfSuffix]) {
            headOfSuffix--;
        }

        char tmp;

        if (headOfSuffix == 0) {
            reverse(s, 0);          // Last permutation - simply reverse string and return
            return;
        }

        final int pivotIndex = headOfSuffix - 1;

        int suffixValueToSwap = s.length - 1;
        while (s[suffixValueToSwap] <= s[pivotIndex]) {
            suffixValueToSwap--;
        }

        swap(s, pivotIndex, suffixValueToSwap);
        reverse(s, headOfSuffix);
    }

    private void reverse(final char[] s, int i) {
        int j = s.length - 1;

        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(final char[] s, int i, int j) {
        final char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
