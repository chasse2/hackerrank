package alg.calculate;

import java.util.HashMap;
import java.util.Map;

public class FooTest {
    final int calculate(final String s) {
        int answer = 0;
        final Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); ++j) {
            final Character c = s.charAt(j);

            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }

            answer = Math.max(answer, j - i + 1);
            map.put(c, j);
        }

        return answer;
    }
}
