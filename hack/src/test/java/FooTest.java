import javafx.collections.transformation.SortedList;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class FooTest {
    @Test
    public final void test() {
        final Set<String> items = new HashSet<>();
        items.add("a");
        items.add("b");
        System.out.println(String.join(",", items));
    }

    private static class Node {
        private static int EDGE_WEIGHT = 6;

        private int id;
        private int edgeDistance = -1;
        private Set<Node> neighbors = new HashSet<>();

        public Node(final int id) {
            this.id = id;
        }

        public void setEdgeDistance(final int edgeDistance) {
            this.edgeDistance = edgeDistance;
        }

        public void addNeighbor(final Node node) {
            this.neighbors.add(node);
        }

        public int getId() {
            return this.id;
        }

        public int getEdgeDistance() {
            return this.edgeDistance;
        }

        public int getWeightedEdgeDistance() {
            if (this.edgeDistance <= 0) {
                return -1;
            }

            return this.edgeDistance * EDGE_WEIGHT;
        }

        public Set<Node> getNeighbors() {
            final Set<Node> copyOfNeighbors = new HashSet<>();
            copyOfNeighbors.addAll(this.neighbors);
            return copyOfNeighbors;
        }

        public boolean visited() {
            if (this.edgeDistance < 0) {
                return false;
            }

            return true;
        }

        public String toString() {
            final StringBuffer s = new StringBuffer();
            for (Node neighbor : this.neighbors) {
                s.append(neighbor.getId());
                s.append(" ");
            }
            return "id " + this.getId() + ", edgeDistance " + this.getWeightedEdgeDistance() + ", neighbors " + s;
        }
    }

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        // n is number of nodes
        // m is number of edges
        // edges is numEdges x 2 (where each is x, y)
        // s is index of root node (1 to n)
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1);
        }

        // Build graph
        for (int edgeIndex = 0; edgeIndex < m; edgeIndex++) {
            final int x = edges[edgeIndex][0];
            final int y = edges[edgeIndex][1];
            nodes[x - 1].addNeighbor(nodes[y - 1]);
            nodes[y - 1].addNeighbor(nodes[x - 1]);
            System.out.println("edge " + edgeIndex + " values " + x + " " + y);
        }

        // Compute distances from "root"

        final Queue<Node> queue = new LinkedList<>();
        final Node root = nodes[s - 1];
        root.setEdgeDistance(0);
        queue.add(root); // todo change to enqueue

//        int edgeDistance = 0;
        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            final int edgeDistance = node.getEdgeDistance();

            for (Node neighbor : node.getNeighbors()) {
                if (!neighbor.visited()) {
                    neighbor.setEdgeDistance(edgeDistance + 1);
                    queue.add(neighbor);
                }
            }
        }

        // Print graph
        for (int i = 0; i < n; i++) {
            System.out.println(i + " : " + nodes[i].toString());
        }
        System.out.println("\n");

        int[] results = new int[n - 1];

        int resultIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i == s - 1) {
                continue;
            }
            results[resultIndex++] = nodes[i].getWeightedEdgeDistance();
        }

        return results;
    }

    @Test
    public final void testBFS() throws Exception {
        final Scanner scanner = new Scanner(new File("/tmp/u.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/tmp/u.out"));//System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
