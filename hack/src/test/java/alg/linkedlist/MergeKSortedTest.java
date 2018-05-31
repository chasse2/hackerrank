package alg.linkedlist;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeKSortedTest {
    private final MergeKSorted merger = new MergeKSorted();
    private final LinkedListGenerator generator = new LinkedListGenerator();
    private final LinkedListToArrayConverter converter = new LinkedListToArrayConverter();

    @Test
    public final void testMerge() {
        final ListNode list1 = generator.generate(new int[]{ 1, 4, 5 });
        final ListNode list2 = generator.generate(new int[]{ 1, 3, 4 });
        final ListNode list3 = generator.generate(new int[]{ 2, 6 });

        final ListNode mergedList = merger.merge(new ListNode[]{ list1, list2, list3 });

        final int[] expected = new int[]{ 1, 1, 2, 3, 4, 4, 5, 6 };

        assertArrayEquals(expected, converter.convert(mergedList));
    }
}