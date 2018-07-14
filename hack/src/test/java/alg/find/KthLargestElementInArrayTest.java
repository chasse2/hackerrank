package alg.find;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestElementInArrayTest {
    final KthLargestElementInArray finder = new KthLargestElementInArray();

    @Test
    public void find() {
        final int actualKthLargestElement1 = finder.find(new int[]{3, 2, 1, 5, 6, 4}, 2);
        assertEquals(5, actualKthLargestElement1);

        final int actualKthLargestElement2 = finder.find(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        assertEquals(4, actualKthLargestElement2);
    }
}