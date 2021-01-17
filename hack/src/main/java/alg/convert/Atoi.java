package alg.convert;

public class Atoi {

    private final int MAX_VALUE_DIV_10 = Integer.MAX_VALUE / 10;
    private final int MAX_VALUE_MOD_10 = Integer.MAX_VALUE % 10;

    public final int convert(final String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index >= s.length()) {
            return 0;
        }

        char possibleSign = s.charAt(index);
        final int signMultiplier;

        if (possibleSign == '-') {
            signMultiplier = -1;
            index++;
        } else if (possibleSign == '+') {
            signMultiplier = 1;
            index++;
        } else {
            signMultiplier = 1;
        }

        int result = 0;

        while (index < s.length()) {
            char character = s.charAt(index++);

            if (character < '0' || character > '9') {
                break;
            }

            int digit = character - '0';

            if (result > MAX_VALUE_DIV_10
                    || result == MAX_VALUE_DIV_10 && MAX_VALUE_MOD_10 < digit) {
                if (signMultiplier == 1) {
                    return Integer.MAX_VALUE;
                }

                return Integer.MIN_VALUE;
            }

            result = (result * 10) + digit;
        }

        return result * signMultiplier;
    }
}
