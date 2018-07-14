package alg.find;

/**
 * Finds the single non-duplicated element in an unsorted array.
 *
 * Note that all other elements must appear an EVEN NUMBER OF TIMES.
 */
public class FindSoleNonDuplicatedInUnsortedArray {
    final public int find(final int[] values) {
        int result = 0;

        for (int value : values) {
            result ^= value;
        }

        return result;
    }
}
