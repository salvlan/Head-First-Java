public class DogTestDrive {
    public static void main(String[] args) {

        Dog Fido = new Dog();
        Fido.size = 70;
        Dog Fuffi = new Dog();
        Fuffi.size = 8;
        Dog Rex = new Dog();
        Rex.size = 35;

        Fido.bark();
        Fuffi.bark();
        Rex.bark();
    }
}

public class Dog {

    int size;
    String name;

    void bark() {
        if (size > 60) {
            System.out.println("Wooof! Woof!");
        } else if (size > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}
