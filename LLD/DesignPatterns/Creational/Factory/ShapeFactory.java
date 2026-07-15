package LLD.DesignPatterns.Creational.Factory;

public class ShapeFactory {

    Shape shape(String what) {

   return switch(what)
    {
       case  "Circle"-> new Circle();
        case "Rectangle"-> new Rectangle();
        default -> throw new IllegalStateException("Unexpected value: " + what);
    };
}

}
