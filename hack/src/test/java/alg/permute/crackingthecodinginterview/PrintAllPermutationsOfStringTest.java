package alg.permute.crackingthecodinginterview;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintAllPermutationsOfStringTest {

    final PrintAllPermutationsOfString printer = new PrintAllPermutationsOfString();

    @Test
    public void testPrintA() {
        printer.print("a");
    }

    @Test
    public void testPrintAA() {
        printer.print("aa");
    }

    @Test
    public void testPrintABC() {
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