package alg.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie (i.e. prefix ordered tree), useful for auto-complete.
 *
 * Complexity of insert is O(n), where n is the length of the word.
 * Complexity of containsWord is O(n), where n is the length of the word.
 * Complexity of containsPrefix is O(n), where n is the length of the prefix.
 */
public class Trie {
    final private TrieNode root;

    private class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        private String content;
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

        for (int i = 0; i < word.length(); i++) {
            node = node.children.computeIfAbsent(word.charAt(i), x -> new TrieNode());
        }

        node.isWord = true;
    }

    public final boolean containsWord(final String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            final Character character = word.charAt(i);

            if (!node.children.containsKey(character)) {
                return false;
            }

            node = node.children.get(character);
        }

        return node.isWord;
    }

    public final boolean containsPrefix(final String prefix) {
        TrieNode node = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            final Character character = prefix.charAt(i);

            if (!node.children.containsKey(character)) {
                return false;
            }

            node = node.children.get(character);
        }

        return true;
    }
}
