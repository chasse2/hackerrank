package designpattern.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SedanTest {
    @Test
    public void testGetModel() {
        final Car car = new Sedan(new FrenchLuxury());

        assertEquals("FrenchLuxury", car.getModel());
    }
}