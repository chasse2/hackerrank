package alg.permute.geeksforgeeks;

import alg.permute.geeksforgeeks.PrintAllPermutationsOfString;
import org.junit.Test;

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