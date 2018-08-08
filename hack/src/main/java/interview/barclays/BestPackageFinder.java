package interview.barclays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BestPackageFinder {
    private final List<Thing> things = new ArrayList<>();
    private Deque<Thing> combination = new LinkedList<>();

    public BestPackageFinder(final List<Thing> things) {
        this.things.addAll(things);
    }

    public /*int[]*/ void find() {
        this.combine();
    }

    private void combine() {
        this.combine(0);
    }

    private void combine(final int start) {
        for (int i = start; i < things.size(); ++i) {
            combination.push(things.get(i));
            final Package pkg = new Package(new ArrayList(combination));
            System.out.println(pkg.toString());

            if (i < combination.size()) {
                combine(i + 1);
            }
            combination.pop();
        }
    }
}
