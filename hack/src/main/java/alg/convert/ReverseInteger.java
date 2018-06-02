package alg.convert;

/**
 * Assumes environment is 32-bit, and returns 0 on overflow.
 */
public class ReverseInteger {

    public final int reverse(int value) {
        int result = 0;

        final int multiplier;

        if (value < 0) {
            multiplier = -1;
            value *= -1;
        } else {
            multiplier = 1;
        }

        while (value > 0) {
            int digit = value % 10;

            if ((Integer.MAX_VALUE - digit) / 10 < result) {
                return 0;
            }

            result = result * 10 + digit;
            value = (value - digit) / 10;
        }

        return result * multiplier;
    }
}
