package alg.calculate;

/**
 * Return largest integer less than or equal to square root of given number.
 * Look for the critical point: i * i <= x && (i+1)(i+1) > x
 * A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.
 */
public class SquareRoot {
    final int calculate(final int x) {
        if (x == 0) {
            return x;
        }

        int low = 1;
        int high = x;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > (x / mid)) {  // (mid * mid) > x
                high = mid;
            } else {
                if ((mid + 1) > (x / (mid + 1))) {  // (mid + 1) * (mid + 1) > x
                    return mid;
                }
                low = mid + 1;
            }
        }

        return low;
    }
}
