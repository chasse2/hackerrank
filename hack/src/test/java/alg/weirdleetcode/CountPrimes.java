package alg.weirdleetcode;

/**
 * Count the number of primes less than N
 *
 * Algorithm:
 * Note: 2 is the first prime number
 * 1) Start with list of numbers 2 thru N
 * 2) Cross off all numbers divisible by 2
 * 3) Find next number not crossed off
 * 4) Cross off all numbers divible by it
 * 5) Etc ...
 * 6) Count number of numbers not crossed off ...
 * https://leetcode.com/problems/count-primes/description/
 * Beats 94.57% of submitted Java solutions
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        boolean[] isCrossedOff = new boolean[n];

        int prime = 2;
        int squareRoot = (int) Math.sqrt(n);

        while (prime <= squareRoot) {
            for (int i = prime * 2 /* i.e. prime + prime */; i < n;) {
                isCrossedOff[i] = true;
                i += prime;
            }

            while (isCrossedOff[++prime] == true) {
            }
        }

        int count = 0;

        for (int i = 2; i < n; ++i) {
            if (!isCrossedOff[i]) {
                count++;
            }
        }

        return count;
    }
}
