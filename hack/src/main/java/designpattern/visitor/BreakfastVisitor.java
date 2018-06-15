package designpattern.visitor;

public class BreakfastVisitor implements Visitor {

    @Override
    public void visit(final Animal animal) {
        System.out.println("Feed breakfast to " + animal.getType());
    }
}
