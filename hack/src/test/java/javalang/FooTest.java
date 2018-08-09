package javalang;

import interview.barclays.BestPackageFinder;
import interview.barclays.Thing;
import javalang.Def;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class FooTest {

    abstract class Library {
        abstract Iterator<Book> books();
    }

    abstract class Book {
        abstract List<String> authors();
        abstract Iterator<Page> iterator();
    }

    abstract class Page {
        public String page;
    }

    @Test
    public final void test2() throws Exception {
//        final String line = "81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)";
//        final String line = "75 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)";
        final String line = "2 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)";
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
        bestPackageFinder.find();
    }

    @Test
    public final void test() throws Exception {
//        final String line = "81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)";
        final String line = "75 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)";
        final String[] parts = line.split(" : ");
        final String[] items = parts[1].split(" ");

        final int W = Integer.valueOf(parts[0]) * 100;
        final int n = items.length;

        final int[] v = new int[n];
        final int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            final String s = items[i].substring(1, items[i].length() - 1);
            final String[] item = s.split(",");
            final int num = Integer.valueOf(item[0]);
            final int weight = new BigDecimal(item[1]).scaleByPowerOfTen(2).intValue();
            final int cost = Integer.valueOf(item[2].substring(1));
            w[i] = weight;
            v[i] = cost;
        }

        int x = 0;
        solve3(v, w, n, W);
    }

    private int[] solve3(final int[] v, final int[] w, final int n, final int W) {
        int[][] m = new int[n + 1][W + 1];

        for (int j = 0; j <= W; ++j) {
            m[0][j] = 0;
        }

        int finalCost = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= W; ++j) {
////              if (w[i] > j) {
                if (w[i-1] > j) {
                    m[i][j] = m[i - 1][j];
                    if (m[i][j] != finalCost) {
                        finalCost  = m[i][j];
                        System.out.println("a " + i + " " + j + " " + finalCost);
                    }
                } else {
////                    m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i]] + v[i]);

                    if (m[i-1][j] >= m[i-1][j-w[i-1]] + v[i-1]) {
                        m[i][j] = m[i-1][j];
                        if (m[i][j] != finalCost) {
                            finalCost = m[i][j];
                            System.out.println("b " + i + " " + j + " " + finalCost);
                        }
                    } else {
                        m[i][j] = m[i-1][j-w[i-1]] + v[i-1];
                        if (m[i][j] != finalCost) {
                            finalCost = m[i][j];
                            System.out.println("c " + i + " " + j + " " + finalCost + " " + v[i-1]);
                        }
                    }
//                    m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i-1]] + v[i-1]);
//                    if (m[i][j] != 0) {
//                        System.out.println("b " + i + " " + j + " " + m[i][j]);
//                    }
                }
            }
        }

        return null;
        /*
        // Input:
// Values (stored in array v)
// Weights (stored in array w)
// Number of distinct items (n)
// Knapsack capacity (W)
// NOTE: The array "v" and array "w" are assumed to store all relevant values starting at index 1.

for j from 0 to W do:
    m[0, j] := 0

for i from 1 to n do:
    for j from 0 to W do:
        if w[i] > j then:
            m[i, j] := m[i-1, j]
        else:
            m[i, j] := max(m[i-1, j], m[i-1, j-w[i]] + v[i])
         */
    }
    private int solve2(final int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    private int solve(final int n) {
        int result = 0;

        for (int i = 0; i < n; ++i) {
            if (i % 5 == 0 || i % 7 == 0) {
                continue;
            }

            result += i;
        }

        return result;
    }
}

