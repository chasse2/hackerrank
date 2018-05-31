package designpattern.singleton;

/**
 * Singleton with public static factory method.
 *
 * Issues:
 * <ul>
 *     <li>Not inherently serializable, since constructor is private</li>
 *     <li>Is instantiated at class loading time (even if never used)</li>
 * </ul>
 *
 * Minor advantage over Singleton0 is that can easily convert to a non-singleton later ...
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public void doSomething() {}
}
