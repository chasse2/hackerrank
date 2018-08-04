package alg.permute.nayuki;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllPermutationsTest {

    final AllPermutations instance = new AllPermutations();

    @Test
    public void allPermuations() {
        instance.allPermuations("bcda".toCharArray());
    }

    @Test
    public void allPermuationsWithDuplications() {
        instance.allPermuations("aabc".toCharArray());
    }

    @Test
    public void allPermuationsMississippi() {
        instance.allPermuations("Mississippi".toCharArray());
    }
}