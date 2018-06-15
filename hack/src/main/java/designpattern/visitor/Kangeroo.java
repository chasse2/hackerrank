package designpattern.visitor;

public class Kangeroo implements Animal {

    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getType() {
        return "Kangeroo";
    }
}
