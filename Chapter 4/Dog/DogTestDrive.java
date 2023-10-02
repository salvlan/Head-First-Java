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
