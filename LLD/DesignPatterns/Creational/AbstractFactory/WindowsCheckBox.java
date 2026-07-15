package LLD.DesignPatterns.Creational.AbstractFactory;

public class WindowsCheckBox implements Checkbox{


    @Override
    public void checkPrint() {
        System.out.println("WindowsCheckbox");
    }
}
