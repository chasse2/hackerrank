package alg.permute;

import org.junit.Test;

import static org.junit.Assert.*;

public class EaePermutationsTest {

    final EaePermutations permuter = new EaePermutations();

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
        permuter.permute("abcd".toCharArray());
    }

    @Test
    public void permute5() {
        permuter.permute("aa".toCharArray());
    }
}