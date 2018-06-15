package designpattern.adapter;

/**
 * Third-party implementation
 */
public class FrenchLuxury implements FrenchCar {
    @Override
    public String obtenirLeModele() {
        return "FrenchLuxury";
    }
}
