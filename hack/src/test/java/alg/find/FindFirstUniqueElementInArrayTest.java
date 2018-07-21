package alg.find;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindFirstUniqueElementInArrayTest {
    final FindFirstUniqueElementInArray finder = new FindFirstUniqueElementInArray();

    @Test
    public void find() {
        assertEquals(7, finder.find(new int[]{ 8, 2, 8, 2, 7, 6, 3, 6, 3 }));
        assertEquals(7, finder.find(new int[]{ 8, 2, 8, 2, 7, 6, 3, 6, 3, 3, 5 }));
    }
}