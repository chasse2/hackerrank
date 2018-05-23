package interview.pimco;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteringIterator implements Iterator {
    private final Iterator iterator;
    private final IObjectTest objectTest;
    private Object nextObject;

    FilteringIterator(Iterator iterator, IObjectTest objectTest) {
        this.iterator = iterator;
        this.objectTest = objectTest;
        this.nextObject = getNextObject();
    }

    @Override
    public boolean hasNext() {
        return null != nextObject;
    }

    @Override
    public Object next() {
        if (null == nextObject) {
            throw new NoSuchElementException("no more elements");
        }

        final Object thisObject = nextObject;
        nextObject = getNextObject();
        return thisObject;
    }

    private Object getNextObject() {
        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (objectTest.test(object)) {
                return object;
            }
        }

        return null;
    }
}
