package javalang.foo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Enumeration {

    public enum Color1 {
        BLUE,
        PURPLE,
        RED;
    }

    public enum Color2 {
        BLUE(0, 0, 255),
        PURPLE(128, 0, 128),
        RED(255, 0, 0);

        public final int R;
        public final int G;
        public final int B;

        Color2(final int R, final int G, final int B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }
    }

    @Test
    public final void testColor1() {
        final Color1 color = Color1.PURPLE;
        assertEquals(color, Color1.PURPLE);
    }

    @Test
    public final void testColor2() {
        final Color2 color = Color2.PURPLE;
        assertEquals(128, color.R);
        assertEquals(0, color.G);
        assertEquals(128, color.B);
    }
}
