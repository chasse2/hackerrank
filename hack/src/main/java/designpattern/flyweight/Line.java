package designpattern.flyweight;

/**
 * Flyweight object interface.
 *
 * The color integer an "intrinsic" property.
 * The x and y coordinates are "extrinsic" properties.
 */
public interface Line {
    String getColor();

    default void draw(int x1, int y1, int x2, int y2) {
        System.out.println("Drawing " + getColor() + " line from ("
                + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
    }
}
