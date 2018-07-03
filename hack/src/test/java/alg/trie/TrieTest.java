package alg.trie;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void test() {
        final Trie trie = new Trie();

        trie.insert("cat");

        assertTrue(trie.containsWord("cat"));
        assertTrue(trie.containsPrefix("cat"));

        assertFalse(trie.containsWord("ca"));
        assertTrue(trie.containsPrefix("ca"));

        assertFalse(trie.containsWord("c"));
        assertTrue(trie.containsPrefix("c"));
    }
}