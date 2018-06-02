package designpattern.bridge;

public interface Shape {

    String getType();
    Color getColor();

    default String draw() {
        return getType() + " drawn. " + getColor().fill();
    };
}
