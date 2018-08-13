package alg.weirdleetcode;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has.
 *
 * Algorithm:
 * While value > 0, _and_ value with one, then shift right, and repeat ...
 * Increment count whenever result of _and_ is 1
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }

        return count;
    }
}
