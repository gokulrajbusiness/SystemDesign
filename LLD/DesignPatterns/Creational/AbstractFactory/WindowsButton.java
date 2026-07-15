package LLD.DesignPatterns.Creational.AbstractFactory;

public class WindowsButton implements Button{

    @Override
    public void printButton()
    {
        System.out.println("WindowsButton");
    }
}
