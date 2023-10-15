import java.io.*;

public class GameSaverTest {
    public static void main (String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow","sword","dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands","big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells","invisibility"});

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream ("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        one=null;
        two=null;
        three=null;

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream ("Game.ser"));
            GameCharacter oneRestored = (GameCharacter) is.readObject();
            GameCharacter twoRestored = (GameCharacter) is.readObject();
            GameCharacter threeRestored = (GameCharacter) is.readObject();
            is.close();

            System.out.println ("Character one: " + oneRestored.getType() + ", power: " + oneRestored.getPower() + ", weapons: " + oneRestored.getWeapons());
            System.out.println ("Character two: " + twoRestored.getType() + ", power: " + twoRestored.getPower() + ", weapons: " + twoRestored.getWeapons());
            System.out.println ("Character three: " + threeRestored.getType() + ", power: " + threeRestored.getPower() + ", weapons: " + threeRestored.getWeapons());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
