package interview.barclays;

import java.util.*;

/**
 * You want to send your friend a package with different things.
 * Each thing you put inside of a package has such parameters as
 *   index number,
 *   weight and
 *   cost.
 * The package has a weight limitation.
 * Your goal is to determine which things to put into the package so that the total weight is
 * less than or equal to the package limit and the total cost is as large as possible.
 * This is a variation of Knapsack problem
 *
 * Input sample:
 * Your program should accept as its first argument a path to a filename.
 * The input file contains several lines. Each line is one test case.
 * Each line contains the weight that a package can take (before the colon)
 * and the list of things you need to pick from.
 * Each thing is enclosed in parentheses where 1st number is a thing's index number,
 * the 2nd is it's weight and the 3rd is it's cost. E.g.
 * 81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)
 * 8 : (1,15.3,$34)
 *
 * Constraints:
 * Max weight any package can take is <= 100.
 * There might be up to 15 things you need to choose from.
 * https://github.com/gavinc88/MiniProjects/blob/master/Package.java
 */

public class BestPackageFinder {
    private final List<Thing> things = new ArrayList<>();
    private final int maxWeight;

    private Deque<Thing> combination = new LinkedList<>();
    private Package bestPackage = new Package(Collections.emptyList());

    public BestPackageFinder(final List<Thing> things, final int maxWeight) {
        this.things.addAll(things);
        this.maxWeight = maxWeight;
    }

    public String find() {
        this.combine();
        return bestPackage.toResultString();
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

            if (currentPackage.weight <= this.maxWeight) {
                if ((currentPackage.cost > bestPackage.cost) ||
                        currentPackage.cost == bestPackage.cost && currentPackage.weight < bestPackage.weight) {
                    bestPackage = currentPackage;
                }
            }

// NOTE: Commented out these two lines since submission to Barclay's
//            if (i < things.size()) {
                combine(i + 1);
//            }
            combination.pop();
        }
    }
}
