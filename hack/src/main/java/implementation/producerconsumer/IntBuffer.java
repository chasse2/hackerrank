package implementation.producerconsumer;

class IntBuffer {
    private int index = -1;
    private int[] buffer = new int[8];

    public synchronized void add(final int value) {
        while (bufferIsFull()) {
            invokeWait();
        }
        addValue(value);
        notifyAll();
    }

    public synchronized int remove() {
        while (bufferIsEmpty()) {
            invokeWait();
        }
        int value = removeValue();
        notifyAll();
        return value;
    }

    private boolean bufferIsFull() {
        return index >= buffer.length - 1;
    }

    private boolean bufferIsEmpty() {
        return index < 0;
    }

    private void addValue(final int value) {
        buffer[++index] = value;
    }

    private int removeValue() {
        return buffer[index--];
    }

    private void invokeWait() {
        try {
            wait();
        } catch (final InterruptedException cause) {
            System.out.println("Spurious interrupt");
        }
    }
}
