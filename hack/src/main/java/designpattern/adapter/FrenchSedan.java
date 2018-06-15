package designpattern.adapter;

/**
 * Example of an adapter.
 *
 * Owns instance of underlying.
 */
public class FrenchSedan implements FrenchCar {
    final Car car;

    public FrenchSedan(final Car car) {
        this.car = car;
    }

    @Override
    public String obtenirLeModele() {
        return car.getModel();
    }
}
