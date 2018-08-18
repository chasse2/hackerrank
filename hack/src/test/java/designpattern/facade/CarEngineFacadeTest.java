package designpattern.facade;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarEngineFacadeTest {

    @Test
    public void test() {
        final CarEngineFacade facade = new CarEngineFacade();
        facade.startEngine();
        facade.stopEngine();
    }
}