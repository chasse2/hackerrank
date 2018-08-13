package alg.combinations;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationsTest {
    final Combinations instance = new Combinations("abcde"/*"123"*/);

    @Test
    public void combine() {
        instance.combine();
    }
}