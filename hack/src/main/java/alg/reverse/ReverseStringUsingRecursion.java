package alg.reverse;

public class ReverseStringUsingRecursion {
    final void reverse(final char[] s) {
        this.reverse(s, 0, s.length - 1);
    }

    private void reverse(final char[] s, int i, int j) {
        if (i >= j) {
            return;
        }

        final char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
