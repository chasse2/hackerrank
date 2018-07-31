package alg.permute;


/**
 * This is my variation of the algorithm from "Programming Interviews Exposed".
 *   Replaced usage of String "in" with char[]
 *   Replaced usage of StringBuilder "out" with char[]
 *   Moved state to an inner class, so that outter class need only be instantiated once
 *   for permutations of various strings.
 *
 *   Runtime is O(n-squared * n!) ???. E.g. for character string, 9 * 3! = 9 * 6 = 54
 *
 * If past last position of output string, print and return
 * For each letter in input string:
 * If it is marked as used, skip it
 * Otherwise, place it in the current position, and:
 *    mark as used,
 *    and permute from next position
 *    mark as usused
 */
public class EaePrintAllPermutationsOfStringWithShortCircuitedBaseCase {
    static int permuteCallCount = 0;
    static int baseCaseCount = 0;
    static int forLoopCount = 0;

    public final void permute(final char[] input) {
        new Permuter(input).permute();
        System.out.println("permuteCallCount: " + permuteCallCount);
        System.out.println("baseCaseCount: " + baseCaseCount);
        System.out.println("forLoopCount: " + forLoopCount);
    }

    private class Permuter {
        final char[] input;
        final char[] output;
        final boolean used[];

        int outputIndex = 0;

        Permuter(final char input[]) {
            this.input = input;
            output = new char[input.length];
            used = new boolean[input.length];
        }

        final void permute() {
            permuteCallCount++;

            for (int i = 0; i < input.length; i++) {
                forLoopCount++;

               if (used[i]) {
                   continue;
               }

               output[outputIndex] = input[i];

               used[i] = true;
               outputIndex++;

               if (outputIndex == output.length) {
                   baseCaseCount++;
                   System.out.println(output);
               } else {
                   permute();
               }

               used[i] = false;
               outputIndex--;
            }
        }
    }
}
