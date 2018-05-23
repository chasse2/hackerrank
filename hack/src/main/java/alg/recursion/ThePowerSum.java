package alg.recursion;

public class ThePowerSum {
    public int powerSum(int X, int N) {
        return calculatePowerSum(X, N, 1);
    }

    private int calculatePowerSum(int x, int n, int value) {
        int valueToPowerOfN = (int) Math.pow(value, n);

        if (valueToPowerOfN > x) {
            return 0;
        }

        if (valueToPowerOfN == x) {
            return 1;
        }

        return calculatePowerSum(x, n, value + 1) + calculatePowerSum(x - valueToPowerOfN, n, value + 1);
    }
}
