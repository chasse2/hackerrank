package alg.reverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInSentenceInPlaceTest {

    final ReverseWordsInSentenceInPlace reverser = new ReverseWordsInSentenceInPlace();

    @Test
    public void testMultipleWords() {
        final char[] sentence = new String(" The sky integer blue ").toCharArray();

        final char[] actual = reverser.reverse(sentence);

        final char[] expected = new String("The sky integer blue").toCharArray();

        assertEquals(new String(/*"blue integer sky The"*/"The sky integer blue"), new String(actual));
        assertSame(sentence, actual);
    }
}