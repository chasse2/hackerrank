package alg.find;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find Kth largest element in given array.
 * Note: Not distinct largest
 */
public class KthLargestElementInArray {
    int find(final int[] values, int k) {
        if (values.length < k) {
            return -1;
        }

        final Comparator<Integer> comparator = (x, y) -> y - x;
        final PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

        for (int i : values) {
            queue.add(i);
        }

        for (int i = 0; i < k - 1; ++i) {
            queue.remove();
        }

        return queue.remove();
    }
}
