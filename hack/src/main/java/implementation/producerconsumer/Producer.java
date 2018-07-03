package implementation.producerconsumer;

import java.util.Random;

public class Producer extends Thread {
    private final IntBuffer buffer;

    public Producer(final IntBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        final Random random = new Random();

        while (true) {
            final int value = random.nextInt(1000);
            buffer.add(value);
            System.out.println("Produced " + value);
        }
    }
}
