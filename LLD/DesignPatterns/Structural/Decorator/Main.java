package LLD.DesignPatterns.Structural.Decorator;

public class Main {
    public static void main(String... args){

        Coffee coffee = new SugarDecorator(new MilkDecorator(new BaseCoffee()));

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());

    }
}
