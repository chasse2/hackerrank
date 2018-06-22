package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight object factory.
 *
 * The unique "intrinsic" properties constitute a flyweight object (i.e. key).
 *
 * The creation of new flyweight objects occurs within a synchronized block.
 * Each flyweight object is immutable.
 */
public class LineFactory {
    private static Map<String, Line> lines = new HashMap<>();

    public static Line create(final String color) {
        if (lines.containsKey(color)) {
            return lines.get(color);
        }

        final Line line;

        synchronized (LineFactory.class) {
            switch (color) {
                case "Blue":
                    line = new BlueLine();
                    break;
                case "Green":
                    line = new GreenLine();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid color: " + color);
            }

            lines.put(color, line);
        }

        return line;
    }
}
