package javalang.datastruct;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class JavaComparator {
    class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    class Checker implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {

            if (o1.score != o2.score) {
                return o2.score - o1.score;
            }

            return o1.name.compareTo(o2.name);
        }
    }

    @Test
    public final void test() {
        Player[] players = new Player[5];
        Checker checker = new Checker();

        int n = 0;

        players[n++] = new Player("amy", 100);
        players[n++] = new Player("david", 100);
        players[n++] = new Player("heraldo", 50);
        players[n++] = new Player("aakansha", 75);
        players[n] = new Player("aleksa", 150);

        Arrays.sort(players, checker);

        for (Player player : players){
            System.out.printf("%s %s\n", player.name, player.score);
        }
    }
}
