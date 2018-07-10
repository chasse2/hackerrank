import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {
    public final int score;

    public Player(final int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return this.score - o.score;
    }
}

