package implementation.producerconsumer;

public class Consumer extends Thread {
    private final IntBuffer buffer;

    public Consumer(final IntBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            final int value = buffer.remove();
            System.out.println("Consumed " + value);
        }
    }
}
