public class GoodDogTestDrive {
    public static void main(String[] args) {

        GoodDog Fido = new GoodDog();
        Fido.setSize(70);
        GoodDog Fuffi = new GoodDog();
        Fuffi.setSize(8);
        GoodDog Rex = new GoodDog();
        Rex.setSize(35);

        System.out.println("Fido: " + Fido.getSize());
        System.out.println("Fuffi: " + Fuffi.getSize());
        System.out.println("Rex: " + Rex.getSize());

        Fido.bark();
        Fuffi.bark();
        Rex.bark();
    }
}

public class GoodDog {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60) {
            System.out.println("Wooof! Wooof!");
        } else if (size > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}
