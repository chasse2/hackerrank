package interview.bgc;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Node {
    final String city;
    private boolean visited;
    private final Set<Node> connectedNodes = new HashSet<>();

    Node(final String city) {
        this.city = city;
        this.visited = false;
    }

    void addConnection(final Node node) {
        this.connectedNodes.add(node);
    }

    final Set<Node> getConnectedNodes() {
        return new HashSet<>(this.connectedNodes);
    }

    void setVisited() {
        this.visited = true;
    }

    boolean visited() {
        return this.visited;
    }

    public String toString() {
        return this.city + " : " + connectedNodes.stream().map(x -> x.city).collect(Collectors.joining(","));
    }
}
