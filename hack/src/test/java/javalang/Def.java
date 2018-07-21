package javalang;

public class Def implements Abc {
    @Override
    public void runAway() {
        Abc.super.runAway();
    }

    public void comeBack() {
        Abc.super.runAway();
    }
}
