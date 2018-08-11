package alg.prime;

/**
 * Print prime numbers <= n
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
