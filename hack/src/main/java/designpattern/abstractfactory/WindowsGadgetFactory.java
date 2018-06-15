package designpattern.abstractfactory;

public class WindowsGadgetFactory implements GadgetFactory {
    @Override
    public Button makeButton() {
        return new WindowsButton();
    }

    @Override
    public TextField makeTextField() {
        return new WindowsTextField();
    }
}
