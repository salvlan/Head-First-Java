public class ElectricGuitarTestDrive {
    public static void main(String[] args) {

        ElectricGuitar thePower = new ElectricGuitar();

        thePower.setBrand("Yamaha");
        thePower.getBrand();
        thePower.setNumOfPickups(6);
        thePower.getNumOfPickups();
    }
}

public class ElectricGuitar {

    String brand;
    int numOfPickups;
    boolean rockStarUsesIt;

    String getBrand() {
        return brand;
    }

    void setBrand (String aBrand) {
        brand = aBrand;
    }

    int getNumOfPickups() {
        return numOfPickups;
    }

    void setNumOfPickups(int num) {
        numOfPickups = num;
    }
}
