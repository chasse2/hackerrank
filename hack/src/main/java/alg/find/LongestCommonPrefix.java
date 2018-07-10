package alg.find;

import javax.print.DocFlavor;
import java.util.*;

/**
 * Find the longest common prefix amongst given array of strings.
 *
 * Algo builds a tree, then performs breadth-first search to find longest prefix
 * (a prefix is complete at the node where number of children is not 1).
 */
public class LongestCommonPrefix {
    private class Node {
        final Map<Character, Node> children = new HashMap<>();
        final String value;
        boolean isTerminal = false;

        Node() {
            this.value = "";
        }

        Node(final String value) {
            this.value = value;
        }

        final Node addChild(final Character c) {
            if (!children.containsKey(c)) {
                children.put(c, new Node(this.value + c));
            }

            return children.get(c);
        }

        final void setTerminal() {
            this.isTerminal = true;
        }
    }

    private class Trie {
        final Node root = new Node();

        final void insert(final String s) {
            Node node = this.root;

            if (s.isEmpty()) {
                return;
            }

            for (Character c : s.toCharArray()) {
                node = node.addChild(c);
            }

            node.setTerminal();
        }
    }

    public final String find(final String[] items) {
        final Trie trie = new Trie();

        for (String item : items) {
            if (item.isEmpty()) {
                return "";
            }

            trie.insert(item);
        }

        final Queue<Node> queue = new ArrayDeque<>();
        queue.add(trie.root);
        String longestPrefix = "";

        while (!queue.isEmpty()) {
            final Node node = queue.remove();

            if (node.isTerminal) {
                return node.value;
            }

            Collection<Node> children = node.children.values();

            if (children.size() != 1) {
                return node.value;
            }

            // There is only one child to add ...
            children.forEach(x -> queue.add(x));
        }

        return longestPrefix;
    }
}
