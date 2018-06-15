package alg.permute.geeksforgeeks;

/**
 * Print n! combinations, including duplicates
 */
public class PrintAllPermutationsOfString {

    public final void print(final String str) {
        if (str.isEmpty()) {
            return;
        }

        permute(str, 0, str.length() - 1);
    }

    private void permute(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
            return;
        }

        for (int i = left; i <= right; ++i) {
            str = swap(str, left, i);
            permute(str, left + 1, right);
            str = swap(str, left, i);               // Backtrack
        }
    }

    private String swap(final String str, int i, int j) {
        final char[] array = str.toCharArray();

        final char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        return String.valueOf(array);
    }
}
