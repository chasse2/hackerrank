package designpattern.visitor;

import org.junit.Test;

public class VisitorTest {

    @Test
    public final void test() {
        final BreakfastVisitor breakfastVisitor = new BreakfastVisitor();
        final LunchVisitor lunchVisitor = new LunchVisitor();

        final Animal[] animals = { new Elephant(), new Kangeroo() };

        for (Animal animal : animals) {
            animal.accept(breakfastVisitor);
        }

        for (Animal animal : animals) {
            animal.accept(lunchVisitor);
        }
    }
}

