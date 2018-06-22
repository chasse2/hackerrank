package designpattern.template;

public abstract class BaseBuilder {
    public final void build() {
        doStep1();
        doStep2();
    }

    public abstract void doStep1();
    public abstract void doStep2();
}
