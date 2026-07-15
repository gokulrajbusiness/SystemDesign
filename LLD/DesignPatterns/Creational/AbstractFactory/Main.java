package LLD.DesignPatterns.Creational.AbstractFactory;

//Creates a family of object
public class Main {

public static void main(String[] args) {
    GUIFactory guiFactory = new WindowsGUIFactory();

    Button button = guiFactory.createButton();
    Checkbox checkbox = guiFactory.createCheckbox();

    button.printButton();
    checkbox.checkPrint();
}

}
