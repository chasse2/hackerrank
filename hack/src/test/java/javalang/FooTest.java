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
import static org.junit.Assert.assertNotSame;

public class FooTest {

    public enum Color {
        BLUE(0, 0, 255) {
            int a;
            @Override
            public boolean isPrimary() { return true; }
        },
        PURPLE(128, 0, 128),
        RED(255, 0, 0);

        public final int R;
        public final int G;
        public final int B;

        Color(final int R, final int G, final int B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }

        public boolean isPrimary() {
            return false;
        }
    }

    public static ForkJoinPool pool = new ForkJoinPool(2);

    @Test
    public final void test() {
        List<String> l = new LinkedList<>();
        l.add("B");
        for (String s : l) {
            System.out.println(s);
        }

        Map<String, Integer> m = new HashMap<>();
        m.put("C", 3);

        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
