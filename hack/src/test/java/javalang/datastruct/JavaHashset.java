package javalang.datastruct;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class JavaHashset {

    private final Set<String> items = new HashSet<>();

    @Test
    public final void test() {
        items.add("john tom");
        assertEquals(1, items.size());
        items.add("john mary");
        assertEquals(2, items.size());
        items.add("john tom");
        assertEquals(2, items.size());
        items.add("mary anna");
        assertEquals(3, items.size());
        items.add("mary anna");
        assertEquals(3, items.size());
    }
}
