public class TapeDeckTestDrive {
    public static void main(String[] args) {

        TapeDeck t = new TapeDeck();
        t.canRecord = true;
        t.playTape ();

        if (t.canRecord == true) {
            t.recordTape();
        }
    }
}

public class TapeDeck {

    boolean canRecord = false;

    void playTape() {
        System.out.println("tape playng");
    }

    void recordTape() {
        System.out.println("tape recording");
    }
}
