package alg.find;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUniqueElementInArray {
    public int find(final int[] values) {
        final Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int value : values) {
            final Integer occurrence = map.get(value);

            if (occurrence == null) {
                map.put(value, 1);
            } else {
                map.put(value, occurrence + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
