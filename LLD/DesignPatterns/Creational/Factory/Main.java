package LLD.DesignPatterns.Creational.Factory;

public class Main {

    public static void main(String... args){

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.shape("Circle");
        shape.what();


    }
}
