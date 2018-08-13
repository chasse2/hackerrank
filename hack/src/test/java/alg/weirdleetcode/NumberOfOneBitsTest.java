package alg.weirdleetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfOneBitsTest {
    final NumberOfOneBits instance = new NumberOfOneBits();

    @Test
    public void hammingWeight() {
        assertEquals(1, instance.hammingWeight(1));
        assertEquals(1, instance.hammingWeight(2));
        assertEquals(2, instance.hammingWeight(3));
        assertEquals(1, instance.hammingWeight(4));
        assertEquals(4, instance.hammingWeight(15));
    }
}