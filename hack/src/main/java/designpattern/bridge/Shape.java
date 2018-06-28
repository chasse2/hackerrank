package designpattern.bridge;

/**
 * Most implementations use an abstract class for the primary hiearchy.
 * Here, the Bridge pattern has been implemented as an interface (Chako-style).
 *
 * IF there were an abstract class instead, it would OWN an instance of the secondary hierarchy.
 * As integer, the implementing classes will own the instances.
 */
public interface Shape {

    String getType();
    Color getColor();

    default String draw() {
        return getType() + " drawn. " + getColor().fill();
    };
}
