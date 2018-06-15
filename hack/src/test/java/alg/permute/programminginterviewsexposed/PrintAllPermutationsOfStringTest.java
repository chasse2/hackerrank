package alg.permute.programminginterviewsexposed;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintAllPermutationsOfStringTest {

    @Test
    public void testPrint() {
        final PrintAllPermutationsOfString printer = new PrintAllPermutationsOfString("abc");
        printer.permute();
    }

    @Test
    public void testPrintWithDuplicates() {
        final PrintAllPermutationsOfString printer = new PrintAllPermutationsOfString("aabc");
        printer.permute();
    }
}