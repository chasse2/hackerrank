package interview.bgc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class GraphBuilder {

    private class Connection {
        private final String DELIMITER = ",";

        public final String city1;
        public final String city2;

        public Connection(final String delimitedLine) {
            final String[] cities = delimitedLine.split(this.DELIMITER);

            if (cities.length != 2) {
                throw new IllegalArgumentException();
            }

            city1 = cities[0].trim();
            city2 = cities[1].trim();
        }
    }


    public Set<Node> build(final String fileName) {
        final Map<String, Node> nodeMap = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            final int[] lineCount = new int[1];
            lineCount[0] = 0;

            stream.forEach(line -> {
                System.out.println(line);

                lineCount[0]++;

                final Connection connection;

                try {
                    connection = new Connection(line);
                } catch (final Exception cause) {
                    throw new IllegalArgumentException("Invalid line in input file : " + lineCount[0]);
                }

                final Node node1 = nodeMap.computeIfAbsent(connection.city1, x -> new Node(connection.city1));
                final Node node2 = nodeMap.computeIfAbsent(connection.city2, x -> new Node(connection.city2));

                node1.addConnection(node2);
                node2.addConnection(node1);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
