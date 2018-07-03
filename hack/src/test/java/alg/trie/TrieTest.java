package alg.trie;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testInsert() {
        final Trie trie = new Trie();

        trie.insert("cat");

        assertTrue(trie.containsWord("cat"));
        assertTrue(trie.containsPrefix("cat"));

        assertFalse(trie.containsWord("ca"));
        assertTrue(trie.containsPrefix("ca"));

        assertFalse(trie.containsWord("c"));
        assertTrue(trie.containsPrefix("c"));
    }

    @Test
    public void testAutoComplete() {
        final Trie trie = new Trie();

        trie.insert("bat");
        trie.insert("batan");
        trie.insert("battle");
        trie.insert("battles");

        assertEquals(Arrays.toString(new String[]{ "batan", "battle", "battles"}),
                Arrays.toString(trie.autocomplete("bat")));

        assertEquals(Arrays.toString(new String[]{ "battle", "battles"}),
                Arrays.toString(trie.autocomplete("batt")));
    }
}