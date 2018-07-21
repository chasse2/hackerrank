package alg.linkedlist;

import java.util.*;

/**
 * Merge K sorted lists.
 * <p>
 * This method iterates over each list and creates a map of values to counts.
 * It then creates the final list.
 * </p>
 * <p>
 * The deprecated method below it uses a PriorityQueue. Leet reported this as too slow
 * </p>
 *
 */
//todo This is a Leet problem. Not very efficient - need to revisit
class MergeKSorted {

    ListNode merge(ListNode[] lists) {
        Map<Integer, Integer> valueToCountMap = new TreeMap<>();

        for (ListNode node : lists) {
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

    ListNode merge_PriorityQueueSolution_TooSlowInLeet(ListNode[] lists) {
        final Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        final ListNode head = queue.poll();

        if (head == null) {
            return null;
        }

        ListNode previousNode = head;

        while (queue.peek() != null) {
            previousNode.next = queue.poll();
            previousNode = previousNode.next;
        }

        return head;
    }
}
