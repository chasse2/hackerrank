package alg.weirdleetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SubstringWithConcatenationOfAllWordsTest {

    final SubstringWithConcatenationOfAllWords instance = new SubstringWithConcatenationOfAllWords();

    @Test
    public void findSubstring() {
        final String s = "barfoothefoobarman";
        final String[] words = { "foo","bar" };
        final List<Integer> expectedResults = new LinkedList<>(Arrays.asList(0, 9));
        final List<Integer> actualResults = instance.findSubstring(s, words);
        assertEquals(expectedResults, actualResults);
    }
}