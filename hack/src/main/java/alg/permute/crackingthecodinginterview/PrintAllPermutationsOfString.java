package alg.permute.crackingthecodinginterview;

public class PrintAllPermutationsOfString {

    public void print(final String str) {
        permute(str, "");
    }

    private void permute(final String str, final String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                final String rem = str.substring(0, i) + str.substring(i + 1);
                permute(rem, prefix + str.charAt(i));
            }
        }
    }
}
