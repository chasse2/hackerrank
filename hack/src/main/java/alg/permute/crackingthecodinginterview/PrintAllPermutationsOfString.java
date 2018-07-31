package alg.permute.crackingthecodinginterview;

public class PrintAllPermutationsOfString {

    static int permuteCallCount = 0;
    static int baseCaseCount = 0;
    static int forLoopCount = 0;

    public void print(final String str) {
        permute(str, "");
        System.out.println("permuteCallCount: " + permuteCallCount);
        System.out.println("baseCaseCount: " + baseCaseCount);
        System.out.println("forLoopCount: " + forLoopCount);
    }

    private void permute(final String str, final String prefix) {
        permuteCallCount++;
        if (str.length() == 0) {
            baseCaseCount++;
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                forLoopCount++;
                final String rem = str.substring(0, i) + str.substring(i + 1);
                permute(rem, prefix + str.charAt(i));
            }
        }
    }
}
