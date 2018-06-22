package interview.bgc;

import org.junit.Test;

import java.util.Map;

public class ConnectedTest {
    @Test
    public final void test() {
        pseudoMain(new String[]{ "/tmp/cities2.txt", "New York", "New York"});

    }

    public final void pseudoMain(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: <inputfile> <city1> <city2>");
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
}