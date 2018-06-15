package javalang.foo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionalInterface {

    @java.lang.FunctionalInterface
    private interface Foo {
        void doSomething();
    }

    @java.lang.FunctionalInterface
    private interface Bar {
        void doSomething(int i);
    }

    @java.lang.FunctionalInterface
    private interface Baz {
        int doSomething(int i, int j);
    }

    @Test
    public final void testFoo() {
        final Foo foo = () -> System.out.println("hello");
        foo.doSomething();
    }

    @Test
    public final void testBar() {
        final Bar bar = x -> System.out.println("arg : " + x);
        bar.doSomething(8);
    }

    @Test
    public final void testBaz() {
        final Baz baz = (x, y) -> {
            System.out.println("args " + x + ", " + y);
            return x + y;
        };

        int result = baz.doSomething(3, 5);
        assertEquals(8, result);
    }
}
