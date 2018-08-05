package alg.weirdleetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {
    final ThreeSum instance = new ThreeSum();

    @Test
    public void threeSum() {
        List<List<Integer>> actual = instance.threeSum(new int[]{-1,0,1,2,-1,-4 });
        actual.forEach(System.out::println);
    }

}