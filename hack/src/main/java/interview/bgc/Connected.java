package interview.bgc;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Connected {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: Connected <inputfile> <city1> <city2>");
            System.exit(0);
        }

        final String inputFile = args[0];
        final String city1 = args[1];
        final String city2 = args[2];

        try {
            final Map<String, Node> nodes = new GraphBuilder().build(inputFile);
            final boolean connected = new Connected().connected(nodes, city1, city2);
            System.out.println(connected ? "yes" : "no");
        } catch (final Exception cause) {
            System.out.println(cause.getMessage());
        }
    }

    boolean connected(final Map<String, Node> nodes, final String rootCity, final String targetCity) {
        if (!nodes.containsKey(rootCity) || !nodes.containsKey(targetCity)) {
            return false;
        }

        final Node root = nodes.get(rootCity);

        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited();

        while (!queue.isEmpty()) {
            final Node node = queue.poll();

            for (Node connectingNode : node.getConnectedNodes()) {
                if (!connectingNode.visited()) {
                    if (connectingNode.city.equals(targetCity)) {
                        return true;
                    }

                    connectingNode.setVisited();
                    queue.add(connectingNode);
                }
            }
        }

        return false;
    }
}
