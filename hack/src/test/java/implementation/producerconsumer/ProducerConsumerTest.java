package implementation.producerconsumer;

import org.junit.Test;

public class ProducerConsumerTest {
    @Test
    public final void test() throws InterruptedException {
        final IntBuffer buffer = new IntBuffer();
        final Producer producer = new Producer(buffer);
        final Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        producer.join(100);
        consumer.join(100);
    }
}