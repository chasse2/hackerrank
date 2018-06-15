package designpattern.bridge;

/**
 * Most implementations use an abstract class for the primary hiearchy.
 * Here, the Bridge pattern has been implemented as an interface (Chako-style)
 */
public interface Shape {

    String getType();
    Color getColor();

    default String draw() {
        return getType() + " drawn. " + getColor().fill();
    };
}
