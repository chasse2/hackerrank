package interview.pimco;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.fail;

public class FilteringIteratorTest {

    private final Iterator iterator = mock(Iterator.class);
    private final IObjectTest objectTest = mock(IObjectTest.class);

    @Test
    public final void testHasNextIsFalseWhenIteratorHasNextIsFalse() {
        when(iterator.hasNext()).thenReturn(false);

        final FilteringIterator filteringIterator = new FilteringIterator(iterator, objectTest);
        assertFalse(filteringIterator.hasNext());
    }

    @Test
    public final void testHasNextIsFalseWhenObjectTestIsFalseAndThenIteratorHasNextIsFalse() {
        when(iterator.hasNext()).thenReturn(true, false);
        final Object object = new Object();
        when(iterator.next()).thenReturn(object);
        when(objectTest.test(object)).thenReturn(false);

        final FilteringIterator filteringIterator = new FilteringIterator(iterator, objectTest);
        assertFalse(filteringIterator.hasNext());
    }

    @Test
    public final void testHasNextIsTrueWhenObjectTestIsTrue() {
        when(iterator.hasNext()).thenReturn(true);
        final Object object = new Object();
        when(iterator.next()).thenReturn(object);
        when(objectTest.test(object)).thenReturn(true);

        final FilteringIterator filteringIterator = new FilteringIterator(iterator, objectTest);
        assertTrue(filteringIterator.hasNext());
    }

    @Test
    public final void testNext() {
        final FilteringIterator filteringIterator = new FilteringIterator(iterator, objectTest);

        final Object expectedObject = new Object();
        ReflectionTestUtils.setField(filteringIterator, "nextObject", expectedObject);

        assertEquals(expectedObject, filteringIterator.next());
    }

    @Test
    public final void testNextException() {
        final FilteringIterator filteringIterator = new FilteringIterator(iterator, objectTest);

        try {
            filteringIterator.next();
            fail("should have thrown exception");
        } catch (final Exception expectedException) {
            assertEquals(NoSuchElementException.class, expectedException.getClass());
            assertEquals("no more elements", expectedException.getMessage());
        }
    }
}
