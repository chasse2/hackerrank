package alg.trie;

import java.util.*;

/**
 * Trie (i.e. prefix ordered tree), useful for auto-complete.
 *
 * Complexity of insert is O(n), where n is the length of the word.
 * Complexity of autocomplete is O(n) + O(mi), where n is the length of the prefix,
 * and mi is the length of the ith autocompleted word.
 * Complexity of containsWord is O(n), where n is the length of the word.
 * Complexity of containsPrefix is O(n), where n is the length of the prefix.
 */
public class Trie {
    final private TrieNode root;

    private class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private String word;
        private boolean isWord;
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public final void insert(final String word) {
        if (word.isEmpty()) {
            return;
        }

        TrieNode node = this.root;

        for (Character character : word.toCharArray()) {
            node = node.children.computeIfAbsent(character, x -> new TrieNode());
        }

        node.word = word;
        node.isWord = true;
    }


    public final String[] autocomplete(final String word) {
        final TrieNode terminalNode = findTerminalNode(word);

        if (terminalNode == null) {
            return new String[0];
        }

        final List<String> words = new LinkedList<>();
        final Deque<TrieNode> queue = new ArrayDeque<>();
        queue.add(terminalNode);

        while (!queue.isEmpty()) {
            final TrieNode node = queue.poll();

            for (TrieNode child : node.children.values()) {
                if (child.isWord) {
                    words.add(child.word);
                }
                queue.add(child);
            }
        }

        final String[] sortedWords = words.toArray(new String[0]);
        Arrays.sort(sortedWords);
        return sortedWords;
    }

    private final TrieNode findTerminalNode(final String prefix) {
        TrieNode node = this.root;

        for (Character character : prefix.toCharArray()) {
            node = node.children.get(character);

            if (node == null) {
                return null;
            }
        }

        return node;
    }

    public final boolean containsWord(final String word) {
        final TrieNode terminalNode = this.findTerminalNode(word);

        if (terminalNode == null) {
            return false;
        }

        return terminalNode.isWord;
    }

    public final boolean containsPrefix(final String prefix) {
        final TrieNode terminalNode = this.findTerminalNode(prefix);

        if (terminalNode == null) {
            return false;
        }

        return true;
    }
}
