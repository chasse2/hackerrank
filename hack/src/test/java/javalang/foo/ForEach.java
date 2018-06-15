package javalang.foo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ForEach {

    final List<Integer> values = Arrays.asList( 0, 1, 2, 3, 4 );

    @Test
    public final void testJava8() {
        values.forEach(x -> System.out.println("value : " + x));

        // If no additional string prefix is needed, can do:
        values.forEach(System.out::println);
    }

    @Test
    public final void testJavaLegacy() {
        for (int value : values) {
            System.out.println("value : " + value);
        }
    }
}
