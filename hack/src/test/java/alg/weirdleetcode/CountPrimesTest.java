package alg.weirdleetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesTest {

    final CountPrimes instance = new CountPrimes();

    @Test
    public void countPrimes() {
        assertEquals(0, instance.countPrimes(1));
        assertEquals(0, instance.countPrimes(2));
        assertEquals(1, instance.countPrimes(3));
        assertEquals(2, instance.countPrimes(4));
        assertEquals(2, instance.countPrimes(5));
        assertEquals(3, instance.countPrimes(6));
    }
}