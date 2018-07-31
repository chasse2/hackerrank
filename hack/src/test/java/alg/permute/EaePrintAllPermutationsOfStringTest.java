package alg.permute;

import org.junit.Test;

public class EaePrintAllPermutationsOfStringTest {

    final EaePrintAllPermutationsOfString permuter = new EaePrintAllPermutationsOfString();
//    final EaePrintAllPermutationsOfStringWithShortCircuitedBaseCase permuter = new EaePrintAllPermutationsOfStringWithShortCircuitedBaseCase();

    @Test
    public void permute0() {
        permuter.permute("a".toCharArray());
    }

    @Test
    public void permute1() {
        permuter.permute("abc".toCharArray());
    }

    @Test
    public void permute2() {
        permuter.permute("aabc".toCharArray());
    }

    @Test
    public void permute4() {
        permuter.permute("0123455789".toCharArray());
    }

    @Test
    public void permute5() {
        permuter.permute("aa".toCharArray());
    }
}