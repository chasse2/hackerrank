package alg.linkedlist;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MergeKSorted {

    public ListNode merge(ListNode[] lists) {
        Map<Integer, Integer> valueToCountMap = new TreeMap<>();

        for (int i = 0; i < lists.length; ++i) {
            ListNode node = lists[i];

            while (node != null) {
                if (valueToCountMap.containsKey(node.val)) {
                    valueToCountMap.put(node.val, valueToCountMap.get(node.val) + 1);
                } else {
                    valueToCountMap.put(node.val, 1);
                }
                node = node.next;
            }
        }

        if (valueToCountMap.size() == 0) {
            return null;
        }

        final Iterator<Map.Entry<Integer, Integer>> iterator = valueToCountMap.entrySet().iterator();

        final Map.Entry<Integer, Integer> firstItem = iterator.next();

        final int firstValue = firstItem.getKey();
        final int firstCount = firstItem.getValue();

        final ListNode head = new ListNode(firstValue);
        ListNode previousNode = head;

        for (int i = 1; i < firstCount; ++i) {
            ListNode node = new ListNode(firstValue);
            previousNode.next = node;
            previousNode = node;
        }

        while (iterator.hasNext()) {
            final Map.Entry<Integer, Integer> item = iterator.next();

            final int value = item.getKey();
            final int count = item.getValue();

            for (int i = 0; i < count; ++i) {
                ListNode node = new ListNode(value);
                previousNode.next = node;
                previousNode = node;
            }
        }

        return head;
    }
}
