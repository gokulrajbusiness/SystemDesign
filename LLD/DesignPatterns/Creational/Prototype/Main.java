package LLD.DesignPatterns.Creational.Prototype;

import java.util.HashMap;
import java.util.Map;
//cloning an already created object because sometime creating a new object is extremely resource consuming
//DatabaseConnection
//Image Processing Config
//Game Characters
//Document Templates
//Email Templates
//UI Components
public class Main {

    public static void main(String[] args)
    {

        Map<String, Pizza> prototypes = new HashMap<>();
        prototypes.put(
                "Veg",
                new Pizza("Large", true, 1)
        );

        prototypes.put(
                "CheeseBurst",
                new Pizza("Medium", true, 1)
        );

        Pizza prototypePizza = prototypes.get("Veg").clone();

    }
}
