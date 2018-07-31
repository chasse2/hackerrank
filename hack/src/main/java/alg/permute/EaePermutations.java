package alg.permute;

import java.util.Arrays;

public class EaePermutations {
    public final void permute(final char[] input) {
        new Permuter(input).permute();
        Permuter p = new Permuter(input);
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
           // If past last position of output string, print and return
           if (outputIndex == output.length) {
               System.out.println(output);
               return;
           }

           // For each letter in input string:
           // If it is marked as used, skip it
           // Otherwise, place it in the current position, and:
           //    mark as used,
           //    and permute from next position
           //    mark as usused

            for (int i = 0; i < input.length; i++) {
               if (used[i]) {
                   continue;
               }

               output[outputIndex] = input[i];

               used[i] = true;
               outputIndex++;

               permute();

               used[i] = false;
               outputIndex--;
            }
        }
    }
}
