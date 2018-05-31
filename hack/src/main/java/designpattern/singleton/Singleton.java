package designpattern.singleton;

/**
 * Singleton using enum.
 *
 * Functionally equivalent to public field approach, except provides serialization for free.
 */

public enum Singleton {

    INSTANCE;

    public void doSomething() {}
}
