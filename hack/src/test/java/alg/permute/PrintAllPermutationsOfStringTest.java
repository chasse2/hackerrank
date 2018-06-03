package alg.permute;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintAllPermutationsOfStringTest {

    final PrintAllPermutationsOfString printer = new PrintAllPermutationsOfString();

    @Test
    public void testPrint() {
        printer.print("abc");
    }

    @Test
    public void testPrintWithDuplicates() {
        printer.print("aabc");
    }
}