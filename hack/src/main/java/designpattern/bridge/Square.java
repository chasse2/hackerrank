package designpattern.bridge;

/**
 * Implementation of primary interface.
 * Owns instance of secondary hierarchy.
 *
 * IF this were instead extending an abstract class, the base class would own the instance.
 */
public class Square implements Shape {
    private final Color color;

    public Square(final Color color) {
        this.color = color;
    }

    @Override
    public String getType() {
        return "Square";
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
