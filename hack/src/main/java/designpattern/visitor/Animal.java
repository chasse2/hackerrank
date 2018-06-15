package designpattern.visitor;

public interface Animal {

    void accept(final Visitor visitor);

    String getType();
}
