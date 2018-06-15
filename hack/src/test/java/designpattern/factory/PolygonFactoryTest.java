package designpattern.factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonFactoryTest {

    private final static PolygonFactory factory = new PolygonFactory();

    @Test
    public void createTriangle() {
        assertEquals(Triangle.class.getName(), factory.create(3).getClass().getName());
    }

    @Test
    public void createHexagon() {
        assertEquals(Rectangle.class.getName(), factory.create(4).getClass().getName());
    }

    @Test
    public void createPentagon() {
        assertEquals(Pentagon.class.getName(), factory.create(5).getClass().getName());
    }

    @Test
    public void testException() {
        try {
            factory.create(0);
            fail("should have thrown exception");
        } catch (IllegalArgumentException expectedException) {
            assertEquals("Invalid numberOfSides: 0", expectedException.getMessage());
        }
    }
}