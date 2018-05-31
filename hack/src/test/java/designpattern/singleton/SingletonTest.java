package designpattern.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void testSingleton() {
        assertSame(Singleton.INSTANCE, Singleton.INSTANCE);
    }
}