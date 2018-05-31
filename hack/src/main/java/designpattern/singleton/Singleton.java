package designpattern.singleton;

/**
 * Singleton using enum (BEST METHOD AS OF RELEASE 1.5).
 *
 * Functionally equivalent to public field approach, except provides serialization for free.
 */

public enum Singleton {

    INSTANCE;

    public void doSomething() {}
}
