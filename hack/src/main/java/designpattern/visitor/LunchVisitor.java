package designpattern.visitor;

public class LunchVisitor implements Visitor {

    @Override
    public void visit(final Animal animal) {
        System.out.println("Feed lunch to " + animal.getType());
    }
}
