package designpattern.bridge;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public final void testBlueSquare() {
        final Shape shape = new Square(new Blue());

        assertEquals("Square drawn. Color is Blue.", shape.draw());
    }
}