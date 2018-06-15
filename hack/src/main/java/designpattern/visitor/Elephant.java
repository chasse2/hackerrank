package designpattern.visitor;

public class Elephant implements Animal {

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getType() {
        return "Elephant";
    }
}
