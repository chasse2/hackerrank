package designpattern.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdapterTest {
    @Test
    public void testGetName() {
        final Expected expected = new Adapter(new Actual());

        assertEquals("Actual", expected.getName());
    }
}