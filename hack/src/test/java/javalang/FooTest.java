package javalang;

import javalang.Def;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
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
    public final void test() {
//        assertEquals(0, searchInsert(new int[]{ 0 }, 0));
        assertEquals(4, searchInsert(new int[]{ 1, 2, 5, 6 }, 7));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                if (mid == 0) {
                    return 0;
                }
                if (target > nums[mid - 1]) {
                    return mid;
                }

                high = mid - 1;
            } else {
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                low = mid + 1;
            }
        }

        return -1;
    }
}
