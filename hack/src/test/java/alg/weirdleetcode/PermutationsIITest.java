package alg.weirdleetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationsIITest {
    final PermutationsII instance = new PermutationsII();

    @Test
    public void permuteUnique() {
        List<List<Integer>> actual = instance.permuteUnique(new int[]{ 1, 1, 2 });
        actual.forEach(x -> {
            System.out.println(x);
        });
    }
}