package designpattern.abstractfactory;

public class LinuxGadgetFactory implements GadgetFactory {
    @Override
    public Button makeButton() {
        return new LinuxButton();
    }

    @Override
    public TextField makeTextField() {
        return new LinuxTextField();
    }
}
