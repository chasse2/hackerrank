package designpattern.factory;

public class PolygonFactory {

    public Polygon create(final int numberOfSides) {
        switch (numberOfSides) {
            case 3:
                return new Triangle();
            case 4:
                return new Rectangle();
            case 5:
                return new Pentagon();
        }

        throw new IllegalArgumentException("Invalid numberOfSides: " + numberOfSides);
    }
}
