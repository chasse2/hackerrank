package interview.bgc;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GraphBuilderTest {
    final GraphBuilder graphBuilder = new GraphBuilder();

    @Test
    public final void test() {
        final Set<Node> nodes = graphBuilder.build("/tmp/cities.txt");
        System.out.println("testing ...");
        nodes.forEach(System.out::println);
    }
}