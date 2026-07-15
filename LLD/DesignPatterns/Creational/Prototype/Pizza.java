package LLD.DesignPatterns.Creational.Prototype;

public class Pizza implements Prototype<Pizza> {

    private String size;
    private boolean extraCheese;
    private int quantity;

    public Pizza(String size,
                 boolean extraCheese,
                 int quantity) {

        this.size = size;
        this.extraCheese = extraCheese;
        this.quantity = quantity;
    }

    @Override
    public Pizza clone() {
        return new Pizza(
                this.size,
                this.extraCheese,
                this.quantity
        );
    }
}
