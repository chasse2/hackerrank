package designpattern.proxy;

public class ProtectedSystemResource implements SystemResource {
    public ProtectedSystemResource() {
        // May have some expensive initialization
    }

    @Override
    public void doSomething() {
    }
}
