package designpattern.abstractfactory;

public class GadgetFactoryFactory {
    public GadgetFactory create(final String type) {
        switch (type) {
            case "Linux":
                return new LinuxGadgetFactory();
            case "Windows":
                return new WindowsGadgetFactory();
        }

        throw new IllegalArgumentException("Invalid gadget factory type: " + type);
    }
}
