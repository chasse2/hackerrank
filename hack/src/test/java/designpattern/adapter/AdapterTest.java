package designpattern.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdapterTest {
    @Test
    public void testGetModel() {
        final Expected car = new Adapter(new Actual());

        assertEquals("Actual", car.getName());
    }
}