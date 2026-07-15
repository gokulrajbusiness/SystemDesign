package LLD.DesignPatterns.Creational.AbstractFactory;

public class MacGuiFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckBox();
    }
}
