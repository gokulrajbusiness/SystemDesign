package LLD.DesignPatterns.Structural.Decorator;

public class SugarDecorator extends CoffeeDecorator{

    SugarDecorator(Coffee coffee)
    {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+"Sugar ";
    }

    @Override
    public double getCost() {
        return coffee.getCost()+ 3.0;
    }
}
