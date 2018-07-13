package designpattern.adapter;

/**
 * Example of an adapter which implements expected interface.
 *
 * Owns instance of underlying third-party.
 */

public class Adapter implements Expected {
    final Actual actual;

    public Adapter(final Actual actual) {
        this.actual = actual;
    }

    @Override
    public String getName() {
        return actual.getIdentifier();
    }
}
