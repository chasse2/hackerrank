package alg.find;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindKthLargestElementInUnsortedArrayTest {

    final FindKthLargestElementInUnsortedArray finder = new FindKthLargestElementInUnsortedArray();

    @Test
    public void find() {
//        assertEquals(finder.find(new int[]{3,2,1,5,6,4}, 2), 5);
        assertEquals(finder.find(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6},
        2), 10);
    }
}