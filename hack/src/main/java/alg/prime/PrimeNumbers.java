package alg.prime;

/**
 * Print prime numbers <= n
 *
 * Algorithm:
 * Note: 2 is the first prime number
 * 1) Start with list of numbers 2 thru N
 * 2) Cross off all numbers divisible by 2 (excluding 2)
 * 3) Find next number not crossed off
 * 4) Cross off all numbers divible by it (excluding it)
 * 5) Etc ...
 * 6) Print numbers not crossed off ..
 */
public class PrimeNumbers {
    public final void printPrime(final int n) {
        if (n < 2) {
            return;
        }

        final boolean[] isCrossedOff = new boolean[n + 1];

        int prime = 2;
        int squareRoot = (int) Math.sqrt(n);

        while (prime <= squareRoot) {
            for (int i = prime * 2 /* i.e. prime + prime */; i <= n;) {
                isCrossedOff[i] = true;
                i += prime;
            }

            while (isCrossedOff[++prime]) {}
        }

        for (int i = 2; i <= n; ++i) {
            if (!isCrossedOff[i]) {
                System.out.println(i);
            }
        }
    }
}
