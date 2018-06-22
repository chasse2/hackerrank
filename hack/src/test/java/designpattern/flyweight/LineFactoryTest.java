package designpattern.flyweight;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineFactoryTest {
    @Test
    public void testCreate() {
        final Line greenLine = LineFactory.create("Green");
        final Line blueLine = LineFactory.create("Blue");

        greenLine.draw(1, 2, 3, 4);
        blueLine.draw(5, 6, 7, 8);

        assertSame(greenLine, LineFactory.create("Green"));
        assertSame(blueLine, LineFactory.create("Blue"));
    }
}