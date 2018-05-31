package designpattern.singleton;

/**
 * Singleton with lazy initialization.
 *
 * Issues:
 * <ul>
 *     <li>Not inherently serializable, since constructor is private</li>
 * </ul>
 */
public class Singleton2 {

    private static Singleton2 INSTANCE = null;

    public static Singleton2 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton2();
                }
            }
        }

        return INSTANCE;
    }

    public void doSomething() {}
}
