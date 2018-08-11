package interview.barclays;

import java.util.*;

public class BestPackageFinder {
    private final List<Thing> things = new ArrayList<>();
    private final int maxWeight;

    private Deque<Thing> combination = new LinkedList<>();
    private Package bestPackage = new Package(Collections.emptyList());

    public BestPackageFinder(final List<Thing> things, final int maxWeight) {
        this.things.addAll(things);
        this.maxWeight = maxWeight;
    }

    public int[] find() {
        this.combine();
//        System.out.println("Best Package : " + this.bestPackage.toString());
        return bestPackage.numbers;
    }

    private void combine() {
        this.combine(0);
    }

    private void combine(final int start) {
        for (int i = start; i < this.things.size(); ++i) {
            combination.push(this.things.get(i));
            final List<Thing> curentThings = new ArrayList<>(combination);
            curentThings.sort(Comparator.comparingInt(x -> x.number));
            final Package currentPackage = new Package(curentThings);
//            System.out.println(currentPackage.toString());

            if (currentPackage.weight <= this.maxWeight) {
                if ((currentPackage.cost > bestPackage.cost) ||
                        currentPackage.cost == bestPackage.cost && currentPackage.weight < bestPackage.weight) {
                    bestPackage = currentPackage;
                }
            }

            if (i < things.size()) {
                combine(i + 1);
            }
            combination.pop();
        }
    }
}
