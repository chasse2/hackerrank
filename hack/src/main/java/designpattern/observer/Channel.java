package designpattern.observer;

/**
 * Observer
 */
public interface Channel {
    default void broadcast(final String news) {
        System.out.println(news);
    }
}
