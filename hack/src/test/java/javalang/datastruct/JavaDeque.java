package javalang.datastruct;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class JavaDeque {

    @Test
    public final void test() {
        final int[] integers = {5, 3, 5, 2, 3, 2};
        int n = integers.length;
        int m = 3;

        final Deque<Integer> deque = new ArrayDeque<>(m);

                                                                                                                                    long maxNumberOfDistinctItemsInAllSubsets = 0;

        for (int i = 0; i < n; ++i) {
            deque.addLast(i);

            if (i < m - 1) {
                continue;
            }

            long numberOfDistinctItemsInSubset = deque.stream().distinct().count();

            if (numberOfDistinctItemsInSubset > maxNumberOfDistinctItemsInAllSubsets) {
                maxNumberOfDistinctItemsInAllSubsets = numberOfDistinctItemsInSubset;
            }

            deque.removeFirst();
        }

        System.out.println(maxNumberOfDistinctItemsInAllSubsets);
    }
}
