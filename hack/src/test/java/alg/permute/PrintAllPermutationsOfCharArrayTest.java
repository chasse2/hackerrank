package alg.permute;

import org.junit.Test;

import static org.junit.Assert.*;

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