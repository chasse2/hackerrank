package interview.morganstanley;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMedianOfLargeUnsortedArrayTest {

    final FindMedianOfLargeUnsortedArray finder = new FindMedianOfLargeUnsortedArray();

    @Test
    public void findMedian() {
        assertEquals(0, finder.findMedian(new int[]{ 0 }), 0.00000001);
        assertEquals(0.5, finder.findMedian(new int[]{ 0, 1 }), 0.00000001);
        assertEquals(1.0, finder.findMedian(new int[]{ 0, 1, 1, 100 }), 0.00000001);
        assertEquals(1.5, finder.findMedian(new int[]{ 0, 1, 1, 2, 2, 100 }), 0.00000001);
        assertEquals(7, finder.findMedian(new int[]{ 0, 4, 7, 99, 100 }), 0.00000001);
    }
}