package LLD.DesignPatterns.Creational.AbstractFactory;

public class WindowsGUIFactory implements GUIFactory
{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckBox();
    }
}
