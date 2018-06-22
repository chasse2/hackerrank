package designpattern.observer;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsAgencyTest {

    @Test
    public void test() {
        final Channel channel1 = new Channel() {
            @Override
            public void broadcast(String news) {
                System.out.println("Channel 1 Breaking News: " + news);
            }
        };

        final Channel channel2 = new Channel() {
            @Override
            public void broadcast(String news) {
                System.out.println("Channel 2 Breaking News: " + news);
            }
        };

        final NewsAgency newsAgency = new NewsAgency();
        newsAgency.addChannel(channel1);
        newsAgency.addChannel(channel2);

        newsAgency.broadcast("Surf's Up!");
    }
}