package LLD.DesignPatterns.Creational.Builder;

//Builder is always innerClass
//Builder is always static
//use builder object to create pizza object
//pizza constructor is private
//pizza fields are final

public class Main {

    public static void main(String[] args){

        Pizza pizza = new Pizza.Builder(Size.LARGE, Crust.NORMAL)
                .extraCheese()
                .quantity(2)
                .build();



    }
}
