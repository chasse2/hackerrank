package interview.barclays;

import java.util.ArrayList;
import java.util.List;

public class Package {
    final List<Thing> things = new ArrayList<>();
    public final int weight;
    public final int cost;
    public final int[] numbers;

    public Package(final List<Thing> things) {
        this.things.addAll(things);
        this.weight = things.stream().mapToInt(x -> x.weight).sum();
        this.cost = things.stream().mapToInt(x -> x.cost).sum();
        this.numbers = things.stream().mapToInt(x -> x.number).toArray();
    }

    public String toString() {
        if (things.size() == 0) {
            return "-";
        }

        final StringBuilder s = new StringBuilder();
        s.append("weight: " + this.weight);
        s.append(" cost: " + this.cost);
        things.forEach(x -> {
            s.append( " (" + x.number + "," + x.weight + "," + x.cost + ")");
        });
        return s.toString();
    }
}
