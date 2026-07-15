package LLD.DesignPatterns.Creational.Builder;



public class Pizza {

    private final Size size;
    private final Crust crust;
    private final boolean extraCheese;
    private final int quantity;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.extraCheese = builder.extraCheese;
        this.quantity = builder.quantity;
    }

    public static class Builder {

        // Mandatory fields
        private Size size;
        private Crust crust;

        // Optional fields
        private boolean extraCheese;
        private int quantity = 1;

        public Builder(Size size, Crust crust) {
            this.size = size;
            this.crust = crust;
        }

        public Builder extraCheese() {
            this.extraCheese = true;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}