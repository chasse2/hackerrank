package interview.barclays;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BestPackageFinderTest {
    @Test
    public void testFind() {
//      final String line = "81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)";
// Ans: 4
//      final String line = "1 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)";
// Ans: -
        final String line = "19 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)";
//Ans: 2,3
        final String[] parts = line.split(" : ");
        final String[] items = parts[1].split(" ");

        final int W = Integer.valueOf(parts[0]) * 100;
        final int n = items.length;

        final List<Thing> things = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final String s = items[i].substring(1, items[i].length() - 1);
            final String[] item = s.split(",");
            final int num = Integer.valueOf(item[0]);
            final int weight = new BigDecimal(item[1]).scaleByPowerOfTen(2).intValue();
            final int cost = Integer.valueOf(item[2].substring(1));
            things.add(new Thing(num, weight, cost));
        }

        final BestPackageFinder bestPackageFinder = new BestPackageFinder(things, W);
        final String result = bestPackageFinder.find();

//        assertEquals("4", result);
//        assertEquals("-", result);
        assertEquals("2,3", result);
    }
}