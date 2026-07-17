package LLD.DesignPatterns.Structural.Decorator;

public class BaseCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Base Coffee ";
    }

    @Override
    public double getCost() {
        return 20.0;
    }
}
