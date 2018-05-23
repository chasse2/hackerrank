package alg.recursion;

import org.junit.Assert;
import org.junit.Test;

public class ThePowerSumTest {
    @Test
    public final void test() {
        final ThePowerSum instance = new ThePowerSum();
        Assert.assertEquals(2, instance.powerSum(25, 2));
    }
}
