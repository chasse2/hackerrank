package interview.pimco;

import org.junit.Test;

import static org.junit.Assert.*;

public class IObjectTestTest {

    @Test
    public final void testObjectPasses() {
        final IObjectTest objectTest = passTest();
        assertTrue(objectTest.test(new Object()));
    }

    @Test
    public final void testObjectFails() {
        final IObjectTest objectTest = failTest();
        assertFalse(objectTest.test(new Object()));
    }

    private IObjectTest passTest() {
        return (x) -> true;
    }

    private IObjectTest failTest() {
        return (x) -> false;
    }
}
