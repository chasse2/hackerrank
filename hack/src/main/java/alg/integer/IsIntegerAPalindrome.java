package alg.integer;

public class IsIntegerAPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int value = x;
        int reversedValue = 0;

        while (value > 0) {
            final int digit = value % 10;

            reversedValue = reversedValue * 10 + digit;
            value = (value - digit) / 10;
        }

        if (reversedValue == x) {
            return true;
        }

        return false;
    }
}
