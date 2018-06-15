package designpattern.abstractfactory;

import org.junit.Test;

import static org.junit.Assert.*;

public class GadgetFactoryFactoryTest {
    private final GadgetFactoryFactory factoryFactory = new GadgetFactoryFactory();

    @Test
    public void testLinuxGadgetFactory() {
        final GadgetFactory gadgetFactory = factoryFactory.create("Linux");

        final Button button = gadgetFactory.makeButton();
        final TextField textField = gadgetFactory.makeTextField();

        assertEquals(LinuxButton.class, button.getClass());
        assertEquals(LinuxTextField.class, textField.getClass());
    }

    @Test
    public void testWindowsGadgetFactory() {
        final GadgetFactory gadgetFactory = factoryFactory.create("Windows");

        final Button button = gadgetFactory.makeButton();
        final TextField textField = gadgetFactory.makeTextField();

        assertEquals(WindowsButton.class, button.getClass());
        assertEquals(WindowsTextField.class, textField.getClass());
    }
}