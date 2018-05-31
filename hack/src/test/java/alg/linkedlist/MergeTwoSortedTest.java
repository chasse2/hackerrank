package alg.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedTest {

    private final MergeTwoSorted merger = new MergeTwoSorted();
    private final LinkedListGenerator generator = new LinkedListGenerator();
    private final LinkedListToArrayConverter converter = new LinkedListToArrayConverter();

    //todo: test edge cases (passed all on Leet)

    @Test
    public void testMerge() {
        final ListNode list1 = generator.generate(new int[]{ 1, 2, 4 });
        final ListNode list2 = generator.generate(new int[]{ 1, 3, 4 });

        final ListNode mergedList = merger.merge(list1, list2);

        final int[] expected = new int[]{ 1, 1, 2, 3, 4, 4 };

        assertArrayEquals(expected, converter.convert(mergedList));
    }
}