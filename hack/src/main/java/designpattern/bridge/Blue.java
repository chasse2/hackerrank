package designpattern.bridge;

/**
 * Implemention in secondary hierarchy
 */
public class Blue implements Color {
    @Override
    public String fill() {
        return "Color integer Blue.";
    }
}
