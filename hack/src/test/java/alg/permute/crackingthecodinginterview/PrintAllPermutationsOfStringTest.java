package alg.permute.crackingthecodinginterview;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintAllPermutationsOfStringTest {

    final PrintAllPermutationsOfString printer = new PrintAllPermutationsOfString();

    @Test
    public void testPrint() {
        printer.print("abc");
    }

    @Test
    public void testPrintABCD() {
        printer.print("abcd");
    }


    @Test
    public void testPrintWithDuplicates() {
        printer.print("aabc");
    }
}