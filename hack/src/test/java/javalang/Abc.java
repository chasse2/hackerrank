package javalang;

public interface Abc {
    default void runAway() {
        System.out.println("ABC");
    }
}
