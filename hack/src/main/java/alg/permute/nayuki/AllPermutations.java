package alg.permute.nayuki;

import java.util.*;

/**
 * Compute all permutations of given string by repeatly
 * finding next lexicographical permutation.
 *
 * May optionally include duplicates (occur if characters repeat in input sequence).
 * Default is unique permutations only.
 *
 * Time Complexity: O(n*n) = O(n-squared)
 * Space Complexity: O(1)
 *
 * Reference: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 *
 * Algorithm (Nayuki) is to successively call nextPermutation for known # of permutations times.
 * Number of permutations for a string with no duplicate chars is n!
 * Number of ALL permutations for a string with duplicate chars is n!
 * Number of UNIQUE permuations for a duplicate chars is (n! / x!), where x is:
 * E.g. for mississippi, which has 4 of i, 4 of s, and 2 of p, denominator x is 4!4!2!
 * There are thus 11!/ (4!4!2!) unique permutations
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
 *
 */
public class AllPermutations {
    final boolean uniqueOnly;

    public AllPermutations() {
        uniqueOnly = true;
    }

    public AllPermutations(boolean uniqueOnly) {
        this.uniqueOnly = uniqueOnly;
    }

    final public void allPermuations(final char[] s) {
        if (s.length == 0) {
            return;
        }

        final int numPermutations;

        if (uniqueOnly) {
            numPermutations = this.numberOfUniquePermutations(s);
        } else {
            numPermutations = this.numberOfPermutationsIncludingDuplicates(s);
        }

        System.out.println(new StringBuilder().append(0).append( " ").append(s));

        for (int i = 1; i < numPermutations; i++) {
            nextPermutation(s);
            System.out.println(new StringBuilder().append(i).append( " ").append(s));
        }
    }


    private int numberOfPermutationsIncludingDuplicates(final char[] s) {
        int numPermutations = 1;

        for (int i = 1; i <= s.length; i++) {
            numPermutations *= i;
        }

        return numPermutations;
    }

    private int numberOfUniquePermutations(final char[] s) {
        final Map<Character, Integer> characterCounts = new HashMap<>();
        for (char c : s) {
            if (characterCounts.containsKey(c)) {
                int count = characterCounts.get(c);
                characterCounts.put(c, ++count);
            } else {
                characterCounts.put(c, 1);
            }
        }

        int numerator = numberOfPermutationsIncludingDuplicates(s);
        int denominator = 1;

        for (Integer v : characterCounts.values()) {
            denominator *= factorial(v);
        }

        return numerator / denominator;
    }

    private void nextPermutation(final char[] s) {
        int headOfSuffix = s.length - 1;

        while (headOfSuffix > 0 && s[headOfSuffix - 1] >= s[headOfSuffix]) {
            headOfSuffix--;
        }

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

    private int factorial(final int v) {
        int result = 1;
        for (int i = v; i > 1; i--) {
            result *= i;
        }

        return result;
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
