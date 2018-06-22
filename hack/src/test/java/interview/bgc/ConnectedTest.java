package interview.bgc;

import org.junit.Test;

import java.util.Map;

public class ConnectedTest {
    @Test
    public final void test() {
        pseudoMain(new String[]{ "/tmp/cities.txt", "Los Angeles", "San Diego"});

    }

    public final void pseudoMain(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: <inputfile> <city1> <city2>");
            System.exit(0);
        }

        final String inputFile = args[0];
        final String city1 = args[1];
        final String city2 = args[2];

        final Map<String, Node> nodes = new GraphBuilder().build(inputFile);
//        System.out.println("testing ...");
//        nodes.forEach((k, v) -> System.out.println(v.toString()));

        final boolean connected = new Connected().connected(nodes, city1, city2);
        System.out.println(connected + " " + city1 + ", " + city2);
    }
}