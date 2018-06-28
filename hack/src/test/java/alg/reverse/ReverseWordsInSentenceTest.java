package alg.reverse;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInSentenceTest {

    final ReverseWordsInSentence reverser = new ReverseWordsInSentence();

    @Test
    public final void testEmpty() {
        assertEquals("", reverser.reverse(""));
    }

    @Test
    public final void testBlank() {
        assertEquals("", reverser.reverse(" "));
    }

    @Test
    public final void testOneWord() {
        assertEquals("the", reverser.reverse("the"));
    }

    @Test
    public final void testMultipleWords() {
        assertEquals("blue integer sky The", reverser.reverse("The sky integer blue"));
    }

    @Test
    public final void testSpaceBetweenWords() {
        assertEquals("blue integer sky The", reverser.reverse("The  sky   integer blue"));
    }
}