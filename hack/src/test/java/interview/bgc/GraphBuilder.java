package interview.bgc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class GraphBuilder {

    private class Connection {
        private static final String DELIMITER = ",";

        final String city1;
        final String city2;

        Connection(final String delimitedLine) {
            final String[] cities = delimitedLine.split(DELIMITER);

            if (cities.length != 2) {
                throw new IllegalArgumentException();
            }

            city1 = cities[0].trim();
            city2 = cities[1].trim();
        }
    }

    final Map<String, Node> build(final String fileName) {
        final Map<String, Node> nodes = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            final int[] lineCount = new int[1];
            lineCount[0] = 0;

            stream.forEach(line -> {
                lineCount[0]++;

                final Connection connection;

                try {
                    connection = new Connection(line);
                } catch (final Exception cause) {
                    throw new IllegalArgumentException("Invalid line in input file : " + lineCount[0]);
                }

                final Node node1 = nodes.computeIfAbsent(connection.city1, x -> new Node(connection.city1));
                final Node node2 = nodes.computeIfAbsent(connection.city2, x -> new Node(connection.city2));

                node1.addConnection(node2);
                node2.addConnection(node1);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nodes;
    }
}
