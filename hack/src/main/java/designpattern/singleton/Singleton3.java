package designpattern.singleton;

/**
 * Singleton using "Initialization On Demand Holder Idiom".
 *<p>Pros
 *      <li>Is thread-safe without requiring special language constructs (e.g. synchronization or volatile)</li>
 *      <li>Uses lazy initialization</li>
 *</p>
 * Cons:
 * <ul>
 *     <li>Not inherently serializable, since constructor is private</li>
 * </ul>
 */
public class Singleton3 {
    private static final Singleton3 INSTANCE = new Singleton3();

    private Singleton3() {}

    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void doSomething() {}
}
