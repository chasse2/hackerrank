package interview.bgc;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private final String city;
    private final Set<Node> connectedNodes = new HashSet<>();
    private boolean visited;

    public Node(final String city) {
        this.city = city;
        this.visited = false;
    }

    public void addConnection(final Node node) {
        this.connectedNodes.add(node);
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean visited() {
        return this.visited;
    }
}
