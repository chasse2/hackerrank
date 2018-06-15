package designpattern.adapter;

/**
 * Example of an adapter which implements expected interface.
 *
 * Owns instance of underlying third-party.
 */

public class Sedan implements Car {
    final FrenchCar car;

    public Sedan(final FrenchCar car) {
        this.car = car;
    }

    @Override
    public String getModel() {
        return car.obtenirLeModele();
    }
}
