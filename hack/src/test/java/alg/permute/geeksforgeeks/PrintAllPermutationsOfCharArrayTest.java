package alg.permute.geeksforgeeks;

import alg.permute.geeksforgeeks.PrintAllPermutationsOfCharArray;
import org.junit.Test;

public class PrintAllPermutationsOfCharArrayTest {

    final PrintAllPermutationsOfCharArray printer = new PrintAllPermutationsOfCharArray();

    @Test
    public void testPrint() {
        printer.print(new String("abc").toCharArray());
    }

    @Test
    public void testPrintWithDuplicates() {
        printer.print(new String("aabc").toCharArray());
    }
}