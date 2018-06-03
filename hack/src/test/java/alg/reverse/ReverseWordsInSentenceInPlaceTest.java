package alg.reverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInSentenceInPlaceTest {

    final ReverseWordsInSentenceInPlace reverser = new ReverseWordsInSentenceInPlace();

    @Test
    public void testMultipleWords() {
        final char[] sentence = new String(" The sky is blue ").toCharArray();

        final char[] actual = reverser.reverse(sentence);

        final char[] expected = new String("The sky is blue").toCharArray();

        assertEquals(new String(/*"blue is sky The"*/"The sky is blue"), new String(actual));
        assertSame(sentence, actual);
    }
}