package designpattern.singleton;

/**
 * Singleton with public static final field.
 *
 * Cons:
 * <ul>
 *     <li>Not inherently serializable, since constructor is private</li>
 *     <li>Is instantiated at class loading time (even if never used)</li>
 * </ul>
 */
public class Singleton0 {
    public static final Singleton0 INSTANCE = new Singleton0();

    private Singleton0() {}

    public void doSomething() {}
}
