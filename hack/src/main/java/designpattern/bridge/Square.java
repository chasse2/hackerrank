package designpattern.bridge;

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
