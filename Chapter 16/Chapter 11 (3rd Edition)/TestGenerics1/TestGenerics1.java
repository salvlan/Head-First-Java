import java.util.*;

public class TestGenerics1 {
    public static void main(String[] args) {

        List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
        takeAnimals(animals);

        System.out.print("\n");

        List<Dog> dogs = List.of(new Dog(), new Dog());
        takeAnimals(dogs);

    }

    public static void takeAnimals(List<? extends Animal> animals){
        for(Animal a: animals){
            a.eat();
        }
    }

}
