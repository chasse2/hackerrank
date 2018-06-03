package alg.reverse;

import alg.reverse.ReverseInteger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {

    final ReverseInteger reverser = new ReverseInteger();

    @Test
    public void testReverseZero() {
        assertEquals(0,reverser.reverse(0));
    }

    @Test
    public void testReverse123() {
        assertEquals(321, reverser.reverse(123));
    }

    @Test
    public void testReverseNegative123() {
        assertEquals(-321, reverser.reverse(-123));
    }

    @Test
    public void testReverse120() {
        assertEquals(21, reverser.reverse(120));
    }

    @Test
    public void testReverse1534236469() {
        assertEquals(0, reverser.reverse(1534236469));
    }

    /*
    public static final int   MIN_VALUE = 0x80000000;
    public static final int   MAX_VALUE = 0x7fffffff;
    */

    @Test
    public void testReverseMaxInteger() {
        //Ineger.MAX_VALUE: 2147483647
        assertEquals(0, reverser.reverse(Integer.MAX_VALUE));
    }

    @Test
    public void testReverseMinInteger() {
        //Integer.MIN_VALUE): -2147483648
        assertEquals(0,reverser.reverse(0));
    }

    @Test
    public final void ReverseRangeOfIntegers() {
        for (int i = -1000; i < 1000; ++i) {
            final String str = Integer.valueOf(i).toString();
            final String reversedStr = new StringBuilder(str).reverse().toString();
            System.out.println(str + " " + reversedStr);
        }
    }
}