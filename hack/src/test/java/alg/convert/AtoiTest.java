package alg.convert;

import org.junit.Test;

import static org.junit.Assert.*;

public class AtoiTest {

    final Atoi converter = new Atoi();

    @Test
    public final void testEmpty() {
        assertEquals(0, converter.convert(""));
    }


    @Test
    public final void testBlanks() {
        assertEquals(0, converter.convert("  "));
    }

    @Test
    public final void testInvalidChar() {
        assertEquals(0, converter.convert("."));
    }

    @Test
    public final void testZero() {
        assertEquals(0, converter.convert("0"));
    }

    @Test
    public final void testNegativeZero() {
        assertEquals(0, converter.convert("-0"));
    }

    @Test
    public final void testNegativeSign() {
        assertEquals(-123, converter.convert("-123"));
    }

    @Test
    public final void testPositiveSign() {
        assertEquals(123, converter.convert("+123"));
    }

    @Test
    public final void testNoSign() {
        assertEquals(123, converter.convert("123"));
    }

    @Test
    public final void testWithWords() {
        assertEquals(123, converter.convert("123 with words 896"));
    }
/*Integer.MAX_VALUE: 2147483647
Integer.MIN_VALUE: -2147483648
Long.MAX_VALUE: 9223372036854775807
Long.MIN_VALUE: -9223372036854775808

 */

    @Test
    public final void testIntegerMinValueMinus1() {
        assertEquals(-2147483648, converter.convert("-2147483649"));
    }

    @Test
    public final void testIntegerMinValue() {
        assertEquals(-2147483648, converter.convert("-2147483648"));
    }

    @Test
    public final void testIntegerMinValuePlus1() {
        assertEquals(-2147483647, converter.convert("-2147483647"));
    }

    @Test
    public final void testIntegerMaxValueMinus1() {
        assertEquals(2147483646, converter.convert("2147483646"));
    }

    @Test
    public final void testIntegerMaxValue() {
        assertEquals(2147483647, converter.convert("2147483647"));
    }

    @Test
    public final void testIntegerMaxValuePlus1() {
        assertEquals(2147483647, converter.convert("2147483648"));
    }

    @Test
    public final void testLeetCodeTestCase() {
        assertEquals(-2147483648, converter.convert("-6147483648"));
    }
}