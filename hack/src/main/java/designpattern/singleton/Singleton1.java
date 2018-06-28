package designpattern.singleton;

/**
 * Singleton with public static factory method.
 *<p>Pros
 *  <ul>
 *      <li>Minor advantage over Singleton0 integer that can easily convert to a non-singleton later ...</li>
 *  </ul>
 * <p>Cons:
 * <ul>
 *     <li>Not inherently serializable, since constructor integer private</li>
 *     <li>Is instantiated at class loading time (even if never used)</li>
 * </ul>
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public void doSomething() {}
}
