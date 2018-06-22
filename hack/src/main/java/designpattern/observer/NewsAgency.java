package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable
 */
public class NewsAgency {
    private List<Channel> channels = new ArrayList<>();

    public void addChannel(final Channel channel) {
        this.channels.add(channel);
    }

    public void removeChannel(final Channel channel) {
        this.channels.remove(channel);
    }

    public void broadcast(final String news) {
        channels.forEach(x -> x.broadcast(news));
    }
}
