package alg.find;

import java.util.*;

/**
 * Find the longest common prefix amongst given array of strings.
 *
 * Algo builds a tree, then performs breadth-first search to find longest prefix
 * (a prefix is complete at the node where number of children is not 1).
 */
public class LongestCommonPrefix {
    private class Node {
        public final Map<Character, Node> children = new HashMap<>();
        public final String value;

        public Node() {
            this.value = "";
        }

        public Node(final String value) {
            this.value = value;
        }

        public final Node addChild(final Character c) {
            if (!children.containsKey(c)) {
                children.put(c, new Node(this.value + c));
            }

            return children.get(c);
        }
    }

    private class Trie {
        public final Node root = new Node();

        public final void insert(final String s) {
            Node node = this.root;

            for (Character c : s.toCharArray()) {
                node = node.addChild(c);
            }
        }
    }

    public final String find(final String[] items) {
        final Trie trie = new Trie();

        for (String item : items) {
            trie.insert(item);
        }

        final Queue<Node> queue = new ArrayDeque<>();
        queue.add(trie.root);
        String longestPrefix = "";

        while (!queue.isEmpty()) {
            final Node node = queue.remove();

            Collection<Node> children = node.children.values();

            if (children.size() != 1) {
                if (node.value.length() > longestPrefix.length()) {
                    longestPrefix = node.value;
                }

                continue;
            }

            // There is only one child to add ...
            children.forEach(x -> queue.add(x));
        }

        return longestPrefix;
    }
}
