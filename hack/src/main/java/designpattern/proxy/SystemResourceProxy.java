package designpattern.proxy;

public class SystemResourceProxy implements SystemResource {
    private final SystemResource systemResource;

    public SystemResourceProxy() {
        systemResource = new ProtectedSystemResource();
    }

    @Override
    public void doSomething() {
        systemResource.doSomething();
    }
}
